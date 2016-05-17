package com.shoplocator;

import com.google.maps.GeoApiContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopLocatorApplication {

	@Bean
	public IShopDetailsHolder getShopDetailsHolder() { return new ShopDetailsHolder(); }

	@Bean
	public GeoApiContext context() { return new GeoApiContext().setApiKey("AIzaSyD3-Vt0v46dxOnuRklzhZULfjq_6WhmZs8"); }

	public static void main(String[] args) {
		SpringApplication.run(ShopLocatorApplication.class, args);
	}
}
