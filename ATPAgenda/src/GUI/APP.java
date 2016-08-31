package GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sun.swing.SwingAccessor;

public class APP {

    JFrame frame;
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            
            public void run() {
                new MainFrame();

               
            }

        });

    }

}
