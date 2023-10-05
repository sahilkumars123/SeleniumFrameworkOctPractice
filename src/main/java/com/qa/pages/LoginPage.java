package com.qa.pages;

import com.qa.constants.AppConstants;
import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //1. private By locators
    //2. public Page Constructors
    //3. Public page actions


    private WebDriver driver;
    private ElementUtil elementUtil;

    private By login_email = By.id("input-email");
    private By login_password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPassword = By.linkText("Forgotten Password");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getPageTitle(){
       //String title = driver.getTitle();
        String title = elementUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE,AppConstants.SHORT_TIMEOUT);
        return title;
    }
    public String getUrl(){
        String url = elementUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION,AppConstants.MEDIUM_TIMEOUT);
        return url;
    }
    public boolean isForgotPasswordLinkExists(){
          return  elementUtil.waitForElementVisible(forgotPassword,AppConstants.SHORT_TIMEOUT).isDisplayed();

    }
    public String doLogin(String email, String password){
        elementUtil.waitForElementVisible(login_email,AppConstants.SHORT_TIMEOUT).sendKeys(email);
        elementUtil.doSendKeys(login_password,password);
        elementUtil.doClick(loginBtn);
        return elementUtil.waitForTitleIs(AppConstants.ACCOUNT_PAGE_TITLE,AppConstants.MEDIUM_TIMEOUT); //Account Page title
    }
}
