package com.jsr.scrapping.bankinter.ui;

import com.jsr.scrapping.model.Account;
import com.jsr.scrapping.selenium.Finder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BankinterLoginPage {


    private WebDriver driver;


    public BankinterLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<Account> getAccounts(String id, String pin)
    {
        setId(id);
        setPin(pin);
        return getAccounts();
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


    private List<Account> getAccounts()
    {
        WebElement enter = Finder.by(driver, By.xpath("//*[@id=\"frmLogin\"]/div[6]/input"));
        BankinterLandingPage landingPage = new BankinterLandingPage(driver);

        enter.click();
        return landingPage.getAccounts();
    }

}