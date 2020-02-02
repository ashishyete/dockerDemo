package com.app.microservice.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class EhCacheConfiguration {
	
	@Bean
	public CacheManager getCacheManager() {
		return new EhCacheCacheManager(cacheManagerFactoryBean().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean cacheManagerFactoryBean() {
		System.out.println("hello +");
		EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
		bean.setShared(true);
		bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		System.out.println("Hello -");
		return bean;
	}

}
