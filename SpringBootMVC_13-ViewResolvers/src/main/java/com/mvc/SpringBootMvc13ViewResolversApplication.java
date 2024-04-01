package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class SpringBootMvc13ViewResolversApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvc13ViewResolversApplication.class, args);
	}
	
	@Bean
	ViewResolver createBeanNameViewResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
	}

}
