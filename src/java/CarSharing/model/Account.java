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
public class Account {
    private String accName;
    private int accID;
    
    public Account(String accName, int accID){
        this.accName = accName;
        this.accID = accID;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public int getId() {
        return accID;
    }

    public void setId(int id) {
        this.accID = accID;
    }
}
