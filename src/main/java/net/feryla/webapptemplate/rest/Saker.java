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
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import net.feryla.webapptemplate.factory.SakFactory;
import net.feryla.webapptemplate.models.Sak;

/**
 *
 * @author sondre
 */
@Path("/saker")
public class Saker {

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public List<Sak> getSaker(@QueryParam("emneId") Integer emneId) throws IOException {
        return new SakFactory().getSakListByEmne(emneId);
    }
}
