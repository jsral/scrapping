package com.jsr.scrapping.bankinter.extractor;


import com.jsr.scrapping.model.Account;
import com.jsr.scrapping.selenium.Finder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class AccountDataExtractor {


    private WebDriver driver;


    public AccountDataExtractor(WebDriver driver)
    {
        this.driver = driver;
    }


    public List<Account> get()
    {
        WebElement table = Finder.by(driver, By.xpath("//*[@id=\"id_content_02\"]/div/div[3]/div[3]/div/div[2]/div/table/tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        return processRows(rows);
    }


    private List<Account> processRows(List<WebElement> rows)
    {
        List<Account> accounts = new ArrayList<Account>();

        for (WebElement row: rows)
        {
            Account account = processRow(row);
            accounts.add(account);
        }

        return accounts.size() > 0 ? accounts : null;
    }


    private Account processRow(WebElement row)
    {
        String number = row.findElement(By.xpath("//tr/td[1]/div/form/input[1]")).getAttribute("value");
        String balance = row.findElement(By.xpath("//tr/td[2]/span")).getText();

        return new Account(number, balance);
    }
}