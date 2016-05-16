package com.shoplocator;

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

    @Override
    public void addShop(ShopVO shop) {
        shopDetailsHolder.addShop(shop.convertToEntity());
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
