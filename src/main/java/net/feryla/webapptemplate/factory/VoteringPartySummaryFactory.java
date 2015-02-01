/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.feryla.webapptemplate.models.Votering;
import net.feryla.webapptemplate.models.VoteringPartySummary;

/**
 *
 * @author clario
 */
public class VoteringPartySummaryFactory {
    
    
    
    public List<VoteringPartySummary> getVoteringPartySummery(List<Votering> votering){
       
    List<VoteringPartySummary> voteringPartySummaryList = new ArrayList<>();
    //PartyName, Votering
        Map<String,List<Votering>> vMap = new HashMap<>();
        
        votering.stream().forEach((vot) -> {
            String partyName = vot.getRep().getParty().getName();
            List<Votering> vList;
            if(vMap.get(partyName) != null){
                vList = vMap.get(partyName);
                vList.add(vot);
                
            }else{
                vList = new ArrayList<>();
                vList.add(vot);
            }
            vMap.put(partyName, vList);
        });
        
        vMap.entrySet().stream().map((entry) -> {
            return entry;
        }).map((entry) -> {
            VoteringPartySummary vtPs = new VoteringPartySummary();
            vtPs.setPartyName(entry.getKey());
            for(Votering v : entry.getValue()){
                vtPs.add(v.getVote());
                vtPs.setPartyCode(v.getRep().getParty().getPartyId());
            }
            return vtPs;
        }).forEach((vtPs) -> {
            voteringPartySummaryList.add(vtPs);
        });
        return voteringPartySummaryList;
    }
    
    
}
