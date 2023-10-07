package com.qa.pages;

import com.qa.constants.AppConstants;
import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By productText = By.tagName("h1");

    private By productImagesCount = By.xpath("//div[@id='content']//img");



    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    public String getProductHeaderText(){
       return elementUtil.waitForElementVisible(productText, AppConstants.SHORT_TIMEOUT).getText();
    }

    public int getProductImagesCount(){
      return  elementUtil.waitForElementsVisible(productImagesCount,AppConstants.MEDIUM_TIMEOUT).size();
    }
}
