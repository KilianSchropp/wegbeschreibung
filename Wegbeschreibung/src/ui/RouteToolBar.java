package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.GraphPoint;

public class RouteToolBar extends JToolBar
{
    static final Log LOG = LogFactory.getLog(RouteToolBar.class);

    private static final long serialVersionUID = 1L;
    private JComboBox<GraphPoint> roomComboboxRight;
    private JComboBox<GraphPoint> roomComboboxLeft;
    private JButton startRoute;
    
    public void init()
    {
        add(roomComboboxLeft);
        add(startRoute);
        add(roomComboboxRight);
    }
    
    public void setRoomComboboxRight(JComboBox<GraphPoint> roomComboboxRight){this.roomComboboxRight = roomComboboxRight;}
    
    public void setRoomComboboxLeft(JComboBox<GraphPoint> roomComboboxLeft){this.roomComboboxLeft = roomComboboxLeft;}
    
    public void setStartRoute(JButton startRoute){this.startRoute = startRoute;}
}
