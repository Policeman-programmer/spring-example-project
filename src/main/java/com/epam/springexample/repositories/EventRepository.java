package com.epam.springexample.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.springexample.model.EventImpl;
import com.epam.springexample.model.entities.Event;

public interface EventRepository extends CrudRepository<EventImpl, Long> {

    List<Event> findByTitle(String title);

    List<Event> findByDate(LocalDateTime day);
}
