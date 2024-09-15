package com.mystore.pageobjects;

import com.mystore.actiondrivers.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseClass {
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchInput;

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    public WebElement dashboardHeader;

    Action action;

    public DashboardPage() {
        action = new Action();
        PageFactory.initElements(driver,this);
    }

    public void searchMenu(String searchText) {
        action.type(searchInput, searchText);
    }

    public String getTitle(){
        return action.getTitle();
    }

    public void validateDashboardTitle() throws InterruptedException {
        action.isDisplayed(dashboardHeader);
    }
}
