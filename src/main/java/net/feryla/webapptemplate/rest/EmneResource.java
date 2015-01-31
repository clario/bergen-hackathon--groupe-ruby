/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.rest;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import net.feryla.webapptemplate.factory.EmneFactory;
import net.feryla.webapptemplate.models.Emne;

/**
 *
 * @author clario
 */
@Path("/emne")
public class EmneResource {
    
    
     @GET
 
    public List<Emne> getEmneList() throws IOException {

         EmneFactory emnefactory = new EmneFactory();
         
        
        return emnefactory.getEmneList();
        
        
    
    }
    
    
}
