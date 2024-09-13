package com.mystore.pageobjects;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEmployee extends BaseClass {
    Action action = new Action();

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement PIMButton;

    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    private WebElement employeeListTab;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchInput;

}
