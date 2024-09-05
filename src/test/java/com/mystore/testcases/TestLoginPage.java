package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.LoginPage;
import org.apache.poi.ss.formula.functions.Index;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseClass {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setup(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyLogo() throws InterruptedException {
        System.out.println("Running");
        boolean result = loginPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test
    public void getTitle(){
        String pageTitle = loginPage.getTitle();
        Assert.assertEquals(pageTitle, "OrangeHRM");
    }
}
