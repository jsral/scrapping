package com.jsr.scrapping.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Finder {


    private static int DEFAULT_WAIT_TIME = 10;


    public static WebElement by(WebDriver driver, By by)
    {
        return by(driver, by, DEFAULT_WAIT_TIME);
    }


    public static WebElement by(WebDriver driver, By by, int seconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
