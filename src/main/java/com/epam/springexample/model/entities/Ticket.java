package com.epam.springexample.model.entities;

/**
 * Created by maksym_govorischev.
 */
public interface Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}

    /**
     * Ticket Id. UNIQUE.
     * @return Ticket Id.
     */
    long getId();
    void setId(long id);
    long getEvent();
    void setEvent(long event);
    long getUser();
    void setUser(long user);
    Category getCategory();
    void setCategory(Category category);
    int getPlace();
    void setPlace(int place);
    double getPrice();
    void setPrice(double price);
}
