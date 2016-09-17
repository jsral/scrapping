package com.jsr.scrapping.selenium;

import org.openqa.selenium.server.SeleniumServer;

public class UIServer {


    private static SeleniumServer server;


    public static void start() throws Exception
    {
        if (server != null ) {
            server = new SeleniumServer();
            server.boot();
        }
    }


    public static void stop()
    {
        if (server != null) {
            server.stop();
        }
    }
}
