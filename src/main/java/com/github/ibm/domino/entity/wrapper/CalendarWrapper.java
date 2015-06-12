/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.entity.wrapper;

import com.github.ibm.domino.entity.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moscac
 */
@XmlRootElement(name = "calendars")
public class CalendarWrapper {

    private List<Calendar> events;

    public List<Calendar> getEvents() {
        return events;
    }

    public void setEvents(List<Calendar> events) {
        this.events = events;
    }


}
