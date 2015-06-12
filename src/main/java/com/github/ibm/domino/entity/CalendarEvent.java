/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author moscac
 */
@XmlRootElement(name = "CalendarEvent")
public class CalendarEvent {
    
    private String href;
    private String summary;
    @XmlAttribute(name="class")
    private String clazz;
    private int sequence;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" + "href=" + href + ", summary=" + summary + ", clazz=" + clazz + ", sequence=" + sequence + '}';
    }
    
    
}
