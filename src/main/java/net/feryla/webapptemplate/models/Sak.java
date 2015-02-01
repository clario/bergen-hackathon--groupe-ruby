/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.models;

import java.time.Instant;
import java.util.List;

/**
 *
 * @author clario
 */
public class Sak {

    public Sak() {
    }

    public Sak(Integer saksId, List<Integer> voteringIdList, List<Emne> emneListe) {
        this.saksId = saksId;
        this.emneListe = emneListe;
    }
    
    
    
    private String title;
    private String shortTitle;
    private Integer saksId;
    private List<Emne> emneListe;
    private Instant instant;
    

    
    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
    

    public Integer getSaksId() {
        return saksId;
    }

    public void setSaksId(Integer saksId) {
        this.saksId = saksId;
    }

    public List<Emne> getEmneListe() {
        return emneListe;
    }

    public void setEmneListe(List<Emne> emneListe) {
        this.emneListe = emneListe;
    }
    
    
    public boolean containsEmne(Integer emneId) {
        for (Emne e: emneListe) {
            if (e.getHovedEmneId().equals(emneId)) {
                return true;
            }
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }
    
    
}
