package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainPanel extends JPanel
{
    static final Log LOG = LogFactory.getLog(MainPanel.class);

    private static final long serialVersionUID = 1L;
    private JToolBar routeToolBar;
    private JPanel picturePanel;
    
    public void init()
    {
        add(routeToolBar, BorderLayout.PAGE_START);
        add(picturePanel, BorderLayout.CENTER);
    }
    
    public void setPicturePanel(JPanel picturePanel){this.picturePanel = picturePanel;}
    
    public void setRouteToolBar(JToolBar routeToolBar){this.routeToolBar = routeToolBar;}
}
