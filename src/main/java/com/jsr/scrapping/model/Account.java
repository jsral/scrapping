package com.jsr.scrapping.model;

import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Account {

    private String number;
    private String balance;

    public Account(String number, String balance)
    {
        this.number = number;
        this.balance = balance;
    }

    public void print()
    {
        System.out.println("Account number = " + getNumberOffuscated() + "\t Balance=" + balance);
    }

    private String getNumberOffuscated()
    {
        Random rnd = new Random();
        String offuscated = number;
        for(int i=0; i<6; i++) {
            offuscated = offuscated.replace(String.valueOf(rnd.nextInt(10)), "*");
        }

        return offuscated;
    }
}
