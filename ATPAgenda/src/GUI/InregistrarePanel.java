/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Button;
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

/**
 *
 * @author atapardea
 */
public class InregistrarePanel extends JPanel {

    private JLabel labelInregistrare;
    private JTextField fieldInregistrare;
    private JButton buttonInregistrare;
    

    public InregistrarePanel() {

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Inregistrare");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        labelInregistrare = new JLabel("Cod inregistrare");
        fieldInregistrare = new JTextField(10);
        buttonInregistrare = new JButton("Register");

        //fieldInregistrare.setEditable(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        this.add(labelInregistrare, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        this.add(fieldInregistrare, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        this.add(buttonInregistrare, gc);

        buttonInregistrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });

    }

    
}
