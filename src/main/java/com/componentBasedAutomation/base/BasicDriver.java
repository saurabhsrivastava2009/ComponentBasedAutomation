package com.componentBasedAutomation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class BasicDriver {

    private static WebDriver driver = null;

    private BasicDriver(){
    }

    protected static WebDriver getDriver(String browser){
        if(driver==null) {
            driver = getBrowserDriver(browser);
        }
        return driver;
    }

    private static WebDriver getBrowserDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("IE")){
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }
        throw new RuntimeException("Browser Driver not found");
    }


    @AfterClass
    protected void tearDown(){
        driver.quit();
    }
}
