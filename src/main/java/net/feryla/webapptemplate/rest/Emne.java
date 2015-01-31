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

/**
 *
 * @author clario
 */
@Path("/votering")
public class Emne {
    
    
     @GET
 
    public List<Emne> getEmneList() throws IOException {

        return null;
        
        
    
    }
    
    
}
