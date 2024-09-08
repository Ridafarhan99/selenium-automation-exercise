package com.mystore.pageobjects;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee extends BaseClass {
    private Action action = new Action();

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement PIMButton;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement addEmployeeTab;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameinput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement personalDetailsHeading;

    public AddEmployee(){
        PageFactory.initElements(driver, this);
    }

    public void moveToPIM(){
        action.click(PIMButton);
    }

    public void moveToAddEmployee(){
        action.click(addEmployeeTab);
    }

    public void enterUsername(String userFirstName){
        action.type(firstNameinput, userFirstName);
    }

    public void enterLastname(String userLastName){
        action.type(lastNameInput, userLastName);
    }

    public void clickSaveButton(){
        action.click(saveButton);
    }

    public String getText(){
         return personalDetailsHeading.getText();
    }
}
