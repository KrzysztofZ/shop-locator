package com.shoplocator.service;

import com.shoplocator.beans.ShopDetails;
import com.shoplocator.store.IShopDetailsHolder;
import com.shoplocator.vo.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
@Service
public class ManageShopHolderService implements IManageShopHolderService {

    @Autowired
    private IShopDetailsHolder shopDetailsHolder;

    @Autowired
    private ILocationAPI locationAPI;

    @Override
    public void addShop(ShopVO shop) {
        Double[] lngLat = locationAPI.postcodeGeocode(shop.getShopAddress().getNumber(), shop.getShopAddress().getPostcode());
        shop = updateLngLat(shop, lngLat);
        shopDetailsHolder.addShop(shop.convertToEntity());
    }

    private ShopVO updateLngLat(ShopVO shop, Double[] lngLat) {
        return new ShopVO.Builder()
                .shopName(shop.getShopName())
                .addressNumber(shop.getShopAddress().getNumber())
                .postcode(shop.getShopAddress().getPostcode())
                .shopLongitude(lngLat[0])
                .shopLatitude(lngLat[1])
                .build();
    }

    @Override
    public ShopVO findShop(String shopName) {
        ShopDetails shopDetails = shopDetailsHolder
                .getArrayOfValues()
                .stream()
                .filter(sd -> sd.getShopName().equals(shopName))
                .findFirst()
                .get();
        return new ShopVO.Builder()
                .shopName(shopDetails.getShopName())
                .addressNumber(shopDetails.getShopAddress().getNumber())
                .postcode(shopDetails.getShopAddress().getPostcode())
                .shopLongitude(shopDetails.getShopLongitude())
                .shopLatitude(shopDetails.getShopLatitude())
                .build();
    }
}
