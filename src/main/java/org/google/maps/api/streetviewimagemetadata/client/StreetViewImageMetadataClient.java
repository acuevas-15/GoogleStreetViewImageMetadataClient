package org.google.maps.api.streetviewimagemetadata.client;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StreetViewImageMetadataClient {

    private final String BASE_URL = "https://maps.googleapis.com/maps/api/streetview/metadata?";

    private final GsonBuilder GSON_BUILDER = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setDateFormat("MM-yyyy");

    public StreetViewImageMetadataResponse getImageMetadata(StreetViewImageMetadataRequestParameters params) throws IOException {
        this.validateParams(params);

        URL streetViewImageUrl = this.getUrl(params);

        URLConnection connection = streetViewImageUrl.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine = null;
        StringBuffer result = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {
            result.append(inputLine);
        }

        StreetViewImageMetadataResponse streetViewImageMetadataResponse = GSON_BUILDER.create().fromJson(result.toString(), StreetViewImageMetadataResponse.class);

        return streetViewImageMetadataResponse;
    }

    private void validateParams(StreetViewImageMetadataRequestParameters params) {
        if (params.getLocation() == null && (params.getLat() == null || params.getLng() == null)) {
            throw new IllegalArgumentException("Provide location(), or lat() and lng()");
        } else if (params.getLocation() != null && params.getLat() != null) {
            throw new IllegalArgumentException("Provide location() eg. 'Columbus, OH', or lat() and lng(). Do not provide both.");
        }

        if (params.getKey() == null && params.getClient() == null) {
            throw new IllegalArgumentException("Provide an api key, or a client and signature. More information can be found here: https://developers.google.com/maps/documentation/streetview/get-api-key");
        } else if (params.getKey() != null && params.getClient() != null) {
            throw new IllegalArgumentException("Provide an api key or a client. Do not provide both.");
        }
    }

    private URL getUrl(StreetViewImageMetadataRequestParameters params) throws MalformedURLException {
        StringBuffer address = new StringBuffer(BASE_URL);
        if (params.getLocation() != null) {
            address.append("location=" + params.getLocation());
        } else {
            address.append("location=" + params.getLat() + "," + params.getLng());
        }

        if (params.getKey() != null) {
            address.append("&key=" + params.getKey());
        } else {
            address.append("&client=" + params.getClient());
        }

        if (params.getSignature() != null) {
            address.append("&signature=" + params.getSignature());
        }

        return new URL(address.toString());
    }

}