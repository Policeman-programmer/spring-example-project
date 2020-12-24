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
import com.epam.springexample.model.entities.Event;
import com.epam.springexample.repositories.EventRepository;

@DataJpaTest//We can just add it to our unit test and it will set up a Spring application context. Also includ the in-memory database
class EventRepositoryTest {

    @Autowired
    private TestEntityManager entityManager; //The purpose of the EntityManager is to interact with the persistence context.

    @Autowired
    EventRepository eventRepository;

    @Test
    void testFindByTitle(){
        EventImpl event = new EventImpl("Romeo and Juliet", LocalDateTime.of(2020,
                Month.NOVEMBER, 12, 18, 30, 40));
        entityManager.persist(event);
        List<Event> events = eventRepository.findByTitle(event.getTitle());
        events.forEach(ev -> System.out.println(ev.toString()));
        System.out.println();
        Assertions.assertThat(events).extracting(Event::getTitle).containsOnly(event.getTitle());
    }
}
