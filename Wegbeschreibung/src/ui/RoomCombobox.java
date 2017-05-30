package ui;

import java.util.List;

import javax.swing.JComboBox;

import building.Floor;

public class RoomCombobox extends JComboBox<String>
{
    private Floor floor;
    private static final long serialVersionUID = 1L;
    
    public void setFloor(Floor floor)
    {
        this.floor = floor;
    }
    
    public void addFloor()
    {
        List<String> rooms = floor.getRoomList();
        for(String room : rooms)
        {
            addItem(room);
        }
    }

}
