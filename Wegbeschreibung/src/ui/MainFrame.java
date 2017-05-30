package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    static final Log LOG = LogFactory.getLog(MainFrame.class);
    private JPanel mainPanel;
    
    public void init() 
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        add(mainPanel);
    }
    
    public void setMainPanel(JPanel panel){this.mainPanel = panel;}   
}


