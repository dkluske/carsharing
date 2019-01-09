/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.logic;

import CarSharing.datenbank.Datenbank;
import CarSharing.model.Account;
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
    
    public static Kunde getKunde(String accName){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT name, vorname FROM kunde WHERE kunde.account = '" + accName + "'";
        
        Kunde kunde = new Kunde();
        int accId = getAccountId(accName);
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                kunde.setName(rs.getString("name"));
                kunde.setVorname(rs.getString("vorname"));
                kunde.setAccount( new Account(accName, accId) );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return kunde;
    }
    
    private static int getAccountId(String accName){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT id FROM account WHERE account.name = '" + accName + "'";
        
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
}
