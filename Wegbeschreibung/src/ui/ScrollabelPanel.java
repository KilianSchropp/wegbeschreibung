package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.Floor;

public class ScrollabelPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    static final Log LOG = LogFactory.getLog(ScrollabelPanel.class);
    private Floor floor;
    private BufferedImage image;
    private List<Line2D> lines;
    JComboBox<String> startCombobox;
    JComboBox<String> destinationCombobox;

    public void init()
    {
        this.image = floor.getImage();
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }
    
    public void setLines(List<Line2D> lines){this.lines = lines;}
    
    public void setFloor(Floor floor){this.floor = floor;}
    
    public void calcRoute()
    {
        String startRoom = startCombobox.getSelectedItem().toString();
        String destinationRoom = destinationCombobox.getSelectedItem().toString();
        floor.getGraphPointWithName(startRoom);
    }
    
    protected void drawAllLines(List<Line2D> lines, Graphics2D g2)
    {
        if(lines == null || lines.isEmpty())
        {
            LOG.info("Nothing is done in this method, because the list of lines is empty.");
        }
        else
        {
            for(Line2D line : lines)
            {
                g2.draw(line);
            }  
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, this);
        g2.setStroke(new BasicStroke(20));
        g2.setColor(Color.RED);
        drawAllLines(lines, g2);
    }  
}
