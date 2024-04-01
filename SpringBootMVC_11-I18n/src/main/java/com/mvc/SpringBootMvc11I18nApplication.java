package com.mvc;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootMvc11I18nApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvc11I18nApplication.class, args);
	}
	
	@Bean(name = "localeResolver")
	SessionLocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en", "US"));
		return resolver;
	}
	
	@Bean
	LocaleChangeInterceptor localChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

}
