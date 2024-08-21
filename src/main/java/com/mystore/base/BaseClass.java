package com.mystore.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import com.mystore.actiondrivers.Action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static Properties props = new Properties();
    public static WebDriver driver;

    @BeforeSuite
    public void loadConfiguration() {
        try{
            System.out.println("Loading configuration...");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "Configuration/config.properties");
            props.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchApp(String browserName) {
        // String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            // Set Browser to ThreadLocalMap
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        Action action = new Action();
        action.implicitWait(driver, 10);
        action.pageLoadTimeOut(driver, 30);

        driver.get(props.getProperty("url"));
    }
}
