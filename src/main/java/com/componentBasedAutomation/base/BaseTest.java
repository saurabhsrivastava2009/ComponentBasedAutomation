package com.componentBasedAutomation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    private String browser = System.getProperty("browser");
    private WebDriver driver = BasicDriver.getDriver(browser);

    /**
     * Method to get the current web driver instance
     *
     * @return web driver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    public void navigateToPage(String url, By destinationPageLoadable){
        driver.get(url);
        Element.waitForElementVisible(destinationPageLoadable);
    }

    /**
     * Method to quit the driver and close session once the test execution is completed on suite level
     */
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
