/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.Controller;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author atapardea
 */
public class MainFrame extends JFrame {

    private JButton ButonEditeaza;
    private JButton ButonCauta;
    private JButton ButonSterge;

    private TextPanel textpanel;
    private ToolBar toolbar;
    private FormPanel formpanel;
    private JFileChooser jfilechooser;
    private Controller controller;
    private TablePanel tablepanel;

    public MainFrame() {
        super("ATP Agenda");

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(600, 400));

        textpanel = new TextPanel();
        toolbar = new ToolBar();
        formpanel = new FormPanel();
        jfilechooser = new JFileChooser();
        jfilechooser.addChoosableFileFilter(new AbonatFileFilter());
        controller = new Controller();
        tablepanel = new TablePanel();
        tablepanel.setData(controller.getAbonati());
        
        
        ///
        tablepanel.setAbonatiTableListener(new AbonatiTableListener(){
            public void rowDeleted(int row){
                controller.stergeAbonat(row);
            }
        });
        
        setJMenuBar(createMenuBar());

        this.add(formpanel, BorderLayout.WEST);
        this.add(tablepanel, BorderLayout.CENTER);
        this.add(toolbar, BorderLayout.NORTH);

        
        
        formpanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {

                String Nume = e.getNume();

                String Prenume = e.getPrenume();
                String CNP = e.getCNP();
                String NrTelefon = e.getNrTelefon();

                controller.adaugaAbonat(e);
                tablepanel.refresh();

            }
        });

    }

    private JMenuBar createMenuBar() {

        //////  instantiere iteme din menubar////
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        JMenu abonatimenu = new JMenu("Abonati");
        JMenu helpmenu = new JMenu("Help");

        JMenuItem openmenu = new JMenuItem("Open");
        JMenuItem savemenu = new JMenuItem("Save");
        JMenuItem iesiremenu = new JMenuItem("Iesire");

        JMenuItem adaugamenu = new JMenuItem("Adauga");
        JMenuItem cautamenu = new JMenuItem("Cauta");
        JMenuItem stergemenu = new JMenuItem("Sterge");
        JMenuItem modificamenu = new JMenuItem("Modifica");

        JMenuItem inregistraremenu = new JMenuItem("Inregistrare");
        JMenuItem aboutmenu = new JMenuItem("About");

        //// adaugare iteme pe menubar////
        menubar.add(filemenu);
        menubar.add(abonatimenu);
        menubar.add(helpmenu);

        //// adaugare iteme in meniu File ////
        filemenu.add(openmenu);
        filemenu.add(savemenu);
        filemenu.addSeparator();
        filemenu.add(iesiremenu);

        //// adaugare iteme in meniu Abonati////
        abonatimenu.add(adaugamenu);
        abonatimenu.add(cautamenu);
        abonatimenu.add(stergemenu);
        abonatimenu.add(modificamenu);

        //// adaugare iteme in meniu Help////
        helpmenu.add(inregistraremenu);
        helpmenu.addSeparator();
        helpmenu.add(aboutmenu);

        //// setare mnemonice////
        filemenu.setMnemonic(KeyEvent.VK_F);
        openmenu.setMnemonic(KeyEvent.VK_O);
        savemenu.setMnemonic(KeyEvent.VK_S);
        iesiremenu.setMnemonic(KeyEvent.VK_E);
        iesiremenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        openmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        abonatimenu.setMnemonic(KeyEvent.VK_A);
        adaugamenu.setMnemonic(KeyEvent.VK_A);
        cautamenu.setMnemonic(KeyEvent.VK_C);
        stergemenu.setMnemonic(KeyEvent.VK_S);
        modificamenu.setMnemonic(KeyEvent.VK_M);

        helpmenu.setMnemonic(KeyEvent.VK_H);
        inregistraremenu.setMnemonic(KeyEvent.VK_I);
        aboutmenu.setMnemonic(KeyEvent.VK_A);

        /// deschidere meniu Open
        openmenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((jfilechooser.showOpenDialog(MainFrame.this)) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.CtrlDeschideDinFisier(jfilechooser.getSelectedFile());
                        tablepanel.refresh();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Incarcare din fisier nereusita", "Eroare", JOptionPane.ERROR_MESSAGE);
                    }
                    System.err.println(jfilechooser.getSelectedFile());
                }
            }
        });

        /// deschidere Save menu ////
        savemenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((jfilechooser.showSaveDialog(MainFrame.this)) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.CtrlSalveazaInFisier(jfilechooser.getSelectedFile());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Salvare in fisier nereusita", "Eroare", JOptionPane.ERROR_MESSAGE);
                    }
                    System.err.println(jfilechooser.getSelectedFile());
                }
            }
        });

        //// adaugare IESIRE program////
        iesiremenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int optiuneIesire = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Do you really want to exit the application?",
                        "Confirm exit", JOptionPane.OK_CANCEL_OPTION);
                if (optiuneIesire == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        return menubar;
    }
        
}
