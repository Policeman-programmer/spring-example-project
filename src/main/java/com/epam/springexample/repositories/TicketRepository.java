package com.epam.springexample.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.springexample.model.TicketImpl;
import com.epam.springexample.model.entities.Ticket;


public interface TicketRepository extends CrudRepository<TicketImpl, Long> {

    List<TicketImpl> findByCategory(Ticket.Category category);
}
