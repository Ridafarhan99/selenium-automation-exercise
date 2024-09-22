package com.mystore.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static Properties props = new Properties();
    public static WebDriver driver;
    public WebDriverWait wait;
    public static Logger logger;

    public void loadConfiguration() {
        try{
            System.out.println("Loading configuration...");
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
            props.load(ip);

            String browserName = props.getProperty("browser");
            if (browserName == null) {
                throw new RuntimeException("Browser name is not specified in the config.properties file.");
            }else{
                switch (browserName.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        System.out.println("Chrome driver initialized successfully..");
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        System.out.println("Firefox driver initialized successfully..");
                        break;
                    case "ie":
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        System.out.println("Internet Explorer driver initialized successfully..");
                        break;
                    default:
                        throw new RuntimeException("Unsupported browser: " + browserName);
                }
            }

            // for logging
            logger = LogManager.getLogger("MyStoreProject");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

    public void launchApp() {

        //Loading and initializing the driver
        loadConfiguration();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        // Common setup
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Launch the application
        String url = props.getProperty("url");
        if (url == null) {
            throw new RuntimeException("URL is not specified in the config.properties file.");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt='company-branding']"))));
    }
}
