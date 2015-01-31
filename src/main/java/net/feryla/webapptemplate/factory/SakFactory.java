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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.feryla.webapptemplate.models.Sak;
import net.feryla.webapptemplate.util.Downloader;

/**
 *
 * @author clario
 */
public class SakFactory {

    public List<Sak> getSakListByEmne(Integer emneId) throws IOException {
        String sakUrl = "http://data.stortinget.no/eksport/saker?sesjonid=2014-2015&format=json";
        String get = new Downloader().get(sakUrl);

        HashMap<String, Object> sakMap = new ObjectMapper().readValue(get, HashMap.class);

        List<Sak> fullList = convertMapToSakList(sakMap);
        
        if (emneId != null) {
            return fullList.stream().filter(s -> s.containsEmne(emneId)).collect(Collectors.toList());
        }
        
        return fullList;
    }

    private List<Sak> convertMapToSakList(HashMap<String, Object> map) {
        List<Sak> l = new ArrayList<>();
        
        for (Map<String, Object> s: (List<Map<String, Object>>)map.get("saker_liste")) {
            l.add(convertSak(s));
        }
        
        return l;
    }

    private Sak convertSak(Map<String, Object> map) {
        Sak s = new Sak();
        s.setSaksId((int)map.get("id"));
        s.setEmneListe(new EmneFactory().convertEmneList(map));
        
        return s;
    }

}
