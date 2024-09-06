package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLoginPage extends BaseClass {

    LoginPage loginPage;

    @BeforeClass
    public void setup(){
        launchApp();
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyLogo() throws InterruptedException {
        System.out.println("Running");
        boolean result = loginPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test(priority = 2)
    public void getTitle(){
        String pageTitle = loginPage.getTitle();
        Assert.assertEquals(pageTitle, "OrangeHRM");
    }

    @Test(priority = 3)
    public void login(){
        loginPage.enterUsername(props.getProperty("username"));
        loginPage.enterPassword(props.getProperty("password"));
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
