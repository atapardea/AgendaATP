
package FrontEnd;

import javax.swing.table.AbstractTableModel;


public class Tabel extends AbstractTableModel{

    @Override
    public int getRowCount() {
         return 2;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
