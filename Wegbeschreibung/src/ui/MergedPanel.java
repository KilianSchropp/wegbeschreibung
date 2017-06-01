package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class MergedPanel extends JPanel
{
    private static final long serialVersionUID = 1L;

    JPanel scrollPanel1;
    JPanel scrollPanel2;
    JPanel scrollPanel3;
    
    public void init()
    {
        add(scrollPanel1, BorderLayout.NORTH);
        add(scrollPanel2, BorderLayout.CENTER);
        add(scrollPanel3, BorderLayout.SOUTH);
    }
    
    public void setScrollPanel1(JPanel scrollPanel1){this.scrollPanel1 = scrollPanel1;}
    
    public void setScrollPanel2(JPanel scrollPanel2){this.scrollPanel2 = scrollPanel2;}
    
    public void setScrollPanel3(JPanel scrollPanel3){this.scrollPanel3 = scrollPanel3;}
}
