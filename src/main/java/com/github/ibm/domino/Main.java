/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino;

import com.github.ibm.domino.client.DominoRestClient;
import com.github.ibm.domino.config.ClientConfig;
import com.github.ibm.domino.entity.CalendarEvent;
import java.util.List;
import org.aeonbits.owner.ConfigFactory;


/**
 *
 * @author moscac
 */
public class Main {
    
    public static void main(String[] args) {
                
        DominoRestClient client = new DominoRestClient();
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
