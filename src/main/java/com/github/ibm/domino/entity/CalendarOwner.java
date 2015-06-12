/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moscac
 */
@XmlRootElement(name = "owner")
public class CalendarOwner {
    
    private String displayName;
    private String distinguishedName;
    private String homeServer;
    private String email;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDistinguishedName() {
        return distinguishedName;
    }

    public void setDistinguishedName(String distinguishedName) {
        this.distinguishedName = distinguishedName;
    }

    public String getHomeServer() {
        return homeServer;
    }

    public void setHomeServer(String homeServer) {
        this.homeServer = homeServer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CalendarOwner{" + "displayName=" + displayName + ", distinguishedName=" + distinguishedName + ", homeServer=" + homeServer + ", email=" + email + '}';
    }
    
}
