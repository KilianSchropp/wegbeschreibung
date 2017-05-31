package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.Building;

public class PicturePanel extends JPanel
{
    static final Log LOG = LogFactory.getLog(PicturePanel.class);
    private static final long serialVersionUID = 1L;
    private Building building;
    
    public void setBuilding(Building building)
    {
        this.building = building;
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Image image = building.getFirstFloor().getImage();
        g.drawImage(image, 0, 0, this);            
    }
    
}
