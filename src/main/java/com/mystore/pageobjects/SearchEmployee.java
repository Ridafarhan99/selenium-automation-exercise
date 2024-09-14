package com.mystore.pageobjects;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEmployee extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement employeeListTab;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//label[contains(text(),'Employee Name')]/parent::div/following-sibling::div//input")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    private WebElement employeeRecordsHeader;

    public SearchEmployee(){
        PageFactory.initElements(driver, this);
    }

    public void moveToEmployeeList(){
        action.click(employeeListTab);
    }

    public String getRecordHeading(){
        String actualValue = employeeRecordsHeader.getText();
        return actualValue;
    }

    public void enterUsername(String userFirstName){
        action.type(employeeNameInput, userFirstName);
    }

    public void clickSearchButton(){
        action.click(searchButton);
    }

}
