package ui;

import java.util.List;

import javax.swing.JComboBox;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.Building;

public class RoomCombobox extends JComboBox<String>
{
    private static final long serialVersionUID = 1L;
    static final Log LOG = LogFactory.getLog(RoomCombobox.class);
    private Building building;
    
    public void setBuilding(Building building)
    {
        this.building = building;
    }

    public void init(){addFloor();}
    
    public void addFloor()
    {
        List<String> rooms = building.getAllRooms();
        for(String room : rooms)
        {
            addItem(room);
        }
    }
 
}
