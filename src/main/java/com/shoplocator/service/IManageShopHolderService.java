package com.shoplocator.service;

import com.shoplocator.vo.ShopVO;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
public interface IManageShopHolderService {
    void addShop(ShopVO shop);

    ShopVO findShop(String shopName);
}
