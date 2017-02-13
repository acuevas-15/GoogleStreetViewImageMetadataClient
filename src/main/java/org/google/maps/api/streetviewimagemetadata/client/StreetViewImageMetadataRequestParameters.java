package org.google.maps.api.streetviewimagemetadata.client;

public class StreetViewImageMetadataRequestParameters {

    private Double lat;
    private Double lng;
    private String key;
    private String location;
    private String client;
    private String signature;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "StreetViewImageMetadataRequestParameters{" +
                "lat=" + lat +
                ", lng=" + lng +
                ", location='" + location + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}
