package com.shoplocator.service;

import com.shoplocator.init.ApplicationTest;
import com.shoplocator.vo.ShopVO;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationTest.class})
public class ManageShopHolderServiceIntegrationTest {

    @Autowired
    private IManageShopHolderService manageShopService;


    @Test
    public void whenAddingNewShopThenShopDetailsHolderShouldBeUpdated() throws Exception {

        // GIVEN
        final String shopName = "Name 1";
        final String addressNumber = "22";
        final String postcode = "NW107HB";
        final Double longitude = -0.2884105d;
        final Double latitude = 51.5304814d;
        ShopVO shop = new ShopVO.Builder()
                        .shopName(shopName)
                        .addressNumber(addressNumber)
                        .postcode(postcode)
                        .shopLongitude(null)
                        .shopLatitude(null)
                        .build();

        // WHEN
        manageShopService.addShop(shop);

        // THEN
        ShopVO result = manageShopService.findShop(shopName);
        assertNotNull(result);
        assertEquals(longitude, result.getShopLongitude(),5);
        assertEquals(latitude, result.getShopLatitude(),5);
    }
}
