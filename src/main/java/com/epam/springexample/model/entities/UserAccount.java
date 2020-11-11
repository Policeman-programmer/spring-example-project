package com.epam.springexample.model.entities;

/**
 * Created by yevhenii_trokhniuk on 06/06/20.
 */
public interface UserAccount {
    /**
     * prepaid money.
     * @return amount of prepaid money.
     */
    public double getPrepaidMoney();
    public void setPrepaidMoney(double money);
    public long getUserId();
    public void setUserId(long userId);

}
