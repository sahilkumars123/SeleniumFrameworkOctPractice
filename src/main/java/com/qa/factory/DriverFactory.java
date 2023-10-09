package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    WebDriver driver;

    Properties properties;

    public WebDriver launchBrowser(Properties properties){

        String browserName = properties.getProperty("browser");
        System.out.println("browser name is:: "+browserName);

        OptionsManager  optionsManager = new OptionsManager(properties);

        switch (browserName.trim().toLowerCase()){
            case "chrome":
                driver = new ChromeDriver(optionsManager.getChromeOptions());
                break;
            case "firefox":
                driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
                break;
            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("please enter correct browser name:: "+browserName);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("url"));

        return driver;
    }

    public Properties initProp()  {
        //1. Tell where are config.properties file is located
        //2. To load the config.properties file
        properties = new Properties();

        FileInputStream fp = null;
        try {
            fp = new FileInputStream("./src/test/resources/properties/config.properties");
            properties.load(fp);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }
}