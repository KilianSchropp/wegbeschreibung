package ui;

import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    public void init(Dimension dimension) 
    {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(dimension);
        setVisible(true);
        setState(Frame.NORMAL);
        setVisible(true);
    }
}
