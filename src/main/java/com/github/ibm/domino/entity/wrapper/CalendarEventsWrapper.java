/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.entity.wrapper;

import com.github.ibm.domino.entity.CalendarEvent;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moscac
 */

@XmlRootElement(name = "events")
public class CalendarEventsWrapper {
    
    private List<CalendarEvent> events;

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CalendarEvent> events) {
        this.events = events;
    }
    
}
