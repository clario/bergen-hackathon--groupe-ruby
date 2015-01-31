/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.feryla.webapptemplate.models.Representative;
import net.feryla.webapptemplate.util.Downloader;

/**
 *
 * @author clario
 */
public class RepresentativeFactory {
    
    
     public Representative getRepresentative(String id) throws IOException {
       

        final String url = "http://data.stortinget.no/eksport/representanter?stortingsperiodeid=2013-2017&format=JSON";
       
        String get = new Downloader().get(url);

        Map<String, Object> repMap = new ObjectMapper().readValue(get, HashMap.class);

       
        
        List<Representative> repList = new ArrayList<Representative>();
   
        VoteringFactory fac = new VoteringFactory();
        
        
        for (Map<String, Object> rep: (List<Map<String, Object>>) repMap.get("representanter_liste")) {
            repList.add(fac.convertRepresentative(rep));
        }
        
        
      
        
          Representative firstNonNull = repList
            .stream()
            .filter(p -> p.getRepresentativeId().toUpperCase().equals(id.toUpperCase()))
            .findFirst().get();

   
         
          return firstNonNull;
     
    }

     
    
  

 
    
    
    
    
}
