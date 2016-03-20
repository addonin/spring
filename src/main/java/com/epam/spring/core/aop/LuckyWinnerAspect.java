package com.epam.spring.core.aop;

import com.epam.spring.core.domain.entities.Ticket;
import com.epam.spring.core.domain.entities.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @author Dmytro_Adonin
 * @since 2/15/2016.
 */
@Aspect
@Component
public class LuckyWinnerAspect {

    public static final int LUCKY_NUMBER = 7;

    private Random random = new Random();

    @Pointcut("execution(java.util.List<com.epam.spring.core.domain.entities.Ticket> com.epam.spring.core.services.BookingService+.bookTickets(com.epam.spring.core.domain.entities.User, Integer, java.util.List<Integer>))")
    private void bookingTickets() {}

    @AfterReturning(pointcut = "bookingTickets()", returning = "retVal")
    public void makeUserLucky(JoinPoint joinPoint, Object retVal) {
        User user = (User) joinPoint.getArgs()[0];
        if (!user.isLucky() && luckyGenerator()) {
            List<Ticket> tickets = (List<Ticket>) retVal;
            for (Ticket ticket : tickets) {
                ticket.setPrice(0F);
            }
        }
    }

    private boolean luckyGenerator() {
        int min = 1, max = 100;
        return random.nextInt(max - min + 1) + min == LUCKY_NUMBER;
    }

}
