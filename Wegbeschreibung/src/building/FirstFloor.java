package building;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class FirstFloor extends Floor
{
    static final Log LOG = LogFactory.getLog(FirstFloor.class);
    
    public FirstFloor()
    {
        this.floorName = "OG1";
        readImage();
    }
}
