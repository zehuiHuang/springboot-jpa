package com.example.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.TemplateException;

@Configuration
public class Config {
	@Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
        factory.setTemplateLoaderPaths("classpath:template");
        factory.setDefaultEncoding("UTF-8");
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setConfiguration(factory.createConfiguration());
        return result;
    }
	
//	@Bean
//	public FreeMarkerConfigurer freeMarkerConfigurer() {
//		FreeMarkerConfigurer freeMarkerConfigurer=new FreeMarkerConfigurer();
//		freeMarkerConfigurer.setTemplateLoaderPaths("classpath:template");
//		freeMarkerConfigurer.setDefaultEncoding("UTF-8");
//		return freeMarkerConfigurer;
//	}
}
