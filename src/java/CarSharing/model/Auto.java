/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarSharing.model;

/**
 *
 * @author Matti Düring
 */
public class Auto {
    private String fabrikat;
    private String modell;
    private boolean isUsed;
    
    public Auto(String fabrikat, String modell, boolean isUsed){
        this.fabrikat = fabrikat;
        this.modell = modell;
        this.isUsed = isUsed;
    }

    public String getFabrikat() {
        return fabrikat;
    }

    public void setFabrikat(String fabrikat) {
        this.fabrikat = fabrikat;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
