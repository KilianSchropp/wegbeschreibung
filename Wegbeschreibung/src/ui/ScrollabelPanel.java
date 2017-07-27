package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.Floor;

public class ScrollabelPanel extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    static final Log LOG = LogFactory.getLog(ScrollabelPanel.class);
    private Floor floor;
    private BufferedImage image;
    List<Line2D> lines;

    public void init()
    {
        this.image = floor.getImage();
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        Timer timer = new Timer(10, this);
        timer.start();
    }
    
    public void setFloor(Floor floor){this.floor = floor;}
    
    protected void drawAllLines(Graphics2D g2)
    {
        lines = floor.getLinesToDraw();
        if(lines != null && !lines.isEmpty())
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
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.RED);
        drawAllLines(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }  
}
