package org.google.maps.api.streetviewimagemetadata.client;

import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class StreetViewImageMetadataClientTest {

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testGetImageMetadataInvalidKey() throws IOException {
        StreetViewImageMetadataClient client = new StreetViewImageMetadataClient();

        StreetViewImageMetadataRequestParameters requestParams = new StreetViewImageMetadataRequestParameters();
        requestParams.setLat(40.0894432);
        requestParams.setLng(-83.0175018);
        StreetViewImageMetadataResponse imageMetadata = client.getImageMetadata(requestParams);

        assertNotNull(imageMetadata);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testGetImageMetadataInvalidLat() throws IOException {
        StreetViewImageMetadataClient client = new StreetViewImageMetadataClient();

        StreetViewImageMetadataRequestParameters requestParams = new StreetViewImageMetadataRequestParameters();
        requestParams.setLng(-83.0175018);
        requestParams.setKey("notAValidKey");
        StreetViewImageMetadataResponse imageMetadata = client.getImageMetadata(requestParams);

        assertNotNull(imageMetadata);
    }
}