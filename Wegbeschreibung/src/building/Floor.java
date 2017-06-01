package building;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class Floor
{
    static final Log LOG = LogFactory.getLog(Floor.class);
    
    String floorName = "";
    BufferedImage image;
    List<String> rooms;
    
    public List<String> getRoomList()
    {
        if(rooms==null || rooms.isEmpty())
        {
            rooms = new ArrayList<String>();
            rooms.add(floorName+ ": The Database for specific floor is empty");  
        }
        return rooms;
    }
    
    public void setRoomList(List<String> rooms)
    {
        this.rooms = rooms;
    }
    
    public BufferedImage getImage()
    {
        return image;
    }
    
    public void readImage()
    {
        //TODO exchange this implementation of the method for a database based image receiving
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
