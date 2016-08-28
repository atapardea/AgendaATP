/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.TableModel;
    

public class TextPanel extends JTextArea {
    private JTextArea textarea;
    
    public TextPanel(){
        
        textarea=new JTextArea();
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(textarea), BorderLayout.CENTER);
    
    }
    public void appendText(String text){
        textarea.append(text);
    
    }
    
   
}
