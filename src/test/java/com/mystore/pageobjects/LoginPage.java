package com.mystore.pageobjects;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BaseClass {


    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//img[@alt='company-branding']")
    public WebElement orangeHRMLogo;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
    public WebElement loginButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    public WebElement dashboardTitle;

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]//p")
    public WebElement userProfile;

    @FindBy(xpath = "//a[@class='oxd-userdropdown-link']")
    public List<WebElement> profileDropdownList;

    @FindBy(xpath = "//div[contains(@class,'alert-content')]")
    public WebElement alterContent;



    private Action action = new Action();

    public LoginPage(){

        PageFactory.initElements(driver, this);
    }

    public boolean validateLogo(){
        if (this.orangeHRMLogo == null) {
            System.out.println("Username input element is null!");
            return false;
        } else {
            // Proceed with actions
            return action.isDisplayed(this.orangeHRMLogo);
        }

    }

    public boolean validateDashboard(){
        return action.isDisplayed(dashboardTitle);
    }

    public String getTitle(){
        return action.getTitle();
    }

    public void enterUsername(String userName){
        action.type(usernameInput, userName);
    }

    public void enterPassword(String password){
        action.type(passwordInput, password);
    }

    public DashboardPage clickLoginButton(){
        action.click(loginButton);
        return new DashboardPage();
    }

    public String getInvalidText(){
        return alterContent.getText();
    }

    public LoginPage logout(){
        action.click(userProfile);
        action.click(profileDropdownList.get(3));
        return new LoginPage();
    }
}
