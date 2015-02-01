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
import net.feryla.webapptemplate.models.Emne;
import net.feryla.webapptemplate.util.Downloader;

/**
 *
 * @author clario
 */
public class EmneFactory {

    private Map<String, Object> getEmneMap() throws IOException {

        final String url = "http://data.stortinget.no/eksport/emner?format=JSON";

        Downloader downloader = new Downloader();

        String result = downloader.get(url);

        HashMap<String, Object> objectMap = new ObjectMapper().readValue(result, HashMap.class);

        return objectMap;

    }

    private static List<Emne> _emneList;
    
    public List<Emne> getEmneList() throws IOException {
        if (_emneList != null) {
            return _emneList;
        }
        
        Map<String, Object> map = getEmneMap();
        List<Emne> l = convertEmneList(map);

        _emneList = l;
        return l;
    }

    public List<Emne> convertEmneList(Map<String, Object> map) {
        List<Emne> l = new ArrayList<>();

        for (Map<String, Object> emne : (List<Map<String, Object>>) map.get("emne_liste")) {
            l.add(convertEmne(emne));
        }
        return l;
    }

    private Emne convertEmne(Map<String, Object> emneMap) {

        String emneNavn = (String) emneMap.get("navn");
        Integer hovedEmneId = (Integer) emneMap.get("hovedemne_id");
        Integer emneId = (Integer) emneMap.get("id");
        
        boolean isHovedEmne = (boolean) emneMap.get("er_hovedemne");

        Emne emne = new Emne(emneNavn, isHovedEmne, hovedEmneId, emneId);

        return emne;

    }

}
