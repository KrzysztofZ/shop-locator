package com.shoplocator;

import com.google.maps.GeoApiContext;
import com.shoplocator.conf.JerseyConfig;
import com.shoplocator.service.*;
import com.shoplocator.store.*;
import org.glassfish.jersey.servlet.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopLocatorApplication {

	@Bean
	public IShopDetailsHolder getShopDetailsHolder() { return new ShopDetailsHolder(); }

	@Bean
	public ILocationAPI locationAPI() { return new LongLatLookupService(); }

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registration;
	}

	@Bean
	public GeoApiContext context() { return new GeoApiContext().setApiKey("AIzaSyD3-Vt0v46dxOnuRklzhZULfjq_6WhmZs8"); }

	public static void main(String[] args) {
		SpringApplication.run(ShopLocatorApplication.class, args);
	}
}
