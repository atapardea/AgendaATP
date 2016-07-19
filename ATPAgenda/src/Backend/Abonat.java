package Backend;

import ClaseUtilitare.Validari;
import Exceptii.CNPInvalidException;

public class Abonat {

    private String nume;
    private String prenume;
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
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.nrTel = nrTel;
    }

}
