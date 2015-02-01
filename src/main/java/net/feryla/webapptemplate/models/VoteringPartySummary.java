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
public class VoteringPartySummary {

    private String partyName;
    private String partyCode;
    private int countFor;
    private int countMot;
    private int countIkkeTilstede;
   //2 - man, 1- lady
    private int gender;
    
   

    
    
    public VoteringPartySummary() {
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    
    
    
    public VoteringPartySummary(String partyName, int countFor, int countMot, int countIkkeTilstede) {
        this.partyName = partyName;
        this.countFor = countFor;
        this.countMot = countMot;
        this.countIkkeTilstede = countIkkeTilstede;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    
    
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public int getCountFor() {
        return countFor;
    }

    public void setCountFor(int countFor) {
        this.countFor = countFor;
    }

    public int getCountMot() {
        return countMot;
    }

    public void setCountMot(int countMot) {
        this.countMot = countMot;
    }

    public int getCountIkkeTilstede() {
        return countIkkeTilstede;
    }

    public void setCountIkkeTilstede(int countIkkeTilstede) {
        this.countIkkeTilstede = countIkkeTilstede;
    }

       public void add(int value){
       // 1 Ikkje tilstede, 2 For, 3 Mot
        
        switch(value){
            case 1:
                countIkkeTilstede++;
                break;
            case 2:
                countFor++;
                break;
            case 3:
                countMot++; 
                break;
            default:
                 break;
          
        }
             
        
    }
    
    
}
