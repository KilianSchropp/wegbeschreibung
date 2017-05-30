package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private JToolBar routeToolBar;
    public void init()
    {
        add(routeToolBar, BorderLayout.PAGE_START);
    }
    
    public void setRouteToolBar(JToolBar routeToolBar)
    {
        this.routeToolBar = routeToolBar;
    }
}
