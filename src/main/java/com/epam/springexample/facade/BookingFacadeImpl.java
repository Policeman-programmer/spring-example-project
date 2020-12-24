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

public class BookingFacadeImpl implements BookingFacade {

    private static final Logger LOGGER = LogManager.getLogger(BookingFacadeImpl.class);

    @Autowired
    EventService eventService;

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
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(long userId) {
        return false;
    }

    @Override
    public boolean bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return false;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return false;
    }

    @Override
    public void fillUserAccount(User user, double money) {
    }
}
