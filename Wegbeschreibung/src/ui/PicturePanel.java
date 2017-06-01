package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import building.Building;

public class PicturePanel extends JPanel
{
    static final Log LOG = LogFactory.getLog(PicturePanel.class);
    private static final long serialVersionUID = 1L;
    private Building building;
    
    public void init()
    {
        BufferedImage image = building.getFirstFloor().getImage();
        MergeAllPanel scrollablePanel = new MergeAllPanel(image);
        JScrollPane sp = new JScrollPane(scrollablePanel);
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
    }
    
    public void setBuilding(Building building)
    {
        this.building = building;
    }
}

class ScrollablePanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private BufferedImage image;

    public ScrollablePanel(BufferedImage image)
    {
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        setBackground(Color.WHITE);
        this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);            
    }  
}

class MergeAllPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    public MergeAllPanel(BufferedImage image)
    {
        ScrollablePanel panel1 = new ScrollablePanel(image);
        ScrollablePanel panel2 = new ScrollablePanel(image);
        ScrollablePanel panel3 = new ScrollablePanel(image);
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
    }  
}
