/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author moscac
 */
@JsonPropertyOrder({
    "href",
    "id",
    "summary",
    "location",
    "start",
    "end",
    "class",
    "transparency",
    "sequence",
    "last-modified"
})
public class CalendarEvent {

    private String href;
    private String id;
    private String summary;
    @JsonProperty("class")
    private String clazz;
    private int sequence;
    private String transparency;
    @JsonProperty("last-modified")
    private String lastModified;
    private EventTime start;
    private EventTime end;
    private String location;
    @JsonProperty("x-lotus-organizer")
    private CalendarEventAttribute organizer;
    @JsonProperty("x-lotus-summarydataonly")
    private CalendarEventAttribute summaryDataOnly;
    @JsonProperty("x-lotus-noticetype")
    private CalendarEventAttribute noticeType;
    @JsonProperty("x-lotus-appttype")
    private CalendarEventAttribute appointmentType;

    public CalendarEvent() {
        start = new EventTime();
        end = new EventTime();
    }

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

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public EventTime getStart() {
        return start;
    }

    public void setStart(EventTime start) {
        this.start = start;
    }

    public EventTime getEnd() {
        return end;
    }

    public void setEnd(EventTime end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CalendarEventAttribute getOrganizer() {
        return organizer;
    }

    public void setOrganizer(CalendarEventAttribute organizer) {
        this.organizer = organizer;
    }

    public CalendarEventAttribute getSummaryDataOnly() {
        return summaryDataOnly;
    }

    public void setSummaryDataOnly(CalendarEventAttribute summaryDataOnly) {
        this.summaryDataOnly = summaryDataOnly;
    }

    public CalendarEventAttribute getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(CalendarEventAttribute noticeType) {
        this.noticeType = noticeType;
    }

    public CalendarEventAttribute getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(CalendarEventAttribute appointmentType) {
        this.appointmentType = appointmentType;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" + "href=" + href + ", id=" + id + ", summary=" + summary + ", clazz=" + clazz + ", sequence=" + sequence + ", transparency=" + transparency + ", lastModified=" + lastModified + ", start=" + start + ", end=" + end + ", location=" + location + '}';
    }

}
