/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Backend.Abonati;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

public class TablePanel extends JPanel {

    private JTable table;
    private AbonatiTableModel tablemodel;
    private JPopupMenu popup;
    private AbonatiTableListener abonatiTableListener;
    

    public TablePanel() {
        tablemodel = new AbonatiTableModel();
        table = new JTable(tablemodel);
        popup = new JPopupMenu();

        JMenuItem stergeAbonat = new JMenuItem("Sterge inregistrare");
        popup.add(stergeAbonat);

        /// listener pentru click pe inregistrare pentru afisare meniu ///
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                // aflare rand clickuit
                int row = table.rowAtPoint(e.getPoint());

                //selectare rand anume din model la click
                table.getSelectionModel().setSelectionInterval(row, row);
               
                
              

                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(TablePanel.this, e.getX(), e.getY());
                }
            }

        });

        /// listener pentru stergeAbonat - pt a sterge un abonat la selectarea lui ///
        stergeAbonat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                int confirmareStergere = JOptionPane.showConfirmDialog(TablePanel.this,
                        "Confirmare stergere?",
                        "Confirmare", JOptionPane.OK_CANCEL_OPTION);

                if (confirmareStergere == JOptionPane.OK_OPTION) {
                    if (abonatiTableListener != null) {
                        abonatiTableListener.rowDeleted(row);
                        refresh();
                    }
                    refresh();
                }
            }
        });

        
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    //// setter pentru adaugare AbonatiTableListener(instantian in MainFrame) in TablePanel///
    public void setAbonatiTableListener(AbonatiTableListener listener) {
        this.abonatiTableListener = listener;

    }

    /// metoda pentru adaugare db in table ////
    public void setData(List<Abonati> db) {
        tablemodel.setData(db);
    }

    /// metoda pentru refreshul table-ului ////
    public void refresh() {
        tablemodel.fireTableDataChanged();
    }
    
  
}
