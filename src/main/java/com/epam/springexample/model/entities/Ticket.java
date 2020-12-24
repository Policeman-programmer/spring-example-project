package com.epam.springexample.model.entities;

import com.epam.springexample.model.EventImpl;
import com.epam.springexample.model.UserImpl;

/**
 * Created by yevhenii_trokhniuk.
 */
public interface Ticket {
    enum Category {STANDARD, PREMIUM, BAR}

    /**
     * Ticket Id. UNIQUE.
     * @return Ticket Id.
     */
    long getId();
    void setId(long id);
    EventImpl getEvent();
    void setEvent(EventImpl event);
    UserImpl getUser();
    void setUser(UserImpl user);
    Category getCategory();
    void setCategory(Category category);
    int getPlace();
    void setPlace(int place);
    double getPrice();
    void setPrice(double price);
}
