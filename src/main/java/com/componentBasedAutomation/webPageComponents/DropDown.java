package com.componentBasedAutomation.webPageComponents;

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DropDown extends BaseComponent {

    private By dropDownOptionsBy;

    public DropDown(By dropDownBy, By dropDownOptionsBy) {
        this.mainLocator = dropDownBy;
        this.dropDownOptionsBy = dropDownOptionsBy;
    }

    /**
     * Select the option from the dropdown and wait for the next page component to load, if selection is successful
     * @param option - the option you want to select
     * @param component - the page component you want to wait for
     */
    public void selectOption(String option, BaseComponent component) {
        click(this.mainLocator, this.dropDownOptionsBy);
        WebElement selectedOptionElement = Element.getWebElements(this.dropDownOptionsBy).stream().filter(webElement -> webElement.getText().equalsIgnoreCase(option)).findFirst().get();
        Element.click(selectedOptionElement, component);
    }

    /**
     * Method to select a option from the dropdown without waiting for resulting component
     * @param option - the option you want to select
     */
    public void selectOption(String option) {
        click(this.mainLocator, this.dropDownOptionsBy);
        WebElement selectedOptionElement = Element.getWebElements(this.dropDownOptionsBy).stream().filter(webElement -> webElement.getText().equalsIgnoreCase(option)).findFirst().get();
        Element.click(selectedOptionElement);
    }

    private void click(By mainLocator,By dropDownOptionsBy) {
        Element.click(mainLocator);
        By main = mainLocator;
        this.mainLocator = dropDownOptionsBy;
        Element.waitForElementVisible(this);
        this.mainLocator = main;
    }
}
