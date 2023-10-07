package com.qa.tests;

import com.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductInfoPageTest extends BaseTest {

    @BeforeClass
    public void productInfoSetup(){
          accountsPage = loginPage.doLogin("sahil123456@yopmail.com","Selenium@12345");

    }
    @DataProvider
    public Object[][] productData(){
        return new Object[][]{
                {"macbook","MacBook Pro"},
                {"macbook","MacBook Air"},
                {"samsung","Samsung SyncMaster 941BW"}
        };
    }

    @Test(dataProvider = "productData")
    public void ProductHeaderTextTest(String searchKey, String productName){
        searchResultPage = accountsPage.doSearch(searchKey);
        productInfoPage =   searchResultPage.selectProduct(productName);
       String actualHeaderText = productInfoPage.getProductHeaderText();
       Assert.assertEquals(actualHeaderText,productName);
    }

    @DataProvider
    public Object[][] productDataWithImagesCount(){
        return new Object[][]{
                {"macbook","MacBook Pro",4},
                {"macbook","MacBook Air",4},
                {"samsung","Samsung SyncMaster 941BW",1}
        };
    }

    @Test(dataProvider = "productDataWithImagesCount")
    public void ProductImagesCountTest(String searchKey, String productName, int expectedProductImagesCount){
        searchResultPage = accountsPage.doSearch(searchKey);
        productInfoPage =   searchResultPage.selectProduct(productName);
       Assert.assertEquals(productInfoPage.getProductImagesCount(),expectedProductImagesCount);
    }
}
