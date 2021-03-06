package com.shoplocator.service;

import com.shoplocator.init.ApplicationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationTest.class})
public class LongLatLookupServiceIntegrationTest {

    public static final double EPSILON = 0.000001;

    @Autowired
    private ILocationAPI locationAPI;

    @Test
    public void whenProvidingShopAddressThenAPIReturnsLongitudeLatitude() throws Exception {

        // GIVEN
        final String addressNumber = "14";
        final String postcode = "NW107HB";

        // WHEN
        Double[] result = locationAPI.postcodeGeocode(addressNumber, postcode);

        // THEN
        assertEquals(-0.2884105d, result[0], EPSILON);
        assertEquals(51.5304814d, result[1], EPSILON);
    }

    @Test
    public void whenNotProvidingNumberThenAPIReturnsLongLat() throws Exception {

        // GIVEN
        final String addressNumber = "";
        final String postcode = "NW107HB";

        // WHEN
        Double[] result = locationAPI.postcodeGeocode(addressNumber, postcode);

        // THEN
        assertEquals(-0.2884105d, result[0], EPSILON);
        assertEquals(51.5304814d, result[1], EPSILON);
    }

    @Test
    public void whenAPIDoesntReturnLocationThenReturnEmptyArray() throws Exception {

        // GIVEN
        final String addressNumber = "";
        final String postcode = "NW106HB";

        // WHEN
        Double[] result = locationAPI.postcodeGeocode(addressNumber, postcode);

        // THEN
        assertNull(result[0]);
        assertNull(result[1]);
    }
}
