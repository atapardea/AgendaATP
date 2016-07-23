package Backend;

import ClaseUtilitare.Validari;
import Exceptii.CNPInvalidException;

public class Abonat {

    private String Nume;
    private String Prenume;
    private long CNP;
    private long nrTel;

    public Abonat(String nume, String prenume, long CNP, long nrTel) {

//<editor-fold defaultstate="collapsed" desc="Verificari string nume si prenume">
// verifica numele sa nu fie null
        if ((nume == null) || (nume.length() == 0)) {
            throw new IllegalArgumentException("Completati numele");
        }
//verifica numele sa nu contina cifre
        if (!nume.matches("[A-Za-z \\-]+")) {
            throw new IllegalArgumentException("Numele nu poate contine cifre");
        }

// verifica prenumele sa nu fie null
        if ((prenume == null) || (nume.length() == 0)) {
            throw new IllegalArgumentException("Completati prenumele");
        }
//verifica prenumele sa nu contina cifre
        if (!nume.matches("[A-Za-z \\-]+")) {
            throw new IllegalArgumentException("Prenumele nu poate contine cifre");
        }
//</editor-fold>

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
    public String getNume() {
        return this.Nume;
    }

    public String getPrenume() {
        return this.Prenume;
    }

    public long getCNP() {
        return this.CNP;
    }

    public long getnrTel() {
        return this.nrTel;
    }
//</editor-fold>

    // PUBLIC SETTERS
    //<editor-fold defaultstate="collapsed" desc="comment">
    public void setNume(String nume) {

        //verifica numele sa nu fie gol
        if ((nume == null) || (nume.length() == 0)) {
            throw new IllegalArgumentException("Completati numele");
        }
        //verifica numele sa nu contina cifre
        if (!nume.matches("[A-Za-z \\-]+")) {
            throw new IllegalArgumentException("Numele nu poate contine cifre");
        }

        this.Nume = nume;
    }

    public void setPrenume(String prenume) {

        // verifica prenumele sa nu fie null
        if ((prenume == null) || (prenume.length() == 0)) {
            throw new IllegalArgumentException("Completati prenumele");
        }
//verifica prenumele sa nu contina cifre
        if (!prenume.matches("[A-Za-z \\-]+")) {
            throw new IllegalArgumentException("Prenumele nu poate contine cifre");
        }

        this.Prenume = prenume;
    }

    public void setCNP(long CNP) {

        if (Long.toString(CNP).length() != 13) {
            throw new IllegalArgumentException("CNP-ul trebuie sa contina 13 cifre");
        }
        if (Validari.validareCNP(CNP) == false) {
            throw new CNPInvalidException("CNP-ul este invalid");
        }
        this.CNP = CNP;
    }

    public void setnrTel(long nrTel) {
        this.nrTel = nrTel;
    }
//</editor-fold>

}
