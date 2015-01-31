/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.models;

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
        this.voteringIdList = voteringIdList;
        this.emneListe = emneListe;
    }
    
    
    
    
    private Integer saksId;
    private List<Integer> voteringIdList;
    private List<Emne> emneListe;

    public Integer getSaksId() {
        return saksId;
    }

    public void setSaksId(Integer saksId) {
        this.saksId = saksId;
    }

    public List<Integer> getVoteringIdList() {
        return voteringIdList;
    }

    public void setVoteringIdList(List<Integer> voteringIdList) {
        this.voteringIdList = voteringIdList;
    }

    public List<Emne> getEmneListe() {
        return emneListe;
    }

    public void setEmneListe(List<Emne> emneListe) {
        this.emneListe = emneListe;
    }
    
    
    
    
    
}
