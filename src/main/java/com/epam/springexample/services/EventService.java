package com.epam.springexample.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.springexample.dao.EventDAO;
import com.epam.springexample.model.entities.Event;

public class EventService {

    @Autowired
    EventDAO eventDAO;

    public Event getEventById(long eventId) {
        return eventDAO.getEventById(eventId);
    }

    public List<Event> getEventsByTitle(String title) {
        return eventDAO.getEventsByTitle(title);
    }

    public List<Event> getEventsForDay(LocalDateTime day) {
        return eventDAO.getEventsForDay(day);
    }

    public Event createEvent(Event event) {
        return eventDAO.createEvent(event);
    }

    public void deleteEvent(long eventId) {
        eventDAO.deleteEvent(eventId);
    }
}
