/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.domino;

import com.github.carljmosca.domino.client.DominoRestClient;
import com.github.carljmosca.domino.resource.CalendarEvent;
import java.util.List;


/**
 *
 * @author moscac
 */
public class Main {
    
    public static void main(String[] args) {
                
        DominoRestClient client = new DominoRestClient();
        List<CalendarEvent> events = client.getEvents();
        events.stream().forEach((event) -> {
            System.out.println(event.toString());
        });
        
    }
    
}
