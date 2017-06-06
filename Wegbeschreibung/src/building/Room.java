package building;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Room
{
    static final Log LOG = LogFactory.getLog(Room.class);
    public int x,y;
    protected List<Room> rooms = new ArrayList<>();
    private String name;
    private List<String> neighbours;

    public Room(String name, List<String> neighbours, List<Integer> points)
    {
        this.name = name;
        this.neighbours = neighbours;
        this.x = points.get(0);
        this.y = points.get(1);
    }
    
    public List<String> getNeighbours()
    {
        return neighbours;
    }
    
    public String getName()
    {
        return name;
    }

    public void addToNeighbours(Room room)
    {
        this.rooms.add(room);
    }
}
