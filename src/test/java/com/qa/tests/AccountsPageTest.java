package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void login(){
        accountsPage = loginPage.doLogin("sahil123456@yopmail.com","Selenium@12345");
    }

    @Test
    public void accountPageTitleTest(){
       String actualAccountPageTitle = accountsPage.getAccountsPageTitle();
        Assert.assertEquals(actualAccountPageTitle, AppConstants.ACCOUNT_PAGE_TITLE);
    }

    @Test
    public void isLogoutLinkExistTest(){
       // Assert.assertEquals(accountsPage.isLogoutLinkExist(),true);
        Assert.assertTrue(accountsPage.isLogoutLinkExist());
    }

    @Test
    public void getAccountPageHeadersTest(){
        //Assert.assertTrue(accountsPage.getAccountsPageHeader(),"My Account",);
            Assert.assertEquals(accountsPage.getAccountsPageHeader(), AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST);
    }

    @Test
    void getAccountPageHeadersCount(){

        Assert.assertEquals(accountsPage.getAccountsPageHeaderCount(),4);
    }

    //two dimensional object array
    @DataProvider
    public Object[][] productData(){
        return new Object[][]{
                {"macbook",3},
                {"samsung",2},
                {"canon",1}
        };
    }

    @Test(dataProvider = "productData")
    public void search(String searchKey, int expectedProductCount){
      searchResultPage =  accountsPage.doSearch(searchKey);
      int actualProductCount = searchResultPage.getSearchResultsCount();
      Assert.assertEquals(actualProductCount,expectedProductCount);
    }

}
