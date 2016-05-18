package com.shoplocator.store;

import com.shoplocator.beans.ShopDetails;
import com.shoplocator.store.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
public class ShopDetailsHolderTest {

    @Test
    public void testAddSingleShopDetails() throws Exception {
        final String shopName = "Name 1";
        final String addressNumber = "22";
        final String postcode = "NW107HB";
        final Double longitude = -0.2884105d;
        final Double latitude = 51.5304814d;

        ShopDetails shopDetails = new ShopDetails.Builder()
                .shopName(shopName)
                .addressNumber(addressNumber)
                .postcode(postcode)
                .longitude(longitude)
                .latitude(latitude)
                .build();

        IShopDetailsHolder holder = new ShopDetailsHolder();
        holder.addShop(shopDetails);
        List<ShopDetails> results = holder.getArrayOfValues();

        assertEquals(shopName, results.get(0).getShopName());
        assertEquals(addressNumber, results.get(0).getShopAddress().getNumber());
        assertEquals(postcode, results.get(0).getShopAddress().getPostcode());
        assertEquals(longitude, results.get(0).getShopLongitude(),5);
        assertEquals(latitude, results.get(0).getShopLatitude(),5);
    }
}
