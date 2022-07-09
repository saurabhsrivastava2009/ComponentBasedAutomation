package com.componentBasedAutomation.base;

/*
 * Copyright (c) 2022. Saurabh Srivastava
 */

import com.componentBasedAutomation.Utilities.CommonFrameworkLogger;
import com.componentBasedAutomation.webPageComponents.BaseComponent;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    private String browser = System.getProperty("browser");
    private WebDriver driver = BasicDriver.getDriver(browser);
    private static Logger LOGGER = new CommonFrameworkLogger(BaseTest.class).getLOGGER();

    /**
     * Method to get the current web driver instance
     *
     * @return web driver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Navigate to the specified URL
     *
     * @param url                     - the url to which you want to navigate to
     * @param expectedLoadableComponent - the component expected to load at the page
     */
    public void navigateToPage(String url, BaseComponent expectedLoadableComponent) {
        driver.get(url);
        Element.waitForElementVisible(expectedLoadableComponent);
    }

    /**
     * Method to print and log the asserted output
     *
     * @param actual   - the actual output on the page
     * @param expected - the expected output on the page
     * @param message  - the message you want to print accompanied w.r.t. assertion
     */
    public static void verify(Object actual, Object expected, String message) {
        final String format = String.format("Actual:%s, Expected:%s, Message:%s:%s", actual, expected, message, actual);
        System.out.println(format);
        LOGGER.info(format);
        Assert.assertEquals(actual, expected);
    }

    /**
     * Method to get the page title
     *
     * @return - page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Method to quit the driver and close session once the test execution is completed on suite level
     */
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}