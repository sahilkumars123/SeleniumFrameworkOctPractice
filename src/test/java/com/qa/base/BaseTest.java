package com.qa.base;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductInfoPage;
import com.qa.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    protected LoginPage loginPage;
    protected AccountsPage accountsPage;

    protected SearchResultPage searchResultPage;

    protected ProductInfoPage productInfoPage;

    DriverFactory driverFactory;

    protected Properties properties;

    protected SoftAssert softAssert;

    @BeforeTest
    public void setup(){

        driverFactory = new DriverFactory();
        softAssert = new SoftAssert();
        properties = driverFactory.initProp();
        driver = driverFactory.launchBrowser(properties);
        loginPage = new LoginPage(driver);
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
