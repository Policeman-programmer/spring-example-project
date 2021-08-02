package com.epam.springexample.services;


import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.springexample.model.entities.Event;
import com.epam.springexample.model.entities.Ticket;
import com.epam.springexample.model.entities.User;

@Service
public class TicketService {

    public TicketService() {
    }

    public boolean bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return false;
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return Collections.emptyList();
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return Collections.emptyList();
    }

    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
