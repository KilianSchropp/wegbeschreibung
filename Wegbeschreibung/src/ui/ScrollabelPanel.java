package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import building.Floor;

public class ScrollabelPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private Floor floor;
    private BufferedImage image;
    
    public void init()
    {
        this.image = floor.getImage();
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }
    
    public void setFloor(Floor floor)
    {
        this.floor = floor;
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);            
    }  
}
