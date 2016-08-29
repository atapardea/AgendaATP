package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

    private JLabel NumeLabel;
    private JLabel PrenumeLabel;
    private JLabel CNPLabel;
    private JLabel NrTelefonLabel;

    private JTextField NumeField;
    private JTextField PrenumeField;
    private JTextField CNPField;
    private JTextField NrTelefonField;

    private JButton ButonAdauga;
    private FormListener formlistener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Add Persons");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        NumeLabel = new JLabel("Nume");
        PrenumeLabel = new JLabel("Prenume");
        CNPLabel = new JLabel("CNP");
        NrTelefonLabel = new JLabel("NrTelefon");

        NumeField = new JTextField(10);
        PrenumeField = new JTextField(10);
        CNPField = new JTextField(10);
        NrTelefonField = new JTextField(10);

        ButonAdauga = new JButton("Adauga");
        
        ButonAdauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               String Nume = NumeField.getText();
               String Prenume=PrenumeField.getText();
               String CNP=CNPField.getText();
               String NrTelefon=NrTelefonField.getText();
               
               FormEvent ev=new FormEvent(this, Nume, Prenume, CNP, NrTelefon);
              
                
               if (formlistener != null){
                   
               formlistener.formEventOccured(ev);
               
               //// curatare fielduri dupa apasare OK////
               NumeField.setText("");
               PrenumeField.setText("");
               CNPField.setText("");
               NrTelefonField.setText("");
               }
                
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ////////Primul rand/////////    
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        this.add(NumeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        this.add(NumeField, gc);

        ////////Al doilea rand/////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        this.add(PrenumeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        this.add(PrenumeField, gc);

        ////////Al treilea rand/////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        this.add(CNPLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;

        this.add(CNPField, gc);

        ////////Al patrulea rand/////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        this.add(NrTelefonLabel, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        this.add(NrTelefonField, gc);

        ////////Ultimul rand - buton/////////
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;

        this.add(ButonAdauga, gc);

    }

    public void setFormListener(FormListener listener){
    this.formlistener=listener;
    }

    //// setteri de labeluri ////
    public void setTextNumeField(String s) {
        this.NumeField.setText(s);
    }
    
    public void setTextPrenumeField(String s) {
        this.PrenumeField.setText(s);
    }
    
    public void setTextCNPField(String s) {
        this.CNPField.setText(s);
    }

    public void setTextNrTelefonField(String s) {
        this.NrTelefonField.setText(s);
    }
    
    
}
