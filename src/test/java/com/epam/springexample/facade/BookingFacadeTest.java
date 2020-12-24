package com.epam.springexample.facade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class BookingFacadeTest {

    @Autowired
    BookingFacade bookingFacade;

    @Test
    void getBookedTickets() {

    }
}
