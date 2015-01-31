/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.models;

/**
 *
 * @author sondre
 */
public class Representative {
    
    private String representativeId;
    private String givenName;
    private String familyName;    
    private int gender;
    private Party party;
    private String pictureUrl;
    private String fylke;
    private String epost;

 
    public Representative() {
    }

    public String getFylke() {
        return fylke;
    }

    public void setFylke(String fylke) {
        this.fylke = fylke;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    
    
    
    public String getPictureUrl() {
        return pictureUrl;
    }
    
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }


    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
    
  

    public String getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(String representativeId) {
        this.representativeId = representativeId;
        setPictureUrl(representativeId);
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    private void setPictureUrl(String representativeId) {
        this.pictureUrl = "http://data.stortinget.no/eksport/personbilde?personid=" + representativeId;
    }

    @Override
    public String toString() {

            return this.getRepresentativeId() + " " + this.getGivenName(); //To change body of generated methods, choose Tools | Templates.
       
        
       
    }
    
    
}
