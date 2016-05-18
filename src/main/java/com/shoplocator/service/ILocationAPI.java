package com.shoplocator.service;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
public interface ILocationAPI {
    Double[] postcodeGeocode(String addressNumber, String postcode);
}
