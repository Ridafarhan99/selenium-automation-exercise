package com.mystore.pageobjects;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseClass {
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchInput;


    public DashboardPage() {
        PageFactory.initElements(driver,this);
    }

    Action action = new Action();

    public void searchMenu(String searchText) {
        action.type(searchInput, searchText);
    }

    public String getTitle(){
        return action.getTitle(driver);
    }
}
