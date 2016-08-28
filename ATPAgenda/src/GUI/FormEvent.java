
package GUI;

import java.util.EventObject;


public class FormEvent extends EventObject {

    public void setNume(String Nume) {
        this.Nume = Nume;
    }

    public void setPrenume(String Prenume) {
        this.Prenume = Prenume;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setNrTelefon(String NrTelefon) {
        this.NrTelefon = NrTelefon;
    }

    public String getNume() {
        return Nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public String getNrTelefon() {
        return NrTelefon;
    }
    
    private String Nume;
    private String Prenume;
    private String CNP;
    private String NrTelefon;
    
    
    	public FormEvent(Object source) {
		super(source);
	}
    
    
    public FormEvent(Object source, String Nume, String Prenume, String CNP, String NrTelefon){
     super(source);
     this.Nume=Nume;
     this.Prenume=Prenume;
     this.CNP=CNP;
     this.NrTelefon=NrTelefon;
        
    }
}
