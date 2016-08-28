/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atapardea
 */
public class DBHandler {

    private ArrayList<Abonati> ListaAbonati;

    /// constructor////
    public DBHandler() {
        ListaAbonati = new ArrayList<Abonati>();

    }

    /// metode pentru manipulare lista////
    public void ListaAdaugaPersoana(Abonati persoana) {
        ListaAbonati.add(persoana);
    }

    public List<Abonati> getListaAbonati() {
        return ListaAbonati;
    }

    //// metode pentru manipulare Baza de date/////
    public void Conectare() {
    }

    public void AdaugaAbonat() {
    }

    public void EditeazaAbonat() {
    }

    public void StergeAbonat() {
    }

    
    ////Metode de salvat / incarcat date in fisiere ////
    
    public void SalveazaInFisier(File file) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        Abonati[] abonati= ListaAbonati.toArray(new Abonati[ListaAbonati.size()]);
        
        oos.writeObject(abonati);
        oos.close();
    }
    
    public void IncarcaDinFisier(File file) throws FileNotFoundException, IOException{
        
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fis);
          
            
            try {  
            Abonati[] abonati=(Abonati[]) ois.readObject();
            ListaAbonati.addAll(Arrays.asList(abonati));
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ois.close();
    }
}
