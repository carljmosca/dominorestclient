/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.carljmosca.domino.client;

import com.github.carljmosca.domino.client.DominoRestClient;
import com.github.carljmosca.domino.config.ClientConfig;
import com.github.carljmosca.domino.resource.Calendar;
import com.github.carljmosca.domino.resource.CalendarEvent;
import com.github.carljmosca.domino.resource.wrapper.CalendarEventsWrapper;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author moscac
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalendarClientTest {

    private ClientConfig clientConfig;

    public CalendarClientTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        clientConfig = ConfigFactory.create(ClientConfig.class);
    }

    private DominoRestClient initClient() {
        DominoRestClient client = new DominoRestClient();
        client.setAddress(clientConfig.address());
        client.setUsername(clientConfig.username());
        client.setPassword(clientConfig.password());
        client.setDatabase(clientConfig.database());
        client.setIgnoreHostNameMatching(clientConfig.ignoreHostNameMatching());
        return client;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCalendars method, of class CalendarClient.
     */
    @Test
    public void test0GetCalendars() {
        System.out.println("getCalendars");
        DominoRestClient instance = initClient();
        List<Calendar> result = instance.getCalendars();
        assertTrue(result != null && !result.isEmpty()); // && result.get(0).getCalendarOwner() != null);
        result.stream().forEach((calendar) -> {
            System.out.println(calendar.toString());
        });
    }

    @Test
    public void test1PostEvents() {
        System.out.println("postEvents");
        DominoRestClient instance = initClient();
        CalendarEventsWrapper events = new CalendarEventsWrapper();
        CalendarEvent event = new CalendarEvent();
        event.setSummary("This is a new event");
        event.setLocation("here");
        ZonedDateTime zdt = ZonedDateTime.now().plusDays(10);
        event.getStart().setDateTime(zdt);
        event.getEnd().setDateTime(zdt.plusHours(2));
        events.getEvents().add(event);
        ResponseEntity<Object> response = instance.postEvent(events);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    /**
     * Test of getEvents method, of class CalendarClient.
     */
    @Test
    public void test2GetEvents() {
        System.out.println("getEvents");
        DominoRestClient instance = initClient();
        instance.since(ZonedDateTime.now().minusDays(10));
        List<CalendarEvent> result = instance.getEvents();
        assertTrue(result != null && !result.isEmpty());
        result.stream().forEach((calendarEvent) -> {
            System.out.println(calendarEvent.toString());
            System.out.println(calendarEvent.getStart().getEventDateTime());
        });
    }

    @Test
    public void test3PutEvents() {
        System.out.println("putEvents");

    }

    @Test
    public void test9DeleteEvents() {
        System.out.println("deleteEvents");
        DominoRestClient instance = initClient();
        java.util.Calendar calendar = java.util.Calendar.getInstance();

        List<String> eventIds = new ArrayList<>();
        eventIds.add("EvEnTiD...wE...DO..not...EXPECT...to...FIND...EVER!!!");
        List<String> eventsNotDeleted = instance.deleteEvent(eventIds);
        assertTrue(eventsNotDeleted.size() == 1);

        instance.since(ZonedDateTime.now().minusHours(1));
        List<CalendarEvent> result = instance.getEvents();

        eventIds.clear();
        result.stream().forEach((calendarEvent) -> {
            eventIds.add(calendarEvent.getId());
        });
        eventsNotDeleted = instance.deleteEvent(eventIds);
        assertTrue(eventsNotDeleted.isEmpty());
    }

}
