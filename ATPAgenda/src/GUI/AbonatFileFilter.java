/*
 *Clasa ce permite filtrarea fisierelor la deschidere - se pot alege doar fisiere de tip .atp
 */
package GUI;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class AbonatFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {

        String name = f.getName();
        String extensie = ClaseUtilitare.Validari.getFileExtension(name);
        
        if (f.isDirectory()){
        return true;
        }
        
        if (extensie == null) {
            return false;
        }
        if (extensie.equals("atp")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {

        return ("Fisiere de tip ATP Agenda (*.atp)");
    }

}
