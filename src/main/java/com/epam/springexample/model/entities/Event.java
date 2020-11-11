package com.epam.springexample.model.entities;

import java.time.LocalDateTime;

/**
 * Created by maksym_govorischev.
 */
public interface Event {
    /**
     * Event id. UNIQUE.
     * @return Event Id
     */
    long getId();
    void setId(long id);
    String getTitle();
    void setTitle(String title);
    LocalDateTime getDate();
    void setDate(LocalDateTime date);
}
