package com.jsr.scrapping.model;

import org.openqa.selenium.interactions.Actions;

public class Account {

    private String number;
    private double balance;

    public Account(String number, double balance)
    {
        this.number = number;
        this.balance = balance;
    }

    public void print()
    {
        System.out.print("Account number = " + number + "\t Balance=" + balance);
    }
}
