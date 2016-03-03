/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.domino.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moscac
 */
@JsonPropertyOrder({
"owner",
"links"
})
public class Calendar {
    
    @JsonProperty("owner")
    private CalendarOwner calendarOwner;
    @JsonProperty("links")
    private List<CalendarLink> calendarLinks;
    
    public Calendar() {
        calendarOwner = new CalendarOwner();
        calendarLinks = new ArrayList<>();
    }

    public CalendarOwner getCalendarOwner() {
        return calendarOwner;
    }

    public void setCalendarOwner(CalendarOwner calendarOwner) {
        this.calendarOwner = calendarOwner;
    }

    public List<CalendarLink> getCalendarLinks() {
        return calendarLinks;
    }

    public void setCalendarLinks(List<CalendarLink> calendarLinks) {
        this.calendarLinks = calendarLinks;
    }

    @Override
    public String toString() {
        return "Calendar{" + "calendarOwner=" + calendarOwner + ", calendarLinks=" + calendarLinks + '}';
    }
    
    
}
