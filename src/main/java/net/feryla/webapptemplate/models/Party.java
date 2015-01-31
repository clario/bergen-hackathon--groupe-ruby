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
public class Party {
    
    
    private String partyId;
    private String name;

    public Party(String partyId, String name) {
        this.partyId = partyId;
        this.name = name;
    }

    public Party() {
    }

    
    
    
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
}
