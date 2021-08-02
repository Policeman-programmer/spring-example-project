package com.epam.springexample.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.springexample.model.EventImpl;
import com.epam.springexample.model.entities.Event;
import com.epam.springexample.repositories.EventRepository;

@Component
public class EventDAO {

    private static final Logger logger = LogManager.getLogger(EventDAO.class);

    @Autowired
    EventRepository eventRepository;

    public Event getEventById(long eventId) {
        logger.debug("get event with id: {}", eventId);
        return eventRepository.findById(eventId).orElse(null);
    }

    public List<Event> getEventsByTitle(String title) {
        return eventRepository.findByTitle(title);
    }

    public List<Event> getEventsForDay(LocalDateTime day) {
        return eventRepository.findByDate(day);
    }

    public Event createEvent(Event event) {
        return eventRepository.save((EventImpl)event);
    }

    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }
}
