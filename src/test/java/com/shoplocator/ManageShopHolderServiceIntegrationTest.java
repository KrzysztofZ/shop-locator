package com.shoplocator;

import com.shoplocator.vo.ShopVO;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        final float longitude = -0.2884105f;
        final float latitude = 51.5304814f;
        ShopVO shop = new ShopVO.Builder()
                        .shopName(shopName)
                        .addressNumber(addressNumber)
                        .postcode(postcode)
                        .shopLongitude(longitude)
                        .shopLatitude(latitude)
                        .build();

        // WHEN
        manageShopService.addShop(shop);

        // THEN
        assertNotNull(manageShopService.findShop(shopName));
    }
}
