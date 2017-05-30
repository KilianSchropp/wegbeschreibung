package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

public class RouteToolBar extends JToolBar
{
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
