package com.shoplocator.init;

import com.google.maps.GeoApiContext;
import com.shoplocator.service.*;
import com.shoplocator.store.*;
import org.springframework.context.annotation.*;

/**
 * Created by krzysztof.zielinski on 16/05/2016.
 */
@Configuration
@ComponentScan(value = "com.shoplocator", excludeFilters = @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION))
public class ApplicationTest {

    @Bean(name = "shopDetailsHolder")
    public IShopDetailsHolder shopDetailsHolder() { return new ShopDetailsHolder(); }

    @Bean
    public GeoApiContext context() { return new GeoApiContext().setApiKey("AIzaSyD3-Vt0v46dxOnuRklzhZULfjq_6WhmZs8"); }

    @Bean
    public ILocationAPI locationAPI() { return new LongLatLookupService();}
}
