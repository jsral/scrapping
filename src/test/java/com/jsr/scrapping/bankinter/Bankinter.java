package com.jsr.scrapping.bankinter;


import com.jsr.scrapping.bankinter.ui.BankinterLoginPage;
import com.jsr.scrapping.data.UsersLoader;
import com.jsr.scrapping.model.Account;
import com.jsr.scrapping.selenium.UIServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;


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
    public void testGetAccountsUsingSafari()
    {
        WebDriver driver = new SafariDriver();

        try {
            testGetAccounts(driver);
        }
        finally {
            driver.quit();
        }
    }


    private void testGetAccounts(WebDriver driver)
    {
        BankinterLoginPage loginPage = new BankinterLoginPage(driver);
        UsersLoader loader = new UsersLoader();

        driver.get("http://bankinter.com");
        String id = loader.getUserIdFor("bankinter");
        String pin = loader.getPinFor("bankinter");

        List<Account> accounts = loginPage.getAccounts(id, pin);

        for (Account account: accounts) {
            account.print();
        }
    }
}
