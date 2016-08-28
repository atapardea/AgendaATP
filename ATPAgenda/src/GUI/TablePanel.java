/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Backend.Abonati;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class TablePanel extends JPanel {
    
    private JTable table;
    private AbonatiTableModel tablemodel;
    
    public TablePanel(){
        tablemodel = new AbonatiTableModel();
        table=new JTable(tablemodel);
    
    
        setLayout(new BorderLayout());
        add(new JScrollPane(table),BorderLayout.CENTER);
    }
    
     public void setData(List <Abonati> db)
    {tablemodel.setData(db);}
    
     public void refresh(){
        tablemodel.fireTableDataChanged();
    }
}
