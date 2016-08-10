/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author atapardea
 */
public class MainFrame extends JFrame {

    private JLabel NumeLabel;
    private JLabel PrenumeLabel;
    private JLabel CNPLabel;
    private JLabel NrTelefonLabel;

    private JButton ButonAdauga;
    private JButton ButonEditeaza;
    private JButton ButonCauta;
    private JButton ButonSterge;
    
    private JTextField InputNume;
    private JTextField InputPrenume;
    private JTextField InputCNP;
    private JTextField InputNrTelefon;
    
    private TextPannel textpannel;
    private ToolBar toolbar;
            

    public MainFrame() {
        super("ATP Agenda");

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);

        NumeLabel = new JLabel("Nume");
        PrenumeLabel = new JLabel("Prenume");
        CNPLabel = new JLabel("CNP");
        NrTelefonLabel = new JLabel("NrTelefon");

        InputNume=new JTextField();
        InputPrenume=new JTextField();
        InputCNP=new JTextField();
        InputNrTelefon=new JTextField();
        
        ButonAdauga = new JButton("Adauga");
        ButonEditeaza = new JButton("Editeaza");
        ButonCauta = new JButton("Cauta");
        ButonSterge = new JButton("Sterge");
        
        textpannel=new TextPannel();
        toolbar=new ToolBar();
        
        
        ButonAdauga.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        ButonCauta.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        ButonEditeaza.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        ButonSterge.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                InputNume.setText("Nume");
                InputPrenume.setText("Nume");
                InputCNP.setText("Nume");
                InputNrTelefon.setText("Nume");
                
                textpannel.append("Hello");
                
            }
        });

       this.add(NumeLabel,BorderLayout.CENTER);
       this.add(PrenumeLabel,BorderLayout.CENTER);
       this.add(CNPLabel,BorderLayout.CENTER);
       this.add(NrTelefonLabel,BorderLayout.CENTER);
    
       this.add(ButonAdauga,BorderLayout.EAST);
       this.add(ButonCauta,BorderLayout.EAST);
       this.add(ButonEditeaza,BorderLayout.EAST);
       this.add(ButonSterge,BorderLayout.EAST);
       
       this.add(InputNume,BorderLayout.SOUTH);
       this.add(InputPrenume,BorderLayout.SOUTH);
       this.add(InputCNP,BorderLayout.SOUTH);
       this.add(InputNrTelefon,BorderLayout.SOUTH);
       
       this.add(textpannel,BorderLayout.CENTER);
       this.add(toolbar,BorderLayout.NORTH);
    }
    

}
