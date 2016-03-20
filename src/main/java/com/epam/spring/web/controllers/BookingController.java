package com.epam.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dimon
 * @since 20/03/16.
 */
@Controller
@RequestMapping("/booking")
public class BookingController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView testMapping(ModelMap model) {
        return new ModelAndView("index", model);
    }

}

