package com.mystore.pageobjects;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {


    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//img[@alt='company-branding']")
    public WebElement orangeHRMLogo;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
    public WebElement loginButton;

    public LoginPage(){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    Action action = new Action();


    public boolean validateLogo(){
        if (this.orangeHRMLogo == null) {
            System.out.println("Username input element is null!");
            return false;
        } else {
            // Proceed with actions
            return action.isDisplayed(driver, this.orangeHRMLogo);
        }

    }

    public String getTitle(){
        return action.getTitle(driver);
    }

    public boolean enterUsername( String userName){
        return action.type(usernameInput, userName);
    }

    public boolean enterPassword( String password){
        return action.type(passwordInput, password);
    }

    public DashboardPage clickLoginButton(){
        action.click(driver, loginButton);
        return new DashboardPage();
    }
}
