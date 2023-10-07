package com.qa.pages;

import com.qa.constants.AppConstants;
import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By produtText = By.tagName("h1");


    private By productResultCount = By.xpath("//div[@id='content']//img");
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getProductText(){
     String productText =  elementUtil.waitForElementVisible(produtText, AppConstants.SHORT_TIMEOUT).getText(); //Search - macbook
     String actualProductText =   productText.split("-")[1].trim();
     return actualProductText;//macbook

    }

    public  int getSearchResultsCount(){
      int productCount =  elementUtil.waitForElementsVisible(productResultCount, AppConstants.MEDIUM_TIMEOUT).size();
      System.out.println("total products for "+getProductText()+" are "+productCount);
      return productCount;
    }

    public ProductInfoPage selectProduct(String productName){
        elementUtil.clickElementWhenReady(By.linkText(productName),AppConstants.SHORT_TIMEOUT);
        return new ProductInfoPage(driver);
    }

}
