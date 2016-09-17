package com.jsr.scrapping.bankinter.ui;

import com.jsr.scrapping.selenium.Finder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BankinterPromotionsPage {


    private WebDriver driver;



    public BankinterPromotionsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPresent() {
        try {
            Finder.by(driver, By.xpath("//*[@id=\"id_content_01_nm\"]/table/tbody/tr/td/table/tbody/tr/td/form[2]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/a"));
        }
        catch (NoSuchElementException e) {
            return false;
        }

        return true;
    }


    public BankinterLandingPage next()
    {

        WebElement enter = Finder.by(driver, By.xpath("//*[@id=\"id_content_01_nm\"]/table/tbody/tr/td/table/tbody/tr/td/form[2]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/a"));

        enter.click();

        return new BankinterLandingPage(driver);
    }
}
