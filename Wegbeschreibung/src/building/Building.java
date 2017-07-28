package building;

import java.util.ArrayList;
import java.util.List;

public class Building
{
    private Floor firstFloor;
    private Floor secondFloor;
    private Floor groundFloor;
    private List<GraphPoint> allRooms;
    private List<StairwayGraphPoint> allStairSiblings = new ArrayList<>();
    
    public void init()
    {
        fillAllRooms();
        pairAllStairSiblings();
    }
    
    private void fillAllRooms()
    {
        allRooms = new ArrayList<GraphPoint>();
        allRooms.addAll(firstFloor.getRoomList());
        allRooms.addAll(secondFloor.getRoomList());
        allRooms.addAll(groundFloor.getRoomList()); 
    }
    
    private void pairAllStairSiblings()
    {
        List<GraphPoint> allPoints = new ArrayList<>();
        allPoints.addAll(firstFloor.getGraphPoints());
        allPoints.addAll(secondFloor.getGraphPoints());
        allPoints.addAll(groundFloor.getGraphPoints());
        
        for(GraphPoint point : allPoints)
        {
            if(point instanceof StairwayGraphPoint)
            {
                allStairSiblings.add((StairwayGraphPoint)point);
            }
        }
        
        for(StairwayGraphPoint stair : allStairSiblings)
        {
            for(StairwayGraphPoint sibling : allStairSiblings)
            {
                if(sibling.getName().equals(stair.getName()))
                {
                    stair.addSibling(sibling);
                }
            }
        }
    }
    
    public void setVisibleForSelectedFloors(Floor floor1, Floor floor2)
    {
        floor1.setSelectedToDraw(true);
        floor2.setSelectedToDraw(true);
        
        List<Floor> tempList = new ArrayList<>();
        tempList.add(floor1);
        tempList.add(floor2);
        
        if(!tempList.contains(groundFloor))
        {
            groundFloor.setSelectedToDraw(false);
        }
        
        if(!tempList.contains(secondFloor))
        {
            secondFloor.setSelectedToDraw(false);
        }
        
        if(!tempList.contains(firstFloor))
        {
            firstFloor.setSelectedToDraw(false);
        }
    }
    
    public void setFirstFloor(Floor firstFloor){this.firstFloor = firstFloor;}

    public void setSecondFloor(Floor secondFloor){this.secondFloor = secondFloor;}

    public void setGroundFloor(Floor groundFloor){this.groundFloor = groundFloor;}
    
    public List<GraphPoint> getAllRooms(){return allRooms;}
    
    public List<StairwayGraphPoint> getAllStairSiblings(){return allStairSiblings;}
}
