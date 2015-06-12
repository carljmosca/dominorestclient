/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.client;

import com.github.ibm.domino.entity.Calendar;
import com.github.ibm.domino.entity.CalendarEvent;
import com.github.ibm.domino.entity.wrapper.CalendarEventsWrapper;
import com.github.ibm.domino.entity.wrapper.CalendarWrapper;
import java.util.List;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author moscac
 */
public class CalendarClient extends BaseClient {

    public List<Calendar> getCalendars() {
        
        init();
        ResponseEntity<CalendarWrapper> response = restTemplate.exchange(getResourceUri(), 
                    HttpMethod.GET, getHttpEntity(), CalendarWrapper.class);        
        CalendarWrapper calendars = response.getBody();
        return calendars.getEvents();
        
    }
    
    public List<CalendarEvent> getEvents() {

        init("events");
        ResponseEntity<CalendarEventsWrapper> response = restTemplate.exchange(getResourceUri(), 
                    HttpMethod.GET, getHttpEntity(), CalendarEventsWrapper.class);        
        CalendarEventsWrapper events = response.getBody();
        return events.getEvents();

    }
    
    

}
