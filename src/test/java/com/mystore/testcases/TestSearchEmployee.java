package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddEmployee;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchEmployee;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSearchEmployee extends BaseClass {
    SearchEmployee searchEmployee;
    LoginPage loginPage;
    AddEmployee addEmployee;

    @BeforeTest
    public void setup(){
        launchApp();
        searchEmployee = new SearchEmployee();
        loginPage = new LoginPage();
        addEmployee = new AddEmployee();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
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
    public void moveToEmployeeList(){
        searchEmployee.moveToEmployeeList();
    }

    @Test(priority = 4)
    public void searchEmployeeName(){
        searchEmployee.enterUsername("John");
    }

    @Test(priority = 5)
    public void clickSearchButton() throws InterruptedException {
        searchEmployee.clickSearchButton();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void getEmployeeListHeader(){
        String actualText = searchEmployee.getRecordHeading();
        String noText = "No";

        //verifying 'No' should not contain in actual text
        boolean validateText = !actualText.contains(noText);
        Assert.assertTrue(validateText);
    }

}
