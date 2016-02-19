package com.epam.spring.core;

import com.epam.spring.core.context.CoreApplicationContext;
import com.epam.spring.core.domain.*;
import com.epam.spring.core.domain.enums.MovieRating;
import com.epam.spring.core.domain.enums.UserRole;
import com.epam.spring.core.services.AuditoriumService;
import com.epam.spring.core.services.BookingService;
import com.epam.spring.core.services.EventService;
import com.epam.spring.core.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CoreApplicationContext.class);
        ctx.refresh();

        /**
         * creating users
         */
        UserService userService = ctx.getBean("userServiceImpl", UserService.class);

        User admin = new User();
        admin.setName("admin");
        admin.setRole(UserRole.ADMIN);
        admin.setId(userService.register(admin));

        Integer id = admin.getId();
        User byId = userService.getById(id);
        List<User> usersByName = userService.getUsersByName(admin.getName());

        User client = new User();
        client.setName("client");
        client.setRole(UserRole.CLIENT);
        client.setId(userService.register(client));

        /**
         * set-up event
         */
        EventService eventService = ctx.getBean("eventServiceImpl", EventService.class);

        //TODO ask about some kind of MovieService for some "content manager"
        Movie movie = new Movie();
        movie.setName("movie");
        movie.setRating(MovieRating.HIGH);
        movie.setDuration(Duration.ofHours(2));
        movie.setBasePrice(25.25F);
        //TODO check if ADMIN create this event
        Integer eventId = eventService.create(movie);
        //Admin assigns auditorium
        AuditoriumService auditoriumService = ctx.getBean("auditoriumServiceImpl", AuditoriumService.class);
        List<Auditorium> auditoriums = auditoriumService.getAuditoriums();
        //12-02-2016 at 21:00
        LocalDateTime eventDateTime = LocalDateTime.of(Year.now().getValue(), Month.FEBRUARY, DayOfWeek.FRIDAY.getValue(), 21, 0);
        eventService.assignAuditorium(eventId, auditoriums.get(0), eventDateTime);

        /*
        * Client looks through the list of movies and decide to book ticket eventId
        */
        List<Event> events = eventService.getAll();
        Event chosenEvent = eventService.getById(events.get(0).getId());

        //client choosing the places
        Auditorium chosenEventAuditorium = chosenEvent.getAuditorium();
        Integer seatsNumber = auditoriumService.getSeatsNumber(chosenEventAuditorium.getId());
        List<Integer> vipSeats = auditoriumService.getVipSeats(chosenEventAuditorium.getId());
        int firstPlace = 10; // standard
        int secondPlace = 11; // VIP

        //TODO think over payment process
        BookingService bookingService = ctx.getBean("bookingServiceImpl", BookingService.class);
        //show ticket prices to make decision
        float firstTicketPrice = bookingService.getTicketPrice(client, chosenEvent.getId(), firstPlace);
        float secondTicketPrice = bookingService.getTicketPrice(client, chosenEvent.getId(), secondPlace);

        List<Ticket> bookedTickets = bookingService.bookTickets(client, chosenEvent.getId(),
                new ArrayList<>(Arrays.asList(firstPlace, secondPlace)));
        //client.getTickets().addAll(bookedTickets);

        /*
        * Admin checks sold tickets to prepare event
        */
        List<Ticket> ticketsForEvent = bookingService.getSoldTicketsForEvent(eventId);
        client.setTickets(ticketsForEvent);
        userService.update(client);

    }

}
