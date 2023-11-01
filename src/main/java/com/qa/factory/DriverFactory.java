package com.qa.factory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

   static WebDriver driver;

    Properties properties;

    FileInputStream fp = null;

    public WebDriver launchBrowser(Properties properties){

        String browserName = properties.getProperty("browser");
        //String browserName = System.getProperty("browser");
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
        //3. Return properties instance


        //mvn clean -Denv = ""
        properties = new Properties();

       String envName =  System.getProperty("env");


       try {
           if (envName == null) {
               System.out.println("env Name received as null, so I am running it on QA env");
               fp = new FileInputStream("./src/test/resources/properties/qa.config.properties");
           } else {
               switch (envName.toLowerCase().trim()) {
                   case "qa":
                       fp = new FileInputStream("./src/test/resources/properties/qa.config.properties");
                       break;
                   case "stage":
                       fp = new FileInputStream("./src/test/resources/properties/stage.config.properties");
                       break;
                   case "dev":
                       fp = new FileInputStream("./src/test/resources/properties/dev.config.properties");
                       break;
                   case "prod":
                       fp = new FileInputStream("./src/test/resources/properties/config.properties");
                       break;
                   default:
                       System.out.println("please pass the correct value(envName)");
               }
           }
       }
       catch (FileNotFoundException e){
           e.printStackTrace();
       }

        try {
            properties.load(fp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static String getScreenshot(){
        //Step 1: Taking a screenshot and storing as a file
      TakesScreenshot ts =  (TakesScreenshot) driver;
      File scrFile = ts.getScreenshotAs(OutputType.FILE);

      //Step 2: Naming a screenshot
      String path = System.getProperty("user.dir")+"/screenshot"+System.currentTimeMillis()+".png";

      File destinationFile = new File(path);

      //Step 3: To move the screenshot to its destination file.
        try {
            FileHandler.copy(scrFile,destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}