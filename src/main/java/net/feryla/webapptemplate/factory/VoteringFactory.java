/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.feryla.webapptemplate.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.feryla.webapptemplate.models.Party;
import net.feryla.webapptemplate.models.Representative;
import net.feryla.webapptemplate.models.SaksVotering;
import net.feryla.webapptemplate.models.Vote;
import net.feryla.webapptemplate.models.Votering;
import net.feryla.webapptemplate.models.VoteringSummary;
import net.feryla.webapptemplate.util.Downloader;

/**
 *
 * @author clario
 */
public class VoteringFactory {

    public List<Votering> getVotering(Integer voteringId) throws IOException {
        Map<String, Object> map = getVoteringMap(voteringId);

        List<Votering> l = new ArrayList<>();

        for (Map<String, Object> vote : (List<Map<String, Object>>) map.get("voteringsresultat_liste")) {
            l.add(convertVotering(vote));
        }

        return l;
    }

    private Map<String, Object> getVoteringMap(Integer voteringId) throws IOException {

        final String urlVotering = "http://data.stortinget.no/eksport/voteringsresultat?VoteringId=" + voteringId.toString() + "&format=JSON";

        Downloader downloader = new Downloader();

        String result = downloader.get(urlVotering);

        HashMap<String, Object> objectMap = new ObjectMapper().readValue(result, HashMap.class);

        return objectMap;
    }

    private Votering convertVotering(Map<String, Object> vote) {
        Votering v = new Votering();
        Representative rep = convertRepresentative((Map<String, Object>) vote.get("representant"));

        v.setRep(rep);

        v.setVote((int) vote.get("votering"));

        return v;
    }

    public Representative convertRepresentative(Map<String, Object> map) {
        Representative rep = new Representative();

        rep.setGivenName((String) map.get("fornavn"));
        rep.setFamilyName((String) map.get("etternavn"));
        rep.setRepresentativeId((String) map.get("id"));
        rep.setGender((int) map.get("kjoenn"));

        Map<String, Object> fylkeMap = (Map<String, Object>) map.get("fylke");

        rep.setFylke((String) fylkeMap.get("navn"));

        rep.setEpost((String) map.get("epost"));

        Party party = convertParty((Map<String, Object>) map.get("parti"));

        rep.setParty(party);

        return rep;
    }

    private Party convertParty(Map<String, Object> map) {

        Party party = new Party((String) map.get("id"), (String) map.get("navn"));

        return party;
    }

    public SaksVotering getVoteringForSak(String saksId) throws IOException {
        String s = new Downloader().get("http://data.stortinget.no/eksport/voteringer?sakid=" + saksId + "&format=json");
        if (s == null || s.length() == 0) {
            return null;
        }

        HashMap<String, Object> objectMap = new ObjectMapper().readValue(s, HashMap.class);

        return convertSaksVotering(objectMap);

    }

    private SaksVotering convertSaksVotering(HashMap<String, Object> map) {
        SaksVotering s = new SaksVotering();

        s.setVoteringSummaryList(convertVoteringSummaryList((List<Map<String, Object>>) map.get("sak_votering_liste")));
        if (s.getVoteringSummaryList().isEmpty()) {
            s.setVoteringDescription("Ingen votering i denne saken.");
        } else {
            s.setVoteringDescription((String) ((List<Map<String, Object>>) map.get("sak_votering_liste")).get(0).get("votering_tema"));
        }

        return s;
    }

    private List<VoteringSummary> convertVoteringSummaryList(List<Map<String, Object>> list) {
        List<VoteringSummary> l = new ArrayList<>();

        for (Map<String, Object> map : list) {
            VoteringSummary vts = new VoteringSummary((int) map.get("antall_for"), (int) map.get("antall_mot"), (int) map.get("antall_ikke_tilstede"));
            vts.setDescription((String) map.get("votering_tema"));
            l.add(vts);
        }

        return l;
    }

}
