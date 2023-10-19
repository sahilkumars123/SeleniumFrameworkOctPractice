package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @BeforeClass
    public void register(){
      registerPage =  loginPage.navigateToRegisterPage();
    }

    public String getEmailId(){
        return "opencart"+System.currentTimeMillis()+"@yopmail.com";
    }

//    @DataProvider
//    public Object[][] getData(){
//        return new Object[][] {
//                {"sahils","kumars","1234567890","sahil@123","yes"},
//                {"rithicas","sa","1234567890","rithica@12345","no"}
//        };
//    }

    @DataProvider
    public Object[][] getDataThroughExcel(){
        Object[][] data = ExcelUtil.getData("register");
        return data;
    }

    @Test(dataProvider = "getDataThroughExcel")
    public void registerTest(String firstName, String lastName, String phoneNo, String pwd, String subscribe){
        Assert.assertTrue(registerPage.registerUser(firstName,lastName,
                getEmailId(),phoneNo,pwd,subscribe));
    }
}
