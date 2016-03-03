/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.domino.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.href);
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.summary);
        hash = 19 * hash + Objects.hashCode(this.clazz);
        hash = 19 * hash + this.sequence;
        hash = 19 * hash + Objects.hashCode(this.transparency);
        hash = 19 * hash + Objects.hashCode(this.lastModified);
        hash = 19 * hash + Objects.hashCode(this.start);
        hash = 19 * hash + Objects.hashCode(this.end);
        hash = 19 * hash + Objects.hashCode(this.location);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CalendarEvent other = (CalendarEvent) obj;
        if (this.sequence != other.sequence) {
            return false;
        }
        if (!Objects.equals(this.href, other.href)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.summary, other.summary)) {
            return false;
        }
        if (!Objects.equals(this.clazz, other.clazz)) {
            return false;
        }
        if (!Objects.equals(this.transparency, other.transparency)) {
            return false;
        }
        if (!Objects.equals(this.lastModified, other.lastModified)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
    }

}
