package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ToolBar extends JPanel implements ActionListener {
	private JButton SaveToDB;
	private JButton RefreshFromDB;
	
	private ToolBarListener toolbarlistener;
	
	public ToolBar() {
		setBorder(BorderFactory.createEtchedBorder());
		
		SaveToDB = new JButton("Salveaza in BD");
		RefreshFromDB = new JButton("Refresh din BD");
		
		SaveToDB.addActionListener(this);
		RefreshFromDB.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(SaveToDB);
		add(RefreshFromDB);
	}
	
	public void setToolBarListener(ToolBarListener listener) {
		this.toolbarlistener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == SaveToDB) {
			if(toolbarlistener != null) {
				toolbarlistener.saveEventOccured();
			}
		}
		else if(clicked == RefreshFromDB) {
			if(toolbarlistener != null) {
				toolbarlistener.refreshEventOccured();
			}
		}
		
	}
}
