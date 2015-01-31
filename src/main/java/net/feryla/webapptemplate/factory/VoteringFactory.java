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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author clario
 */
public class VoteringFactory {

    public Map<String, Object> getVotering(Integer voteringId) throws IOException {

        final String urlVotering = "http://data.stortinget.no/eksport/voteringsresultat?VoteringId=" + voteringId.toString() + "&format=JSON";

        String result = get(urlVotering);

        
        HashMap<String,Object> objectMap =new ObjectMapper().readValue(result, HashMap.class);
        
        
        
        
        
        return objectMap;
    }

    private String get(final String urlVotering) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlVotering);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }


 
    
}
