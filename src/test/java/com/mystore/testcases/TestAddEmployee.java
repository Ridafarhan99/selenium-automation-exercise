package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddEmployee;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestAddEmployee extends BaseClass {
    AddEmployee addEmployee;
    LoginPage loginPage;


    @BeforeTest
    public void setup(){
        launchApp();
        logger.info("URL Opened");
        addEmployee = new AddEmployee();
        loginPage = new LoginPage();
    }

    @AfterTest
    public void teardown() throws InterruptedException {
        tearDown();
    }

    @Test(priority = 1)
    public void login(){
        loginPage.enterUsername(props.getProperty("username"));
        loginPage.enterPassword(props.getProperty("password"));
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 2)
    public void moveToPIM(){
        addEmployee.moveToPIM();
    }

    @Test(priority = 3)
    public void moveToAddEmployee(){
        addEmployee.moveToAddEmployee();
    }

    @Test(priority = 4)
    public void enterFirstName(){
        addEmployee.enterUsername("John");
    }

    @Test(priority = 5)
    public void putLastName(){
        addEmployee.enterLastname("Lenon");
    }

    @Test(priority = 6)
    public void clickSaveButton(){
        addEmployee.clickSaveButton();
    }

    @Test(priority = 7)
    public void validatePersonalDetails() throws InterruptedException {
        Thread.sleep(10000);
        String actualText = addEmployee.getText();
        String expectedText = "Personal Details";

        Assert.assertEquals(actualText, expectedText);
    }

}
