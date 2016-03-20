package com.epam.spring.web.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import java.io.IOException;

/**
 * @author dimon
 * @since 20/03/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.epam.spring.web.controllers")
public class WebApplicationContext extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public VelocityConfigurer velocityConfig() throws IOException {
        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
        velocityConfigurer.setResourceLoaderPath("/WEB-INF/velocity/");
        return velocityConfigurer;
    }

    @Bean
    public VelocityViewResolver viewResolver() {
        VelocityViewResolver velocityViewResolver = new VelocityViewResolver();
        velocityViewResolver.setPrefix("");
        velocityViewResolver.setSuffix(".vm");
        return velocityViewResolver;
    }

}


