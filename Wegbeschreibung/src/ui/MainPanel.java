package ui;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    public MainPanel()
    {
        GridBagConstraints c = new GridBagConstraints();
        
        JButton button = new JButton("Button 1");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(button, c);
    }
}
