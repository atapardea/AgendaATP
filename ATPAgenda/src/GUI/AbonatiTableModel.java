/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Backend.Abonati;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class AbonatiTableModel extends AbstractTableModel {

    private List<Abonati> db;
    private String[] colNames = {"Nume", "Prenume", "CNP", "NrTelefon"};

    public AbonatiTableModel() {

    }

    @Override
    public String getColumnName(int column) {
        return colNames[column]; 
    }

    
    
    
    public void setData(List<Abonati> db) {
        this.db = db;
    }

    @Override
    public int getRowCount() {

        return db.size();
    }

    @Override
    public int getColumnCount() {
           
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Abonati abonat=db.get(rowIndex);
         
         switch (columnIndex){
             case 0:
                return abonat.getNume();
             case 1:
                 return abonat.getPrenume();
             case 2:
                 return abonat.getCNP();
             case 3:
                 return abonat.getnrTel();
                         
         }
         return 0;
        
    }

    
    
}
