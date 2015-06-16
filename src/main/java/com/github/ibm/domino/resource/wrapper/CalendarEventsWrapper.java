/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.resource.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ibm.domino.resource.CalendarEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moscac
 */

public class CalendarEventsWrapper {
    
    @JsonProperty("events")
    private List<CalendarEvent> events;
    
    public CalendarEventsWrapper() {
        events = new ArrayList<>();
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CalendarEvent> events) {
        this.events = events;
    }
    
}
