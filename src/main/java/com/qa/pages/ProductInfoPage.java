package com.qa.pages;

import com.qa.constants.AppConstants;
import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    private By productText = By.tagName("h1");

    private By productImagesCount = By.xpath("//div[@id='content']//img");

    private By productInfo = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][1]/li");

    private By productPriceInfo = By.xpath("//div[@id='content']//ul[@class='list-unstyled'][2]/li");

    Map<String, String> productDataMap;



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

//    Brand: Apple
//    Product Code: Product 18
//    Reward Points: 800
//    Availability: In Stock
    public void getProductInfoMetaData(){
        List<WebElement> actualProductInfo = elementUtil.waitForElementsVisible(productInfo, AppConstants.SHORT_TIMEOUT);
        //Map<String,String> productInfoMap = new HashMap<String,String >();
        for(WebElement e: actualProductInfo){
            String text = e.getText();
            String key = text.split(":")[0].trim();
            String value = text.split(":")[1].trim();
            productDataMap.put(key,value);
        }
        //System.out.println("product info is":: );
    }

//    $2,000.00
//    Ex Tax: $2,000.00
    public void getProductPriceInfoMetaData(){
        List<WebElement> actualProductPriceInfo = elementUtil.waitForElementsVisible(productPriceInfo, AppConstants.SHORT_TIMEOUT);
        Map<String,String> productPriceInfoMap = new HashMap<String,String >();
         String productPriceText = actualProductPriceInfo.get(0).getText();
         String productTax = actualProductPriceInfo.get(1).getText().split(":")[0].trim();
         String productValueTax = actualProductPriceInfo.get(1).getText().split(":")[1].trim();
        //System.out.println("product info is":: );
        productDataMap.put("productprice",productPriceText);
        productDataMap.put(productTax,productValueTax);
        //return productPriceInfoMap;
    }

    public Map<String, String> productData(){

        //productDataMap = new HashMap<>();
        //productDataMap = new LinkedHashMap<>();
        productDataMap = new TreeMap<>();
        productDataMap.put("productname",getProductHeaderText());
        productDataMap.put("productimagescount",String.valueOf(getProductImagesCount()));
        getProductInfoMetaData();
        getProductPriceInfoMetaData();

        return productDataMap;

    }
}
