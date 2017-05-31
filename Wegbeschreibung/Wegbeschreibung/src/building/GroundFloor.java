package building;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GroundFloor extends Floor
{
    static final Log LOG = LogFactory.getLog(GroundFloor.class);
    
    public GroundFloor()
    {
        this.floorName = "EG";
        readImage();
    }
}
