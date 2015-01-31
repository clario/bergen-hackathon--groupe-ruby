/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.feryla.webapptemplate.factory.VoteringFactory;

/**
 *
 * @author sondre
 */
@Path("test")
public class Test {
    
  
    //Votering
    //1 Ikke tilstede
    //2 For
    //3 Mot
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test2() {
        
        VoteringFactory fac = new VoteringFactory();
        Map<String,Object> map = new HashMap<String,Object>();
        
        try {
           map = fac.getVotering(1499);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return map.toString();
    }
    
    
    
}
