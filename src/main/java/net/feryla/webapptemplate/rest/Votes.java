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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.feryla.webapptemplate.factory.VoteringFactory;
import net.feryla.webapptemplate.models.Votering;
import net.feryla.webapptemplate.models.*;

/**
 *
 * @author sondre
 */
@Path("/votering")
@Produces(MediaType.APPLICATION_JSON)
public class Votes {

    @GET
    @Path("/{id}")

    public List<Votering> getVote(@PathParam("id") Integer id) throws IOException {
        return new VoteringFactory().getVotering(id);
    }

    @GET
    @Path("/{id}/summary")
    public VoteringSummary getVoteSummary(@PathParam("id") Integer id) throws IOException {

        List<Votering> votering = new VoteringFactory().getVotering(id);

        VoteringSummary vtSummary = new VoteringSummary();

        votering.stream().forEach(p -> vtSummary.add(p.getVote()));

        return vtSummary;

    }

}
