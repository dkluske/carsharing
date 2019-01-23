/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Düring, Matti
 */
public class Datenbank {  
    private static Connection con;
    
    private static String url = "jdbc:postgresql://localhost:5432/Carsharing";
    private static String user = "root";
    private static String pass = "passwort";
    
    private static Connection openConnection(){
        
        if(Datenbank.con != null){
            return Datenbank.con;
        }
        
        try {
            Class.forName("org.postgresql.Driver");
            
            Datenbank.con = DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Datenbank.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Datenbank.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return Datenbank.con;
    }
    
    public static Statement getStatement(){
        Statement stm = null;
        
        try {
            stm = Datenbank.openConnection().createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(Datenbank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stm;
    }
}
