package com.epam.springexample.facade;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.springexample.model.entities.Event;
import com.epam.springexample.model.entities.Ticket;
import com.epam.springexample.model.entities.User;
import com.epam.springexample.services.EventService;
import com.epam.springexample.services.TicketService;
import com.epam.springexample.services.UserService;

public class BookingFacadeImpl implements BookingFacade {

    private static final Logger LOGGER = LogManager.getLogger(BookingFacadeImpl.class);

    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;
    @Autowired
    TicketService ticketService;

    private <T> List<T> pagination(int pageSize, int pageNum, List<T> events) {
        return events.stream().skip(pageSize * (pageNum - 1)).limit(pageSize).collect(Collectors.toList());
    }

    @Override
    public Event getEventById(long eventId) {
        Event event = eventService.getEventById(eventId);
        LOGGER.debug("Event is got {}", event);
        return event;
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        List<Event> events = pagination(pageSize, pageNum, eventService.getEventsByTitle(title));
        LOGGER.debug("Events got with title {}: {}", title, events);
        return events;
    }

    @Override
    public List<Event> getEventsForDay(LocalDateTime day, int pageSize, int pageNum) {
        List<Event> events = pagination(pageSize, pageNum, eventService.getEventsForDay(day));
        LOGGER.debug("Events got for day {}: {}", day, events);
        return events;
    }

    @Override
    public long createEvent(Event event) {
        LOGGER.debug("create event {}", event);
        return eventService.createEvent(event).getId();
    }

    @Override
    public long updateEvent(Event event) {
        LOGGER.debug("update event {}", event);
        return eventService.createEvent(event).getId();
    }

    @Override
    public boolean deleteEvent(long eventId) {
        LOGGER.debug("update event with id {}", eventId);
        eventService.deleteEvent(eventId);
        return true;
    }

    @Override
    public User getUserById(long userId) {
        LOGGER.debug("get user by id {}", userId);
        return userService.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        LOGGER.debug("get user by email {}", email);
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        LOGGER.debug("get user by name {}", name);
        return userService.getUserByName(name);
    }

    @Override
    public boolean createUser(User user) {
        LOGGER.debug("create user: {}", user);
        return userService.createUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        LOGGER.debug("update user: {}", user);
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        LOGGER.debug("delete user with id = {}", userId);
        return userService.deleteUser(userId);
    }

    @Override
    public boolean bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        LOGGER.debug("User with id: {} booked ticket {} category on place {} on event with id: {}", userId,
                category, place, eventId);
        return ticketService.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        LOGGER.debug("Get booked tickets for user {}. Page size {}, page num {}", user, pageSize, pageNum);
        return ticketService.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        LOGGER.debug("get booked tickets for event {}", event);
        return ticketService.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        LOGGER.debug("cancel ticket with id: {}", ticketId);
        return ticketService.cancelTicket(ticketId);
    }

    @Override
    public void fillUserAccount(User user, double money) {
        LOGGER.debug("Fill account for user: {} on {} dollars", user, money);
    }
}
