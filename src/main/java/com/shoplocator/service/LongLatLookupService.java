package com.shoplocator.service;

import com.google.maps.*;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by krzysztof.zielinski on 17/05/2016.
 */
public class LongLatLookupService implements ILocationAPI {

    @Autowired
    private GeoApiContext context;

    @Override
    public Double[] postcodeGeocode(String addressNumber, String postcode) {
        Double[] lngtLat = new Double[2];
        String address = addressNumber + "+" + postcode;
        try {
            GeocodingResult[] results = GeocodingApi.newRequest(context).address(address).await();
            lngtLat[0] = results[0].geometry.location.lng;
            lngtLat[1] = results[0].geometry.location.lat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lngtLat;
    }
}
