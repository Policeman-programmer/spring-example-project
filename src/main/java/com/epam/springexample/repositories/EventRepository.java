package com.epam.springexample.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.springexample.model.EventImpl;

public interface EventRepository extends CrudRepository<EventImpl, Long> {

    List<EventImpl> findByTitle(String title);
}
