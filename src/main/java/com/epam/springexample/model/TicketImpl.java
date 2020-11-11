package com.epam.springexample.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.epam.springexample.model.entities.Event;
import com.epam.springexample.model.entities.Ticket;
import com.epam.springexample.model.entities.User;

@Entity
@Table(name = "ticket")
public class TicketImpl implements Ticket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long event;
    private long user;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int place;
    private double price;

    public TicketImpl() {
    }

    public TicketImpl(long event, long user, Category category, int place, double price) {
        this.event = event;
        this.user = user;
        this.category = category;
        this.place = place;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id:" + id +
                ", eventId:" + event +
                ", userId:" + user +
                ", category:" + category +
                ", place:" + place;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getEvent() {
        return event;
    }

    @Override
    public void setEvent(long event) {
        this.event = event;
    }

    @Override
    public long getUser() {
        return user;
    }

    @Override
    public void setUser(long user) {
        this.user = user;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int getPlace() {
        return place;
    }

    @Override
    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
