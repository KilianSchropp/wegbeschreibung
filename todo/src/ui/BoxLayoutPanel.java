package ui;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BoxLayoutPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private List<Component> panelComponents;
    private int axis;
 
    public void setAxis(int axis) {
        this.axis = axis;
    }
 
    public void setPanelComponents(List<Component> panelComponents) {
        this.panelComponents = panelComponents;
    }
 
    public void init() {
        setLayout(new BoxLayout(this, axis));
 
        for (Iterator<Component> iter = panelComponents.iterator(); iter.hasNext();)
        {
            Component component = iter.next();
            add(component);
        }
    }
}
