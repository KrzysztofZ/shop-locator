package com.shoplocator.store;

import com.shoplocator.beans.ShopDetails;

import java.util.List;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
public interface IShopDetailsHolder {
    void addShop(ShopDetails shopDetails);

    List<ShopDetails> getArrayOfValues();
}
