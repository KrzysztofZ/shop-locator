package com.shoplocator;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
@Component
public class ShopDetailsHolder implements IShopDetailsHolder {
    private List<ShopDetails> shopArray;

    public ShopDetailsHolder() {
        this.shopArray = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addShop(ShopDetails shopDetails) {
        this.shopArray.add(shopDetails);
    }

    @Override
    public List<ShopDetails> getArrayOfValues() {
        return this.shopArray;
    }
}
