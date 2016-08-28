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
import java.util.List;

public class Controller {
    
    DBHandler db = new DBHandler();
    
    public List<Abonati> getAbonati() {
        return db.getListaAbonati();
    }
    
    public void adaugaAbonat(FormEvent e) {
        
        String nume = e.getNume();
        String prenume = e.getPrenume();
        String CNP = e.getCNP();
        
        String nrTelefon = e.getNrTelefon();
        
        Abonati abonat = new Abonati(nume, prenume, CNP, nrTelefon);
        
        db.ListaAdaugaPersoana(abonat);
    }

    public void CtrlSalveazaInFisier(File file) throws IOException {
        db.SalveazaInFisier(file);
    }
    
    public void CtrlDeschideDinFisier(File file) throws IOException {
        db.IncarcaDinFisier(file);
    }
    
}
