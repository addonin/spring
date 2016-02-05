package com.epam.spring.core;

import com.epam.spring.core.context.CoreApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CoreApplicationContext.class);
        ctx.refresh();
    }

}
