package com.epam.spring.web.controllers;

import com.epam.spring.core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author dimon
 * @since 20/03/16.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = GET, params = "name")
    public ModelAndView getUsersByName(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", userService.getUsersByName(name));
        modelAndView.setViewName("users");
        return modelAndView;
    }



}
