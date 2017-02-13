package org.google.maps.api.streetviewimagemetadata.client;

import java.util.Date;

public class StreetViewImageMetadataResponse {
    private String copyright;
    private Date date;
    private Location location;
    private String panoId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPanoId() {
        return panoId;
    }

    public void setPanoId(String panoId) {
        this.panoId = panoId;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    private StatusType status;

    @Override
    public String toString() {
        return "StreetViewImageMetadataResponse{" +
                "copyright='" + copyright + '\'' +
                ", date=" + date +
                ", location=" + location +
                ", panoId='" + panoId + '\'' +
                ", status=" + status +
                '}';
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
