/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.models;

/**
 *
 * @author clario
 */
public class Emne {
    
    
    private String emnenavn;
    private boolean isHovedEmne;
    private Integer emneId;
    
    

    public Emne() {
    }

    public Emne(String emnenavn, boolean isHovedEmne, Integer emneId) {
        this.emnenavn = emnenavn;
        this.isHovedEmne = isHovedEmne;
        this.emneId = emneId;
    }
    
    
    
    

    public String getEmnenavn() {
        return emnenavn;
    }

    public void setEmnenavn(String emnenavn) {
        this.emnenavn = emnenavn;
    }

    public boolean isIsHovedEmne() {
        return isHovedEmne;
    }

    public void setIsHovedEmne(boolean isHovedEmne) {
        this.isHovedEmne = isHovedEmne;
    }

    public Integer getEmneId() {
        return emneId;
    }

    public void setEmneId(Integer emneId) {
        this.emneId = emneId;
    }
    
    
    
    
    
    
    
}
