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

    public Connection con;

    /// metoda prin care se face conexiunea la db, si se creeaza 
    /////atat db cat si Tabela Abonati daca nu exista 
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:Abonati.db";
        Statement stmt = null;

        try {

            if (con != null) {
                return;
            }

            con = DriverManager.getConnection(url);
            if (con != null) {
                DatabaseMetaData meta = con.getMetaData();

                stmt = con.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS Abonati "
                        + "(NUME           TEXT    NOT NULL, "
                        + "PRENUME           TEXT    NOT NULL, "
                        + "CNP BIGINT PRIMARY KEY     NOT NULL,"
                        + " NRTELEFON         TEXT    NOT NULL)";

                stmt.executeUpdate(sql);
                stmt.close();

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /////metoda de deconectare de la db
    public void disconnect() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    //// metoda care salveaza abonati din lista existenta in baza de date
    public void Save() throws SQLException {

        Statement statement = con.createStatement();

        // itereaza lista existenta de abonati dupa cheia primara - CNP si verifica daca exista in db
        for (Abonati abonati : ListaAbonati) {
            String sql = "SELECT COUNT(*) AS COUNT FROM Abonati where CNP=" + abonati.getCNP();

            String Nume = abonati.getNume();
            String Prenume = abonati.getPrenume();
            Long CNP = abonati.getCNP();
            Long NrTelefon = abonati.getnrTel();

            String insertQuery = "INSERT INTO Abonati (NUME,PRENUME,CNP,NRTELEFON) values(\"" + Nume + "\",\""
                    + Prenume + "\","
                    + CNP + ","
                    + NrTelefon + ")";

            String updateQuery = "UPDATE Abonati SET NUME=\"" + Nume + "\",PRENUME=\""
                    + Prenume + "\",CNP="
                    + CNP + ",NRTELEFON="
                    + NrTelefon + " WHERE CNP="
                    + abonati.getCNP();

            

            ResultSet result = statement.executeQuery(sql);

            result.next();
            int count = result.getInt(1);

            if (count == 0) {
                System.err.println("Inserting person with ID" + abonati.getCNP());
                statement.executeUpdate(insertQuery);
            }
            if (count == 1) {
                statement.executeUpdate(updateQuery);

            }
            
        }
        statement.close();
    }

    public void load() throws SQLException {

        ListaAbonati.clear();
        String sql = "SELECT NUME, PRENUME, CNP, NRTELEFON from Abonati order by NUME";

        Statement selectStatement = con.createStatement();

        ResultSet result = selectStatement.executeQuery(sql);
        while (result.next()) {
            String nume=result.getString("NUME");
            String prenume=result.getString("PRENUME");
            long cnp=result.getLong("CNP");
            long nrtel=result.getLong("NRTELEFON");
             
            ListaAbonati.add(new Abonati(nume, prenume, Long.toString(cnp), Long.toString(nrtel)));
        }

        result.close();
        selectStatement.close();

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

    public void stergeAbonat(int index) {
        ListaAbonati.remove(index);
    }

    ////Metode de salvat / incarcat date in fisiere ////
    public void SalveazaInFisier(File file) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Abonati[] abonati = ListaAbonati.toArray(new Abonati[ListaAbonati.size()]);

        oos.writeObject(abonati);
        oos.close();
    }

    public void IncarcaDinFisier(File file) throws FileNotFoundException, IOException {

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Abonati[] abonati = (Abonati[]) ois.readObject();
            ListaAbonati.addAll(Arrays.asList(abonati));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ois.close();
    }
    
    public void sorteazaLista(){
        Collections.sort(ListaAbonati);
        }
}


