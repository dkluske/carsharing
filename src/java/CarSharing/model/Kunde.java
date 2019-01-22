/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.model;

/**
 *
 * @author Düring, Matti
 */
public class Kunde extends Account{
    private String name;
    private String vorname;

    public Kunde(String name, String vorname, String accName, int accID) {
        super(accName, accID);
        
        this.name = name;
        this.vorname = vorname;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    @Override
    public String toString(){
        return this.vorname + " " + this.name;
    }
}
