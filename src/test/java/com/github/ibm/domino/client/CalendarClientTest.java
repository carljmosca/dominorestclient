/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.client;

import com.github.ibm.domino.config.ClientConfig;
import com.github.ibm.domino.entity.Calendar;
import com.github.ibm.domino.entity.CalendarEvent;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moscac
 */
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

    private CalendarClient initClient() {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        CalendarClient client = new CalendarClient();
        client.setAddress(clientConfig.address());
        client.setUsername(clientConfig.username());
        client.setPassword(clientConfig.password());
        client.setDatabase(clientConfig.database());
        return client;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCalendars method, of class CalendarClient.
     */
    @Test
    public void testGetCalendars() {
        System.out.println("getCalendars");
        CalendarClient instance = initClient();
        List<Calendar> result = instance.getCalendars();
        assertTrue(result != null && !result.isEmpty()); // && result.get(0).getCalendarOwner() != null);
        result.stream().forEach((calendar) -> {
            System.out.println(calendar.toString());
        });
    }

    /**
     * Test of getEvents method, of class CalendarClient.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        CalendarClient instance = initClient();
        List<CalendarEvent> result = instance.getEvents();
        assertTrue(result != null && !result.isEmpty());
        result.stream().forEach((calendarEvent) -> {
            System.out.println(calendarEvent.toString());
        });
    }

}
