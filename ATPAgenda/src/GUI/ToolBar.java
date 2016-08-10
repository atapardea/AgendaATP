package GUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel {

    private JButton FileButton;
    private JButton AdaugaButton;
    private JButton HelpButton;

    public ToolBar() {
        FileButton = new JButton("File");
        AdaugaButton = new JButton("Adauga");
        HelpButton = new JButton("Help");
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(FileButton);
        this.add(AdaugaButton);
        this.add(HelpButton);        
    }

}
