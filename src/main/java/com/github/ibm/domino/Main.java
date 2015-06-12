/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino;

import com.github.ibm.domino.client.CalendarClient;
import com.github.ibm.domino.config.ClientConfig;
import com.github.ibm.domino.entity.CalendarEvent;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.aeonbits.owner.ConfigFactory;


/**
 *
 * @author moscac
 */
public class Main {
    
    public static void main(String[] args) {
        
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        
        CalendarClient client = new CalendarClient();
        ClientConfig clientConfig = ConfigFactory.create(ClientConfig.class);
        client.setAddress(clientConfig.address());
        client.setUsername(clientConfig.username());
        client.setPassword(clientConfig.password());
        client.setDatabase(clientConfig.database());
        List<CalendarEvent> events = client.getEvents();
        events.stream().forEach((event) -> {
            System.out.println(event.toString());
        });
        
    }
    
}
