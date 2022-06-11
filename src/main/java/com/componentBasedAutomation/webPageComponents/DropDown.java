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

    public void selectOption(String option, By expectedBy) {
        Element.click(this.mainLocator, this.dropDownOptionsBy);
        WebElement selectedOptionElement = Element.getWebElements(this.dropDownOptionsBy).stream().filter(webElement -> webElement.getText().equalsIgnoreCase(option)).findFirst().get();
        Element.click(selectedOptionElement, expectedBy);
    }

    public void selectOption(String option) {
        Element.click(this.mainLocator, this.dropDownOptionsBy);
        WebElement selectedOptionElement = Element.getWebElements(this.dropDownOptionsBy).stream().filter(webElement -> webElement.getText().equalsIgnoreCase(option)).findFirst().get();
        Element.click(selectedOptionElement);
    }

}
