package com.shoplocator.rest;

import com.shoplocator.service.IManageShopHolderService;
import com.shoplocator.vo.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
@Component
public class RestShopAPI {

    @Autowired
    private IManageShopHolderService manageShopHolderService;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addShop(@Valid ShopVO shop) {
         manageShopHolderService.addShop(shop);
    }
}
