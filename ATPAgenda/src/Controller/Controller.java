/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Backend.Abonati;
import Backend.DBHandler;
import GUI.AbonatiTableModel;
import GUI.FormEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller {
    
    DBHandler db = new DBHandler();
    
    /// getter care intoarce lista de abonati curenta///
    public List<Abonati> getAbonati() {
        return db.getListaAbonati();
    }
    
    /// metoda pentru adaugare abonat//// 
    public void adaugaAbonat(FormEvent e) {
        
        String nume = e.getNume();
        String prenume = e.getPrenume();
        String CNP = e.getCNP();
        
        String nrTelefon = e.getNrTelefon();
        
        Abonati abonat = new Abonati(nume, prenume, CNP, nrTelefon);
        
        db.ListaAdaugaPersoana(abonat);
    }

    
    public void stergeAbonat(int index){
    db.stergeAbonat(index);
    }
    
    public void CtrlSalveazaInFisier(File file) throws IOException {
        db.SalveazaInFisier(file);
    }
    
    public void CtrlDeschideDinFisier(File file) throws IOException {
        db.IncarcaDinFisier(file);
    }
    
    public void saveToDB() throws SQLException{
    db.Save();}
    
    public void disconnectDB() throws SQLException{
    db.disconnect();
    }
    
    public void connectToDB() throws ClassNotFoundException, SQLException {
    db.connect();
    }
    
    public void loadFromDB () throws SQLException {
    db.load();
    }
    
    public void sort(){
    db.sorteazaLista();
    }
}
