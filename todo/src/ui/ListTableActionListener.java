package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

public class ListTableActionListener implements ActionListener
{
    protected JTable table;
    protected List<String> list;
 
    public void setList(List<String> list) {
        this.list = list;
    }
 
    public void setTable(JTable itemTable) {
        this.table = itemTable;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        
    }
}
