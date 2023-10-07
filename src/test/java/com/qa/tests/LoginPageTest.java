package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest  extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest(){
       String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void loginURLTest(){
        String url = loginPage.getUrl();
        Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
    }

    @Test(priority = 3)
    public void checkForgotPasswordLinkExists(){

        Assert.assertTrue(loginPage.isForgotPasswordLinkExists());
    }

    @Test(priority = 4)
    public void loginTest(){
       //String accountPageActualTitle = loginPage.doLogin("sahil12345@yopmail.com","Sahil@12345");
      // Assert.assertEquals(accountPageActualTitle,"My Account");

        accountsPage = loginPage.doLogin("sahil12345@yopmail.com","Sahil@12345");
        Assert.assertEquals(accountsPage.getAccountsPageTitle(),AppConstants.ACCOUNT_PAGE_TITLE);

    }
}
