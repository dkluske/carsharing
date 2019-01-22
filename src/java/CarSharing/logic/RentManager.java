/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.logic;

import CarSharing.datenbank.Datenbank;
import CarSharing.model.Auto;
import CarSharing.model.Buchung;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Düring, Matti
 */
public class RentManager {
    
    public static ArrayList<Auto> getUnusedCars(){
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT * FROM public.auto WHERE \"isUsed\" = false";
        
        ArrayList<Auto> cars = new ArrayList<Auto>();
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Auto car = new Auto(rs.getString("hersteller"), rs.getString("modell"));
                cars.add(car);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cars;
    }
    
    public static ArrayList<Buchung> getRentCars(int accID){
        Statement stm = Datenbank.getStatement();
        
        String sql = "SELECT hersteller, modell, datum FROM public.auto " + 
                     "INNER JOIN public.buchung ON public.buchung.account =" + accID + 
                     "AND public.buchung.auto = public.auto.id " + 
                     "AND public.buchung.status = true";
        
        ArrayList<Buchung> rent = new ArrayList<Buchung>();
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String hersteller = rs.getString("hersteller");
                String modell = rs.getString("modell");
                String date = rs.getDate("datum").toString();
                
                rent.add( new Buchung(hersteller, modell, date ) );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rent;
    }
    
}
