/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.models;

import java.util.List;

/**
 *
 * @author Sondre
 */
public class SaksVotering {
    
    private String voteringDescription;
    
    List<VoteringSummary> voteringSummaryList;

    public SaksVotering() {
    }

    public String getVoteringDescription() {
        return voteringDescription;
    }

    public void setVoteringDescription(String voteringDescription) {
        this.voteringDescription = voteringDescription;
    }

    public List<VoteringSummary> getVoteringSummaryList() {
        return voteringSummaryList;
    }

    public void setVoteringSummaryList(List<VoteringSummary> voteringSummaryList) {
        this.voteringSummaryList = voteringSummaryList;
    }
}
