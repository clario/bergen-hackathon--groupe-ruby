/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author sondre
 */
@Path("test")
public class Test {
    
    @GET
    public String test() {
        return "woop!";
    }
    
}
