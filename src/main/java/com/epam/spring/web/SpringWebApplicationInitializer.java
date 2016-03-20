package com.epam.spring.web;

import com.epam.spring.core.context.CoreApplicationContext;
import com.epam.spring.web.context.WebApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author dimon
 * @since 20/03/16.
 */
public class SpringWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebApplicationContext.class);
        context.register(CoreApplicationContext.class);
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("springmvc", new DispatcherServlet(context));
        servletRegistration.addMapping("/*");
        servletRegistration.setLoadOnStartup(1);
    }
}
