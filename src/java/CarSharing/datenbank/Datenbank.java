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
 * @author Matti Düring
 */
public class Datenbank {
    private static String url = "jdbc:postgresql://localhost/carsharing";
    private static Connection con = null;
    
    public static Connection getConnection(){
        
        if(Datenbank.con != null){
            return Datenbank.con;
        }
        
        try {
            Class.forName("org.postgresql.Driver");
            Datenbank.con = DriverManager.getConnection(Datenbank.url, "user", "pass");
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Datenbank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Datenbank.con;
    }
    
    public static Statement getStatement(){
        Connection con = Datenbank.getConnection();
        Statement stm = null;
        
        try {
            stm = con.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(Datenbank.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stm;
    }
    
    public static void closeConnection(){
        
    }
}
