
package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class FormPanel extends JPanel {
    
    
    private JLabel NumeLabel;
    private JLabel PrenumeLabel;
    private JLabel CNPLabel;
    private JLabel NrTelefonLabel;       
    
    
    

    
    
    
    
    public FormPanel(){
    Dimension dim=getPreferredSize();
    dim.width=250;
    setPreferredSize(dim);
      
    Border innerBorder=BorderFactory.createTitledBorder("Add Persons");
    Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
    setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    
    
      NumeLabel = new JLabel("Nume");
      PrenumeLabel = new JLabel("Prenume");
      CNPLabel = new JLabel("CNP");
      NrTelefonLabel = new JLabel("NrTelefon");
    
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=1;
        gc.weighty=1;
        gc.fill=GridBagConstraints.NONE;
        
        this.add(NumeLabel);
        gc.gridx=1;
        gc.gridy=0;
        
        this.add(PrenumeLabel);
    }
    
}
