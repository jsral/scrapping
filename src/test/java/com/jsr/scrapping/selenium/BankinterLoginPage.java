package com.jsr.scrapping.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankinterLoginPage {


    private WebDriver driver;


    public BankinterLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public BankinterLandingPage login(String id, String pin)
    {
        setId(id);
        setPin(pin);
        return doLogin();
    }


    private void setId(String id)
    {
        WebElement userName = Finder.by(driver, By.id("lg_username"));
        userName.sendKeys(id);
    }


    private void setPin(String pin)
    {
        WebElement password = Finder.by(driver, By.id("lg_password"));

        password.sendKeys(pin);
    }


    private BankinterLandingPage doLogin()
    {
        WebElement enter = Finder.by(driver, By.xpath("//*[@id=\"frmLogin\"]/div[6]/input"));
        BankinterLandingPage landingPage = new BankinterLandingPage(driver);

        enter.click();
        landingPage.gotoAccounts();

        return null;
    }
}