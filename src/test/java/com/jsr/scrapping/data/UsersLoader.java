package com.jsr.scrapping.data;


import java.util.ResourceBundle;

public class UsersLoader {

    private ResourceBundle properties;


    public UsersLoader()
    {
        properties = ResourceBundle.getBundle("com.jsr.scrapping.data.users");
    }


    public String getUserIdFor(String bank)
    {
        return properties.getString(bank + ".id");
    }


    public String getPinFor(String bank)
    {
        return properties.getString(bank + ".pin");
    }
 }
