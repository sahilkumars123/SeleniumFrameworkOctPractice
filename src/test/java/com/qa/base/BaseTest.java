package com.qa.base;

import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;
    protected LoginPage loginPage;
    protected AccountsPage accountsPage;

    protected SearchResultPage searchResultPage;

    @BeforeTest
    public void setup(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    loginPage = new LoginPage(driver);
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
