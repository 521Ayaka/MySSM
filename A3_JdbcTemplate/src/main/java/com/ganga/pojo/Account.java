package com.ganga.pojo;

public class Account {

    private String user;
    private long money;

    public Account() {
    }

    public Account(String user, long money) {
        this.user = user;
        this.money = money;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user='" + user + '\'' +
                ", money=" + money +
                '}';
    }
}
