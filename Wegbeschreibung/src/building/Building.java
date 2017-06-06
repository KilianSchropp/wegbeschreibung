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
    
    public List<String> getAllRooms()
    {
        List<String> allRooms = new ArrayList<String>();
        allRooms.addAll(firstFloor.getRoomList());
        allRooms.addAll(secondFloor.getRoomList());
        allRooms.addAll(groundFloor.getRoomList());
        return allRooms;
    }
}
