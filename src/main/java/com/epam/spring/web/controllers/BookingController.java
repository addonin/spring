package com.epam.spring.web.controllers;

import com.epam.spring.core.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author dimon
 * @since 20/03/16.
 */
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(method = GET)
    public ModelAndView testMapping(ModelMap model) {
        return new ModelAndView("index", model);
    }

    @RequestMapping(value = "/price", method = GET, params = {"eventId", "seat"})
    @ResponseBody
    public float getTicketPrice(@RequestParam int eventId,
                                @RequestParam int seat) {
        return bookingService.getTicketPrice(null, eventId, seat);
    }

}

