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
    private Integer hovedEmneId;
    private Integer emneId;
    

    public Emne() {
    }

    public Emne(String emnenavn, boolean isHovedEmne, Integer hovedEmneId, Integer emneId) {
        this.emnenavn = emnenavn;
        this.isHovedEmne = isHovedEmne;
        this.hovedEmneId = hovedEmneId;
        this.emneId = emneId;
    }

  

    public Integer getHovedEmneId() {
        return hovedEmneId;
    }

    public void setHovedEmneId(Integer hovedEmneId) {
        this.hovedEmneId = hovedEmneId;
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
