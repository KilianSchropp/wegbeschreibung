package building;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import database.Database;

public abstract class Floor
{
    static final Log LOG = LogFactory.getLog(Floor.class);
    
    String floorName = "";
    BufferedImage image;
    Database sql;
    List<String> rooms;
    List<Room> roomsObj = new ArrayList<>();
    
    public void init()
    {
        createRoomList();
    }
    
    public List<String> getRoomList()
    {
        if(rooms==null || rooms.isEmpty())
        {
            rooms = new ArrayList<String>();
            rooms.add(floorName+ ": The Database for specific floor is empty");  
        }
        return rooms;
    }
    
    public void setSql(Database sql){this.sql = sql;}
    
    public void createRoomList(){rooms = sql.getRoomsForFloor(floorName);}
    
    public List<Room> getRoomsObj(){return roomsObj;}

    public BufferedImage getImage(){return image;}
    
    public void createLinkedRoomObjectsList()
    {
        for(String roomName : rooms)
        {
            List<String> neighbours = sql.getNeighboursOfRoom(roomName);
            List<Double> points = sql.getCoordinatesOfRoom(roomName);
            Room roomObj = new Room(roomName, neighbours, points);
            roomsObj.add(roomObj);
        }
        
        for(Room room : roomsObj)
        {
            List<String> neigbours = room.getNeighboursAsString();
            for(String neigbour : neigbours)
            {
                for(Room room2: roomsObj)
                {
                    String name = room2.getName();
                    if(name.equals(neigbour))
                    {
                        room.addToNeighbours(room2);
                        LOG.trace("The Room object " + room.getName() + " is now linked with the room"
                                + " Object " + room2.getName() + ".");
                    }
                }
            }
            LOG.trace("Every room knows its neighbour now as an Object and not only as String.");
        }
    }
    
    public void readImage()
    {
        //TODO expand this implementation of the method for a database based image receiving
        String fileSep = File.separator;
        try 
        {          
            File file = new File("images-Backup"+fileSep+floorName+".png");
            LOG.info(file.getAbsolutePath());
            this.image = ImageIO.read(file);
        } 
        catch (IOException ex) 
        {
              LOG.info("An error occured when trying to open the file." , ex);
        }
    }
}
