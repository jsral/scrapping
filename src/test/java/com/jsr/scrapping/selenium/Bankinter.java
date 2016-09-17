package com.jsr.scrapping.selenium;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Bankinter {

    private static UIServer server;

    @BeforeClass
    public static void setup() throws Exception
    {
        server = new UIServer();
        server.start();
    }


    @AfterClass
    public static void tearDown()
    {
        if (server != null) {
            server.stop();
        }
    }


    @Test
    public void testLoginUsingSafari()
    {
        WebDriver driver = new SafariDriver();

        try {
            testLogin(driver);
        }
        finally {
            driver.quit();
        }
    }


    private void testLogin(WebDriver driver)
    {
        driver.get("http://bankinter.com");
        BankinterLoginPage loginPage = new BankinterLoginPage(driver);

        loginPage.login("JSANROMAN", "Mjhp6733");
    }
}
