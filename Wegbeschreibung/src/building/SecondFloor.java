package building;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SecondFloor extends Floor
{
    static final Log LOG = LogFactory.getLog(SecondFloor.class);
    
    public SecondFloor()
    {
        this.floorName = "OG2";
        readImage();
    }
}
