package com.softpager.cregistration.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.softpager.cregistration"})
public class CRPWebMvcConfig implements WebMvcConfigurer {

	
	@Bean
	public UrlBasedViewResolver ubViewResolver() {
		UrlBasedViewResolver  ubViewResolver  = new UrlBasedViewResolver();
		ubViewResolver.setViewClass(JstlView.class);
		ubViewResolver.setPrefix("/WEB-INF/views/");
		ubViewResolver.setSuffix(".jsp");
		return ubViewResolver;
	}
		
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/statics/");
	}

}





















