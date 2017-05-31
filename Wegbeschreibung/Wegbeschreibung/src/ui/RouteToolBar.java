package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RouteToolBar extends JToolBar
{
    static final Log LOG = LogFactory.getLog(RouteToolBar.class);

    private static final long serialVersionUID = 1L;
    private JComboBox<String> roomComboboxRight;
    private JComboBox<String> roomComboboxLeft;
    private JButton startRoute;
    
    public void init()
    {
        add(roomComboboxLeft);
        add(startRoute);
        add(roomComboboxRight);
    }
    
    public void setRoomComboboxRight(JComboBox<String> roomComboboxRight){this.roomComboboxRight = roomComboboxRight;}
    
    public void setRoomComboboxLeft(JComboBox<String> roomComboboxLeft){this.roomComboboxLeft = roomComboboxLeft;}
    
    public void setStartRoute(JButton startRoute){this.startRoute = startRoute;}
}
