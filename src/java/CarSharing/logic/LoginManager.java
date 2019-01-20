/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.logic;

import CarSharing.datenbank.Datenbank;
import CarSharing.model.Kunde;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;






/**
 *
 * @author Matti Düring
 */
public class LoginManager {
    
    public static boolean checkLoginCredentials(String accName, String accPass){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT passwort FROM public.account WHERE benutzername = '" + accName + "'";
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                
                if(rs.getString("passwort").equals(accPass)){
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public static Kunde getKunde(String accName){
        int id = getAccountID(accName);
        String name = getKundenName(id);
        String vorname = getKundenVorname(id);
        
        return new Kunde(name, vorname, accName, id);
    }
    
    //P R I V A T E - M E T H O D S
    
    private static int getAccountID(String accName){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT * FROM public.account WHERE benutzername = '" + accName + "'";
        
        int id = 0;
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                id = rs.getInt("id");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    private static String getKundenName(int id){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT * FROM public.kunde WHERE account = " + id;
        
        String name = null;
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                name = rs.getString("nachname");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
    }
    
    private static String getKundenVorname(int id){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT * FROM public.kunde WHERE account = " + id;
        
        String vorname = null;
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                vorname = rs.getString("vorname");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vorname;
    }
}
