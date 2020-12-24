package com.epam.springexample.repositorys;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.epam.springexample.model.EventImpl;
import com.epam.springexample.model.TicketImpl;
import com.epam.springexample.model.entities.Ticket;
import com.epam.springexample.repositories.TicketRepository;

@DataJpaTest
class TicketRepositoryTest {

    public static final int PLACE = 1;
    public static final double PRICE = 10d;
    public static final Ticket.Category CATEGORY = Ticket.Category.STANDARD;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TicketRepository ticketRepository;

    @Test
    void testFindByCategory() {
        EventImpl event = new EventImpl("Romeo and Juliet", LocalDateTime.of(2020,
                Month.NOVEMBER, 12, 18, 30, 40));
        entityManager.persist(event);
        EventImpl savedEvent = entityManager.find(EventImpl.class,1L);
        TicketImpl ticket = new TicketImpl(savedEvent, null, CATEGORY, PLACE, PRICE);
        entityManager.persist(ticket);
        List<TicketImpl> tickets = ticketRepository.findByCategory(CATEGORY);
        Assertions.assertThat(tickets).extracting(TicketImpl::getCategory).containsOnly(CATEGORY);
    }
}
