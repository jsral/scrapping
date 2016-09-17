package com.jsr.scrapping.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BankinterLandingPage {


    private WebDriver driver;


    public BankinterLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void gotoAccounts()
    {
        BankinterPromotionsPage promotionsPage = new BankinterPromotionsPage (driver);

        if (promotionsPage.isPresent()) {
            promotionsPage.next();
        }

        disconnect();
    }


    public void disconnect()
    {
        WebElement disconnect;

        disconnect = Finder.by(driver, By.xpath("/html/body/div[2]/div[1]/div[2]/a"));

        disconnect.click();
    }
}