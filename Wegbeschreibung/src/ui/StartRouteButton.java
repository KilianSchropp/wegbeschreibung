package ui;

import javax.swing.JButton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StartRouteButton extends JButton
{
    private static final long serialVersionUID = 1L;
    static final Log LOG = LogFactory.getLog(StartRouteButton.class);
    
    public StartRouteButton(String text)
    {
        super(text);
    }
    
}
