package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

public class RouteToolBar extends JToolBar
{
    private static final long serialVersionUID = 1L;
    private JComboBox<String> rightRoom;
    private JComboBox<String> leftRoom;
    private JButton startRoute;
    
    public void setRightRoom(JComboBox<String> rightRoom)
    {
        this.rightRoom = rightRoom;
    }
    
    public void setLeftRoom(JComboBox<String> rightRoom)
    {
        this.rightRoom = rightRoom;
    }
    
    public void setStartRoute(JButton startRoute)
    {
        this.startRoute = startRoute;
    }
}
