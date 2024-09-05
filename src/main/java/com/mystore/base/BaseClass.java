package com.mystore.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import com.mystore.actiondrivers.Action;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static Properties props = new Properties();
    public static WebDriver driver;

    @BeforeTest
    public void loadConfiguration() {
        try{
            System.out.println("Loading configuration...");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
            props.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchApp() {
        String browserName = props.getProperty("browser");
        if (browserName == null) {
            throw new RuntimeException("Browser name is not specified in the config.properties file.");
        }

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException("Browser name specified in the config.properties file is not supported: " + browserName);
        }

        //Maximize the screen
        driver.manage().window().maximize();
        //Delete all the cookies
        driver.manage().deleteAllCookies();

        Action action = new Action();
        action.implicitWait(driver, 10);
        action.pageLoadTimeOut(driver, 30);

        driver.get(props.getProperty("url"));
    }
}
