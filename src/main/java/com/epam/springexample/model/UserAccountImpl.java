package com.epam.springexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.epam.springexample.model.entities.UserAccount;

@Entity(name = "UserAccount")//we have to specify name of entity and name of table because the class name is different
@Table(name = "user_account")
public class UserAccountImpl implements UserAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;
    private double prepaidMoney;

    public UserAccountImpl(double prepaidMoney) {
        this.prepaidMoney = prepaidMoney;
    }

    @Override
    public double getPrepaidMoney() {
        return prepaidMoney;
    }

    @Override
    public void setPrepaidMoney(double money) {
        prepaidMoney = money;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
