package ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PicturePanel extends JPanel
{
    static final Log LOG = LogFactory.getLog(PicturePanel.class);
    private static final long serialVersionUID = 1L;
    JPanel mergedPanel;
    
    public void setMergedPanel(JPanel mergedPanel)
    {
        this.mergedPanel = mergedPanel;
    }

    public void init()
    {
        JScrollPane sp = new JScrollPane(mergedPanel);
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
    }
}


