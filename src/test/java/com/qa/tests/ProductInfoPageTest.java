package com.qa.tests;

import com.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductInfoPageTest extends BaseTest {

    @BeforeClass
    public void productInfoSetup(){
        accountsPage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
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

    @Test
    public void productInfoTest(){
       searchResultPage = accountsPage.doSearch("macbook");
       productInfoPage = searchResultPage.selectProduct("MacBook Pro");
       Map<String, String> actualProductData = productInfoPage.productData();
        System.out.println("Actual Product Data: "+actualProductData);

        softAssert.assertEquals(actualProductData.get("Availability"),"In Stock");
        softAssert.assertEquals(actualProductData.get("Brand"),"Apple");
        softAssert.assertEquals(actualProductData.get("Ex Tax"),"$2,000.00");
        softAssert.assertEquals(actualProductData.get("Reward Points"),"800");
        softAssert.assertAll();

    }
}
