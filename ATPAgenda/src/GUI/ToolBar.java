package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {

    private JButton FileButton;
    private JButton AdaugaButton;
    private JButton HelpButton;
    private TextPanel textpanel;
    private StringListener textlistener;
    
    
    
    
    
    public ToolBar() {
        setBorder(BorderFactory.createEtchedBorder());
        FileButton = new JButton("File");
        AdaugaButton = new JButton("Adauga");
        HelpButton = new JButton("Help");

        HelpButton.addActionListener(this);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(FileButton);
        this.add(AdaugaButton);
        this.add(HelpButton);
    }

    public void setStringListener(StringListener listener) {
           this.textlistener=listener;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == HelpButton) {
            //textpanel.append("Help");
            if (textlistener != null){textlistener.textEmitted("Hello");}
                    
        } else if (clicked == AdaugaButton) {
            //textpanel.append("Cauta");
             if (textlistener != null){textlistener.textEmitted("GoodBye");}
        }
    }
}
