package Backend;

import ClaseUtilitare.Validari;
import Exceptii.CNPInvalidException;

public class Abonat {

    private String Nume;
    private String Prenume;
    private long CNP;
    private long nrTel;

    public Abonat(String nume, String prenume, long CNP, long nrTel) {

        // verifica numele sa nu fie null
        if (nume == null) {
            throw new IllegalArgumentException("Completati numele");
        }
// verifica prenumele sa nu fie null
        if (prenume == null) {
            throw new IllegalArgumentException("Completati prenumele");
        }

//verifica daca CNP-ul are 13 cifre
        if (Long.toString(CNP).length() != 13) {
            throw new IllegalArgumentException("CNP-ul trebuie sa contina 13 cifre");
        }
        if (Validari.validareCNP(CNP) == false) {
            throw new CNPInvalidException("CNP-ul este invalid");
        }
        this.Nume = nume;
        this.Prenume = prenume;
        this.CNP = CNP;
        this.nrTel = nrTel;
    }

    // PUBLIC GETTERS 
    
    //<editor-fold defaultstate="collapsed" desc="comment">
    public String getNume (){
        return this.Nume;}
    
    public String getPrenume (){
        return this.Prenume;}
    
    public long getCNP (){
        return this.CNP;}
    
    public long getnrTel (){
        return this.nrTel;}
//</editor-fold>
    
    // PUBLIC SETTERS

    //<editor-fold defaultstate="collapsed" desc="comment">
    public void setNume(String Nume) {
        this.Nume = Nume;
    }
    
    public void setPrenume(String Prenume) {
        this.Prenume = Prenume;
    }
    
    public void setCNP(long CNP) {
        this.CNP = CNP; }
    
    public void setnrTel(long nrTel){
        this.nrTel=nrTel;}
//</editor-fold>
   



}

    
    
    
    


