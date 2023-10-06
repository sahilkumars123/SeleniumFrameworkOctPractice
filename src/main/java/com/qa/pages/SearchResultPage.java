package com.qa.pages;

import com.qa.constants.AppConstants;
import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By produtText = By.tagName("h1");
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public void getProductText(){
        elementUtil.waitForElementVisible(produtText, AppConstants.SHORT_TIMEOUT);
    }
}
