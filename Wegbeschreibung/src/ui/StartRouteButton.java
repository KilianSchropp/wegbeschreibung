package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.Building;
import building.Floor;
import calculator.CalculateRoute;

public class StartRouteButton extends JButton implements ActionListener
{
    private static final long serialVersionUID = 1L;
    static final Log LOG = LogFactory.getLog(StartRouteButton.class);
    JComboBox<String> startCombobox;
    JComboBox<String> destinationCombobox;
    Building building;
    
    public StartRouteButton(String text)
    {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        CalculateRoute calc = new CalculateRoute();
        String startRootm = startCombobox.getSelectedItem().toString();
        String destinationRoom = destinationCombobox.getSelectedItem().toString();
        Floor startFloor = building.getResponsibeFloor(startRootm);
        Floor endFloor = building.getResponsibeFloor(destinationRoom);
       
    }
    
}
