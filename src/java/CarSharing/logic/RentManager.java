/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.logic;

import CarSharing.datenbank.Datenbank;
import CarSharing.model.Auto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dome
 */
public class RentManager {
    
    public ArrayList<Auto> getAvailableCars(){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT * FROM auto WHERE auto.verfuegbar = true";
        
        ArrayList<Auto> autos = new ArrayList<Auto>();
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String fabrikat = rs.getString("fabrikat");
                String modell = rs.getString("modell");
                autos.add( new Auto(fabrikat, modell, true) );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return autos;
    }
    
    public ArrayList<Auto> getRentCars(int accId){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT auto FROM buchungen WHERE buchungen.account = " + accId + " AND buchungen.active = true";
        
        ArrayList<Auto> autos = new ArrayList<Auto>();
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                autos.add( getAuto(rs.getInt("auto")) );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return autos;
    }
    
    private Auto getAuto(int carId){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT * FROM auto WHERE auto.id = " + carId;
        
        Auto auto = null;
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String fabrikat = rs.getString("fabrikat");
                String modell = rs.getString("modell");
                auto = new Auto(fabrikat, modell, false);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return auto;
    }
}
