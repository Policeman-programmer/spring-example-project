package com.epam.springexample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.epam.springexample.model.TicketImpl;

public interface TicketRepository extends CrudRepository<TicketImpl, Long> {
}
