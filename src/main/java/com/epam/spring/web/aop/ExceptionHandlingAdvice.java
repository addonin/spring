package com.epam.spring.web.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dimon
 * @since 20/03/16.
 */
@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "ERROR: " + e.getMessage());
        modelAndView.setViewName("exception");
        return modelAndView;
    }

}
