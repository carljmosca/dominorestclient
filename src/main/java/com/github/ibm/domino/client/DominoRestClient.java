/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.client;

import com.github.ibm.domino.resource.Calendar;
import com.github.ibm.domino.resource.CalendarEvent;
import com.github.ibm.domino.resource.wrapper.CalendarEventsWrapper;
import com.github.ibm.domino.resource.wrapper.CalendarWrapper;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author moscac
 */
public class DominoRestClient extends BaseClient {

    public List<Calendar> getCalendars() {

        init();
        ResponseEntity<CalendarWrapper> response = restTemplate.exchange(getUri(),
                HttpMethod.GET, getHttpEntity(), CalendarWrapper.class);
        CalendarWrapper calendars = response.getBody();
        return calendars.getCalendars();

    }

    public List<CalendarEvent> getEvents() {

        init("events");

        ResponseEntity<CalendarEventsWrapper> response = restTemplate.exchange(getUri(),
                HttpMethod.GET, getHttpEntity(), CalendarEventsWrapper.class);

        CalendarEventsWrapper events = response.getBody();
        return events.getEvents();

    }
    
    public ResponseEntity<Object> postEvent(CalendarEventsWrapper events) {
       
        init("events");
        
        ResponseEntity<Object> result = restTemplate.postForEntity(getUri(), events, Object.class);
        
        return result;
        
    }
    
//    public ResponseEntity<Object> putEvent(CalendarEventsWrapper events) {
//        
//        init("events");
//        
////        ResponseEntity<Object> result = restTemplate.p
//        
//        return result;
//    }

    public DominoRestClient format(String value) {
        parameters.put("format", value);
        return this;
    }

    public DominoRestClient since(Date value) {
        parameters.put("since", getDateParameter(value));
        return this;
    }

    public DominoRestClient before(Date value) {
        parameters.put("before", getDateParameter(value));
        return this;
    }

    public DominoRestClient count(Integer value) {
        parameters.put("count", value.toString());
        return this;
    }

    public DominoRestClient start(Integer value) {
        parameters.put("start", value.toString());
        return this;
    }
    
}
