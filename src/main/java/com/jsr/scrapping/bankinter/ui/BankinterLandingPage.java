package com.jsr.scrapping.bankinter.ui;


import com.jsr.scrapping.bankinter.extractor.AccountDataExtractor;
import com.jsr.scrapping.model.Account;
import com.jsr.scrapping.selenium.Finder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BankinterLandingPage {


    private WebDriver driver;


    public BankinterLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<Account> getAccounts()
    {
        BankinterPromotionsPage promotionsPage = new BankinterPromotionsPage(driver);
        AccountDataExtractor dataExtractor = new AccountDataExtractor(driver);

        if (promotionsPage.isPresent()) {
            promotionsPage.next();
        }



        List<Account> accounts = dataExtractor.get();

        disconnect();

        return accounts;
    }


    public void disconnect()
    {
        WebElement disconnect;

        disconnect = Finder.by(driver, By.xpath("/html/body/div[2]/div[1]/div[2]/a"));

        disconnect.click();
    }
}