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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author atapardea
 */
public class DBHandler {

    private LinkedList<Abonati> ListaAbonati;

    
    private static Connection con;
    private static boolean hasData=false;
    
    
    public ResultSet displayUsers() throws SQLException, ClassNotFoundException{
        if (con==null){
           getConnection();
        
        }
        Statement state = con.createStatement();
        ResultSet res=state.executeQuery("SELECT * from Abonati");
        return res;
    }
        
   private void getConnection() throws ClassNotFoundException, SQLException{
       Class.forName("org.sqlite.JDBC");
       con=DriverManager.getConnection("jdbc:sqlite:Abonati.db");
       initialize();
   }
    private void initialize() throws SQLException{
        if (!hasData){
            hasData =true;
            
            Statement state=con.createStatement();
            ResultSet res=state.executeQuery("SELECT Name from Abonati");
            if (!res.next()){
                System.err.println("Building the table");
                
                Statement state2=con.createStatement();
                state2.execute("CREATE TABLE Abonati(CNP integer)");
            
            PreparedStatement prep=con.prepareStatement("INSERT INTO Abonati values(1840319160128)");
            prep.execute();
            }
        }
    }public void addUser(String CNP) throws ClassNotFoundException, SQLException{
        if (con==null){getConnection();}
    
        PreparedStatement prep = con.prepareStatement("INSERT INTO Abonati values(1840319160122)");
        prep.execute();
    }
    
    
    
    
    /// constructor////
    public DBHandler() {
        ListaAbonati = new LinkedList<Abonati>();

    }

    /// metode pentru manipulare lista////
    public void ListaAdaugaPersoana(Abonati persoana) {
        ListaAbonati.add(persoana);
    }

    public List<Abonati> getListaAbonati() {
        //// scris in asa fel incat alta clasa sa nu poata modifica Lista de Abonati curent existenta////
        return Collections.unmodifiableList(ListaAbonati);
    }
    
    public void stergeAbonat(int index){
        ListaAbonati.remove(index);
    }

    //// metode pentru manipulare Baza de date/////
    public void Conectare() {
    }
    
    public void Deconectare(){
    
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
