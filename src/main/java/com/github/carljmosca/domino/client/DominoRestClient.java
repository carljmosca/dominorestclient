/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.domino.client;

import com.github.carljmosca.domino.resource.Calendar;
import com.github.carljmosca.domino.resource.CalendarEvent;
import com.github.carljmosca.domino.resource.wrapper.CalendarEventsWrapper;
import com.github.carljmosca.domino.resource.wrapper.CalendarWrapper;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

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
        try {

            ResponseEntity<Object> result = restTemplate.postForEntity(getUri(), events, Object.class);
            return result;
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    public void putEvent(CalendarEventsWrapper events) throws HttpClientErrorException {

        init("events");

        restTemplate.put(getUri(), events);

    }

    public List<String> deleteEvent(List<String> eventIds) {

        init("events");

        List<String> result = new ArrayList<>();

        for (String eventId : eventIds) {
            try {
                restTemplate.delete(getUri(eventId).toString());
            } catch (HttpClientErrorException e) {
                result.add(eventId);
            }
        }
        return result;
    }

    public DominoRestClient format(String value) {
        parameters.put("format", value);
        return this;
    }

    public DominoRestClient since(ZonedDateTime value) {
        parameters.put("since", getDateParameter(value.withZoneSameInstant(ZoneId.of("GMT"))));
        return this;
    }

    public DominoRestClient before(ZonedDateTime value) {
        parameters.put("before", getDateParameter(value.withZoneSameInstant(ZoneId.of("GMT"))));
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
