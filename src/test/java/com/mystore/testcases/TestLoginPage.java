package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestLoginPage extends BaseClass {

    LoginPage loginPage;

    @BeforeTest
    public void setup(){
        launchApp();
        loginPage = new LoginPage();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyLogo() throws InterruptedException {
        boolean result = loginPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test(priority = 2)
    public void login(){
        loginPage.enterUsername(props.getProperty("username"));
        loginPage.enterPassword(props.getProperty("password"));
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 3)
    public void getTitle(){
        String pageTitle = loginPage.getTitle();
        Assert.assertEquals(pageTitle, "OrangeHRM");
    }

    @Test(priority = 4)
    public void validateDashboard(){
        boolean dashboardTitle = loginPage.validateDashboard();
        Assert.assertTrue(dashboardTitle);
    }

    @Test(priority = 5)
    public void validateLogout() throws InterruptedException {
        loginPage.logout();
        getTitle();
    }
}
