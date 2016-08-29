/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atapardea
 */
public class TestDatabase {
    public static void main(String[] args0) throws SQLException{
       DBHandler test=new DBHandler();
       ResultSet rs;
       
        try {
            rs = test.displayUsers();
            while(rs.next()){
           System.err.println(rs.getString(0));
       }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
    }
}
