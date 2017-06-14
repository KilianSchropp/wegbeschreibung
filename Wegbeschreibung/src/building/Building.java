package building;

import java.util.ArrayList;
import java.util.List;

public class Building
{
    

    private Floor firstFloor;
    private Floor secondFloor;
    private Floor groundFloor;
    
    public void setFirstFloor(Floor firstFloor){this.firstFloor = firstFloor;}

    public void setSecondFloor(Floor secondFloor){this.secondFloor = secondFloor;}

    public void setGroundFloor(Floor groundFloor){this.groundFloor = groundFloor;}
    
    public List<GraphPoint> getAllRooms()
    {
        List<GraphPoint> allRooms = new ArrayList<GraphPoint>();
        allRooms.addAll(firstFloor.getRoomList());
        allRooms.addAll(secondFloor.getRoomList());
        allRooms.addAll(groundFloor.getRoomList());
        return allRooms;
    }
    
    public Floor getResponsibeFloor(String identifier)
    {
        if(identifier != null)
        {
            if(identifier.startsWith("EG"))
            {
                return groundFloor;
            }
            else if(identifier.startsWith("OG1"))
            {
                return firstFloor;
            }
            else if(identifier.startsWith("OG2"))
            {
                return secondFloor;
            }
        }
        return null;
    }
}
