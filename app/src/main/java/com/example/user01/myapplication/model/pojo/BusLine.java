package com.example.user01.myapplication.model.pojo;

import java.util.Date;

public class BusLine {

    Integer id;
    Integer agencyId;
    String shortName;
    String longName;
    Date lastModifiedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("id: ").append(id).append(" | ");
        b.append("shortName").append(shortName).append(" | ");
        b.append("longName: ").append(longName).append(" | ");
        b.append("agencyId: ").append(agencyId).append(" | ");
        b.append("lastModifiedDate: ").append(lastModifiedDate);
        return b.toString();
    }

}
