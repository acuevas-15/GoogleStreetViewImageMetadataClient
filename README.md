# GoogleStreetViewImageMetadataClient
A java client for google's street view image metadata http service.

Why use this client?
* free and open-source
* easy to use - for many cases, only three classes come into play, one for request arguments, one for the http call, and one for the modelling the result)
* lightweight - GoogleStreetViewImageMetadataClient only has one dependency on Google's Gson library.  Otherwise only standard java libraries are used.

## Usage
`
        StreetViewImageMetadataClient client = new StreetViewImageMetadataClient();

        StreetViewImageMetadataRequestParameters requestParams = new StreetViewImageMetadataRequestParameters();
        requestParams.setLat(40.0894432);
        requestParams.setLng(-83.0175018);
        requestParams.setKey("your api key here");

        StreetViewImageMetadataResponse imageMetadata = client.getImageMetadata(requestParams);
        imageMetadata.getLocation().getLng();
        imageMetadata.getLocation().getLat();
        imageMetadata.getStatus();
        imageMetadata.getPanoId();
`
