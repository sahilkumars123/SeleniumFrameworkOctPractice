package com.qa.factory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {

    private ChromeOptions co;
    private FirefoxOptions fo;
    private EdgeOptions eo;

    private Properties properties;

    public OptionsManager(Properties properties){

        this.properties = properties;
    }


    public ChromeOptions getChromeOptions(){

        co = new ChromeOptions();

        if(Boolean.parseBoolean(properties.getProperty("headless"))) {
            co.addArguments("--headless");
        }
        if(Boolean.parseBoolean(properties.getProperty("incognito"))) {
            co.addArguments("--incognito");
        }
        return co;
    }

    public FirefoxOptions getFirefoxOptions(){

        fo = new FirefoxOptions();

        if(Boolean.parseBoolean(properties.getProperty("headless"))) {
            fo.addArguments("--headless");
        }
        if(Boolean.parseBoolean(properties.getProperty("incognito"))) {
            fo.addArguments("--incognito");
        }
        return fo;
    }

}
