/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.rest;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import net.feryla.webapptemplate.factory.RepresentativeFactory;
import net.feryla.webapptemplate.models.Representative;

/**
 *
 * @author clario
 */

@Path("/representanter")
public class Representanter {
    
  
    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Representative getrep(@PathParam("personId") String personId) throws IOException {
 
        return new RepresentativeFactory().getRepresentative(personId);
    }
    
    
    
}
