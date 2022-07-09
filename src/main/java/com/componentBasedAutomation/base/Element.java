package com.componentBasedAutomation.base;

import com.componentBasedAutomation.webPageComponents.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface Element {

    String browser = System.getProperty("browser");
    WebDriver driver = BasicDriver.getDriver(browser);
    String propertyTimeOut = Optional.ofNullable(System.getProperty("timeout")).isPresent() ? System.getProperty("timeout") : "20";

    /**
     * Method to Wait for element (for 20 seconds) to be visible
     *
     * @param component - the component of the page that you want to wait for
     * @return the web element for the loadable
     */
    static WebElement waitForElementVisible(BaseComponent component) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        return wait.until(webDriver -> webDriver.findElement(component.getMainLocator()));
    }

    /**
     * Method to Wait for element to be visible based on your custom timeout
     *
     * @param component - the component of the page that you want to wait for
     * @param timeOutInSeconds - your own custom timeout
     * @return the web element for the loadable
     */
    static WebElement waitForElementVisible(BaseComponent component, int timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds)
                .until(
                        ExpectedConditions.visibilityOfElementLocated(component.getMainLocator())
                );
        return getWebElement(component.getMainLocator());
    }

    /**
     * Method to Wait for element to be visible based on the timeout provided at the run time
     *
     * @param component - the component of the page that you want to wait for
     * @param usePropertyTimeOut - your own custom timeout provided at the run time
     * @return the web element for the loadable
     */
    static WebElement waitForElementVisible(BaseComponent component, boolean usePropertyTimeOut) {
        if (usePropertyTimeOut) {
            new WebDriverWait(driver, Integer.valueOf(propertyTimeOut))
                    .until(
                            ExpectedConditions.visibilityOfElementLocated(component.getMainLocator())
                    );
        }
        return waitForElementVisible(component);
    }

    /**
     * Method to check if element is visible
     *
     * @param by - the locator whose visibility you want to check
     * @return - true if visible else false
     */
    static boolean isElementVisible(By by) {
        return getWebElement(by).isDisplayed();
    }

    /**
     * Method to just click
     *
     * @param clickableBy - the element you want to click
     */
    static void click(By clickableBy) {
        click(driver.findElement(clickableBy));
    }

    /**
     * Method to click and wait for next loadable
     *
     * @param clickableBy   - the element you want to click
     * @param component - the component you want to wait for if the click is successful
     * @return - the destination web element
     */
    static WebElement click(By clickableBy, BaseComponent component) {
        return click(driver.findElement(clickableBy), component);
    }

    /**
     * Method to just click based on web element
     *
     * @param element - the web element you want to click
     */
    static void click(WebElement element) {
        element.click();
    }

    /**
     * Method to click and wait for the destination or expected by to load
     *
     * @param element       - the element you want to click
     * @param component - the destination or expected component once click is successful
     * @return - the destination or expected web element
     */
    static WebElement click(WebElement element, BaseComponent component) {
        element.click();
        return waitForElementVisible(component);
    }

    /**
     * Method to find the value present for a by
     *
     * @param by - the by for which you want to get the value
     * @return - the value present for the specified by
     */
    static String getText(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * Method to enter text
     *
     * @param by    - the by in which you want to enter the text
     * @param value - the value you want to enter
     */
    static void enterText(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    /**
     * Method to get the attribute value for a by
     *
     * @param by        - the by for which you want the attribute value
     * @param attribute - the attribute in that by
     * @return - the value of the attribute
     */
    static String getAttributeValue(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }

    /**
     * Method to clear the text
     *
     * @param by - the by for which you want to clear the text
     */
    static void clearText(By by) {
        driver.findElement(by).clear();
    }

    /**
     * Method to get multiple elements
     *
     * @param by - the by which you know have multiple matches in the DOM
     * @return - list of web elements if multiple matches found. if no match found, it will return a empty list
     */
    static List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }

    /**
     * Selenium select to select a value by text in a drop-down
     *
     * @param by   - the by you want to click
     * @param text - the text you want to click from the dropdown
     */
    static void selectByText(By by, String text) {
        new Select(getWebElement(by)).selectByVisibleText(text);
    }

    /**
     * Selenium select to select a value by index in a drop-down
     *
     * @param by    - the by you want to click
     * @param index - the index of the text you want to click from the dropdown
     */
    static void selectByIndex(By by, int index) {
        new Select(getWebElement(by)).selectByIndex(index);
    }

    /**
     * Selenium select to select a value by attribute value in a drop-down
     *
     * @param by    - the by you want to click
     * @param value - the attribute value of the text you want to click from the dropdown
     */
    static void selectByValue(By by, String value) {
        new Select(getWebElement(by)).selectByValue(value);
    }

    /**
     * Selenium de-select to select a value by text in a drop-down
     *
     * @param by   - the by you want to click
     * @param text - the text you want to click from the dropdown
     */
    static void deSelectByText(By by, String text) {
        new Select(getWebElement(by)).deselectByVisibleText(text);
    }

    /**
     * Selenium de-select to select a value by index in a drop-down
     *
     * @param by    - the by you want to click
     * @param index - the text you want to click from the dropdown
     */
    static void deSelectByIndex(By by, int index) {
        new Select(getWebElement(by)).deselectByIndex(index);
    }

    /**
     * Selenium de-select to select a value by index in a drop-down
     *
     * @param by    - the by you want to click
     * @param value - the attribute value of the text you want to click from the dropdown
     */
    static void deSelectByValue(By by, String value) {
        new Select(getWebElement(by)).deselectByValue(value);
    }

    /**
     * Method to check if multiple select option is available
     *
     * @param by - the by of the dropdown
     * @return - true if available else false
     */
    static boolean isMultipleSelectAvailable(By by) {
        return new Select(getWebElement(by)).isMultiple();
    }

    /**
     * Method to deselect all the selected options
     *
     * @param by - the by of the dropdown
     */
    static void deSelectAll(By by) {
        new Select(getWebElement(by)).deselectAll();
    }

    /**
     * Method to get the web element for the by
     *
     * @param by - the by for which you want the web element
     * @return - web element for that by
     */
    static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    /**
     * Method to know if the required element is in the view port or not
     *
     * @param webElement - the web element for which you want this check
     * @return - true if present else false
     */
    static boolean isElementInViewPort(WebElement webElement) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , webElement);
    }

    static void scroll(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }
}
