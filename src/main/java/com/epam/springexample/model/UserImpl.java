package com.epam.springexample.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.epam.springexample.model.entities.User;
import com.epam.springexample.model.entities.UserAccount;

@Entity(name = "User")
@Table(name = "users")// in Hibernate you can not use table name 'user'
public class UserImpl implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id") //it is just demonstration, we can just to name column userId
    private long id;
    private String name;
    private String email;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = UserAccountImpl.class) //CascadeType.ALL need to seve UserUccount before User
    @JoinColumn(name = "user_id")
    @MapsId //makes ids parent entity and child the same. Otherwise ids in user and userAccount will be different
    private UserAccount userAccount;

    public UserImpl() {
    }

    public UserImpl(String name, String email, UserAccount userAccount) {
        this.name = name;
        this.email = email;
        this.userAccount = userAccount;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public UserAccount getUserAccount() {
        return userAccount;
    }

    @Override
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

}
