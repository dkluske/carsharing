/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.logic;

import CarSharing.datenbank.Datenbank;
import CarSharing.model.Auto;
import CarSharing.model.Buchung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public static ArrayList<Buchung> getRentedCars(int accID){
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
    
    public static void rentCar(String carName, int accID){
        int carID = getCarID(carName);
        DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
        Date date = new Date();
        
        
        Statement stm = Datenbank.getStatement();
        String sql = "INSERT INTO public.buchung(datum,auto,account,status)" +
                     "VALUES('" + f.format(date).toString() + "', " + carID + ", " + accID +
                     ", " + true + ")";
        
        try {
            stm.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setIsUsed(carID, true);
    }
    
    public static void releaseCar(String carName, int accID){
        int carID = getCarID(carName);
        
        System.out.println(carName);
        System.out.println(accID);
        
        Statement stm = Datenbank.getStatement();
        String sql = "UPDATE public.buchung SET status = false WHERE " +
                     "account = " + accID + " AND auto = " + carID + " AND " +
                     "status = true"; 
        
        try {
            stm.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setIsUsed(carID, false); 
    }
    
    private static void setIsUsed(int carID, boolean state){
        Statement stm = Datenbank.getStatement();
        String sql = "UPDATE public.auto SET \"isUsed\" = " + state + " WHERE id = " + carID;
        
        try {
            stm.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static int getCarID(String carName){
        int carID = 0;
        
        String[] car = carName.split(" ");
        
        String hersteller = car[0];
        String modell = car[1];
        
        Statement stm = Datenbank.getStatement();
        String sql = "SELECT id FROM public.auto WHERE " +
                     "hersteller = '" + hersteller + "' AND " +
                     "modell = '" + modell + "'";
        
        try {
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                carID = rs.getInt("id");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return carID;
    }
    
}
