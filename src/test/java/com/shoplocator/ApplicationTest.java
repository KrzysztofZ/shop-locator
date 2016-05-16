package com.shoplocator;

import org.springframework.context.annotation.*;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
@Configuration
@ComponentScan(value = "com.shoplocator", excludeFilters = @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION))
public class ApplicationTest {

    @Bean(name = "shopDetailsHolder")
    public IShopDetailsHolder shopDetailsHolder() { return new ShopDetailsHolder(); }
}
