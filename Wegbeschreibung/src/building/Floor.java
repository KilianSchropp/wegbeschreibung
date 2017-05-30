package building;

import java.util.ArrayList;
import java.util.List;

public class Floor
{
    List<String> rooms;
    
    public List<String> getRoomList()
    {
        if(rooms.isEmpty())
        {
            rooms = new ArrayList<String>();
            rooms.add("test");  
        }
        return rooms;
    }
    
    public void setRoomList(List<String> rooms)
    {
        this.rooms = rooms;
    }
}
