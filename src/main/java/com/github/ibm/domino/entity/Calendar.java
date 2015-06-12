/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author moscac
 */
public class Calendar {
    
    @XmlAttribute(name = "owner")
    private CalendarOwner calendarOwner;
    @XmlAttribute(name = "links")
    private List<CalendarLink> calendarLinks;

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
