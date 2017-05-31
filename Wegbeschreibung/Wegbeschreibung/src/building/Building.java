package building;

import java.util.ArrayList;
import java.util.List;

public class Building
{
    private Floor firstFloor;
    private Floor secondFloor;
    private Floor groundFloor;
    
    public Building()
    {
        firstFloor = new FirstFloor();
        secondFloor = new SecondFloor();
        groundFloor = new GroundFloor();
    }
    
    public Floor getFirstFloor(){return firstFloor;}
    
    public Floor getSecondFloor(){return secondFloor;}
    
    public Floor getGroundFloor(){return groundFloor;}
    
    public List<String> getAllRooms()
    {
        List<String> allRooms = new ArrayList<String>();
        allRooms.addAll(firstFloor.getRoomList());
        allRooms.addAll(secondFloor.getRoomList());
        allRooms.addAll(groundFloor.getRoomList());
        return allRooms;
    }
}
