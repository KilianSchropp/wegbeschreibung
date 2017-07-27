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
    
    public void setFirstFloor(Floor firstFloor){this.firstFloor = firstFloor;}

    public void setSecondFloor(Floor secondFloor){this.secondFloor = secondFloor;}

    public void setGroundFloor(Floor groundFloor){this.groundFloor = groundFloor;}
    
    public List<GraphPoint> getAllRooms(){return allRooms;}
    
    public List<StairwayGraphPoint> getAllStairSiblings(){return allStairSiblings;}
}
