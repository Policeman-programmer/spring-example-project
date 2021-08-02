package com.epam.springexample.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.epam.springexample.facade.BookingFacade;
import com.epam.springexample.facade.BookingFacadeImpl;
import com.epam.springexample.model.EventImpl;
import com.epam.springexample.model.entities.Event;
import com.epam.springexample.model.entities.Ticket;
import com.epam.springexample.model.entities.User;

@Controller
public class BookingController {

    private static final String INDEX = "index";
    private static final String RESULT = "result";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    @Autowired
    BookingFacadeImpl bookingFacade;

    @PostMapping("/create-event")
    String createEvent(@RequestParam String title, @RequestParam String date, Model model) {
        EventImpl event = new EventImpl(title, LocalDateTime.parse(date, formatter));
        model.addAttribute(RESULT, bookingFacade.createEvent(event));
        return INDEX;
    }

    @GetMapping("event")
    String getEventById(@RequestParam(name="eventId", required=false, defaultValue="World") long eventId, Model model){
        Event event = bookingFacade.getEventById(eventId);
        System.out.println("Event called");
        model.addAttribute(RESULT, 1);
        return INDEX;
    }

//    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);
//
//    /**
//     * Get list of events for specified day.
//     * In case nothing was found, empty list is returned.
//     * @param day Date object from which day information is extracted.
//     * @param pageSize Pagination param. Number of events to return on a page.
//     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
//     * @return List of events.
//     */
//    List<Event> getEventsForDay(LocalDateTime day, int pageSize, int pageNum);

//
//    /**
//     * Updates event using given data.
//     * @param event Event data for update. Should have id set.
//     * @return Updated Event object.
//     */
//    long updateEvent(Event event);
//
//    /**
//     * Deletes event by its id.
//     * @param eventId Event id.
//     * @return Flag that shows whether event has been deleted.
//     */
//    boolean deleteEvent(long eventId);
//
//    /**
//     * Gets user by its id.
//     * @return User.
//     */
//    User getUserById(long userId);
//
//    /**
//     * Gets user by its email. Email is strictly matched.
//     * @return User.
//     */
//    User getUserByEmail(String email);
//
//    /**
//     * Get list of users by matching name. Name is matched using 'contains' approach.
//     * In case nothing was found, empty list is returned.
//     * @param name Users name or it's part.
//     * @param pageSize Pagination param. Number of users to return on a page.
//     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
//     * @return List of users.
//     */
//    List<User> getUsersByName(String name, int pageSize, int pageNum);
//
//    /**
//     * Creates new user. User id should be auto-generated.
//     * @param user User data.
//     * @return Created User object.
//     */
//    boolean createUser(User user);
//
//    /**
//     * Updates user using given data.
//     * @param user User data for update. Should have id set.
//     * @return Updated User object.
//     */
//    boolean updateUser(User user);
//
//    /**
//     * Deletes user by its id.
//     * @param userId User id.
//     * @return Flag that shows whether user has been deleted.
//     */
//    boolean deleteUser(long userId);
//
//    /**
//     * Book ticket for a specified event on behalf of specified user.
//     * @param userId User Id.
//     * @param eventId Event Id.
//     * @param place Place number.
//     * @param category Service category.
//     * @return Booked ticket object.
//     * @throws IllegalStateException if this place has already been booked.
//     */
//    boolean bookTicket(long userId, long eventId, int place, Ticket.Category category);
//
//    /**
//     * Get all booked tickets for specified user. Tickets should be sorted by event date in descending order.
//     * @param user User
//     * @param pageSize Pagination param. Number of tickets to return on a page.
//     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
//     * @return List of Ticket objects.
//     */
//    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);
//
//    /**
//     * Get all booked tickets for specified event. Tickets should be sorted in by user email in ascending order.
//     * @param event Event
//     * @param pageSize Pagination param. Number of tickets to return on a page.
//     * @param pageNum Pagination param. Number of the page to return. Starts from 1.
//     * @return List of Ticket objects.
//     */
//    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);
//
//    /**
//     * Cancel ticket with a specified id.
//     * @param ticketId Ticket id.
//     * @return Flag whether anything has been canceled.
//     */
//    boolean cancelTicket(long ticketId);
//
//    /**
//     * Fill the user account.
//     * @param money for account.
//     * @param user money as owner of account.
//     */
//    public void fillUserAccount(User user, double money);
}
