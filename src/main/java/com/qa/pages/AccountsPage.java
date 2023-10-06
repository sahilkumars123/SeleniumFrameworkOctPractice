package com.qa.pages;

import com.qa.constants.AppConstants;
import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.List;

public class AccountsPage {


    //1. private By locators
    //2. public Page Constructor
    //3. Public page actions/methods


    private WebDriver driver;
    private ElementUtil elementUtil;


    private By search = By.name("search");
    private By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");

    private By accountPageHeaders = By.xpath("//h2");

    private By logoutBtn = By.linkText("Logout");

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }


    public String getAccountsPageTitle(){
      return elementUtil.waitForTitleIs(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.SHORT_TIMEOUT);
    }

    public boolean isLogoutLinkExist(){
       return elementUtil.waitForElementPresence(logoutBtn,AppConstants.SHORT_TIMEOUT).isDisplayed();
    }

    public List<String> getAccountsPageHeader(){
        List<WebElement> accountHeadersList = elementUtil.waitForElementsVisible(accountPageHeaders, AppConstants.MEDIUM_TIMEOUT);
        List<String> actualAccountHeadersList = new ArrayList<>();
        for(WebElement e : accountHeadersList){
            String header =  e.getText();
            actualAccountHeadersList.add(header);
        }
        return actualAccountHeadersList;
    }

    public int getAccountsPageHeaderCount(){
        //getAccountsPageHeader().size();
       return elementUtil.waitForElementsVisible(accountPageHeaders, AppConstants.MEDIUM_TIMEOUT).size();
    }

    public SearchResultPage doSearch(String key){
        elementUtil.waitForElementVisible(search,AppConstants.SHORT_TIMEOUT).clear();
        elementUtil.doSendKeys(search,key);
        elementUtil.doClick(searchBtn);
        //return Search Reslut Page
        return new SearchResultPage(driver); //TDD
    }


}
