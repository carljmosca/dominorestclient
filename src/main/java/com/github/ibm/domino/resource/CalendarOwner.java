/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ibm.domino.resource;

import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.displayName);
        hash = 97 * hash + Objects.hashCode(this.distinguishedName);
        hash = 97 * hash + Objects.hashCode(this.homeServer);
        hash = 97 * hash + Objects.hashCode(this.email);
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
        final CalendarOwner other = (CalendarOwner) obj;
        if (!Objects.equals(this.displayName, other.displayName)) {
            return false;
        }
        if (!Objects.equals(this.distinguishedName, other.distinguishedName)) {
            return false;
        }
        if (!Objects.equals(this.homeServer, other.homeServer)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
}
