/*
 * Copyright 2015 moscac.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.ibm.domino.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moscac
 */
public class EventTime {

    @JsonProperty("date")
    private String eDate;
    @JsonProperty("time")
    private String eTime;
    private boolean utc;

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public boolean isUtc() {
        return utc;
    }

    public void setUtc(boolean utc) {
        this.utc = utc;
    }

    public Date getEventDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String timeZone;
        if (isUtc()) {
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            timeZone = "Z";
        } else {
            timeZone = TimeZone.getDefault().getID();
        }
        try {
            return sdf.parse(geteDate() + "T" + geteTime() + timeZone);
        } catch (ParseException ex) {
            Logger.getLogger(EventTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "EventTime{" + "eDate=" + eDate + ", eTime=" + eTime + ", utc=" + utc + '}';
    }

}
