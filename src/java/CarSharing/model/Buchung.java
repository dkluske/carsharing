/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.model;

import java.sql.Date;

/**
 *
 * @author Düring, Matti
 */
public class Buchung {
    private String hersteller;
    private String modell;
    private String date;
    
    public Buchung(String hersteller, String modell, String date){
        this.hersteller = hersteller;
        this.modell = modell;
        this.date = date;
    }

    public String getHersteller() {
        return hersteller;
    }

    public String getModell() {
        return modell;
    }

    public String getDate() {
        return date;
    }
    
    public String toString(){
        return this.hersteller + " " + this.modell + "\t " + this.getDate();
    }
    
    
}
