package com.epam.springexample.model.entities;

/**
 * Created by yevhenii_trokhniuk on 25/11/20.
 */
public interface User {
    /**
     * User Id. UNIQUE.
     * @return User Id.
     */
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);

    /**
     * User email. UNIQUE.
     * @return User email.
     */
    String getEmail();
    void setEmail(String email);

    UserAccount getUserAccount();
    void setUserAccount(UserAccount userAccount);
}
