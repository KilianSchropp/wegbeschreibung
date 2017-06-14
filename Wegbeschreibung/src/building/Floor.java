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
    List<GraphPoint> rooms = new ArrayList<GraphPoint>();
    List<GraphPoint> graphPoints = new ArrayList<>();

    public void init()
    {
        createGraphPointList();
        createRoomList();
        createLinkedGraphPointObjectsList();
    }
    
    public List<GraphPoint> getRoomList()
    {
        return rooms;
    }
    
    public List<GraphPoint> getGraphPoints(){return graphPoints;}
    
    public void setSql(Database sql){this.sql = sql;}
    
    public void createRoomList()
    {
        for(GraphPoint point : graphPoints)
        {
            if(point.isRoom())
            {
                point.setFloorname(floorName);
                rooms.add(point);
            }
        }
    }
    
    public void createGraphPointList()
    {
        this.graphPoints = sql.getGraphPointsForFloor(floorName);
    }

    public BufferedImage getImage(){return image;}
    
    public void createLinkedGraphPointObjectsList()
    {   
        for(GraphPoint point : graphPoints)
        {
            List<String> neigbours = point.getNeighboursAsString();
            for(String neigbour : neigbours)
            {
                for(GraphPoint point2: graphPoints)
                {
                    String name = point2.getName();
                    if(name.equals(neigbour))
                    {
                        point.addToNeighbours(point2);
                        LOG.trace("The Room object " + point.getName() + " is now linked with the room"
                                + " Object " + point2.getName() + ".");
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

    public GraphPoint getGraphPointWithName(String startRoom)
    {
        GraphPoint answer = null;
        for(GraphPoint point : graphPoints)
        {
            if(point.getName().equals(startRoom))
            {
                answer = point;
                break;
            }
        }
        return answer;
        
    }
}
