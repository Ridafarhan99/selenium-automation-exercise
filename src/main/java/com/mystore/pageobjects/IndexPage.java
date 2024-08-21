package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
    public WebElement loginButton;
}
