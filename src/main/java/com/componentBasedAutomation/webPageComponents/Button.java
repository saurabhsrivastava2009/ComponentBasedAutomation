package com.componentBasedAutomation.webPageComponents;

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseComponent {

    public Button(By buttonBy) {
        this.mainLocator = buttonBy;
    }

    /**
     * Method to click the button and then wait for destination By to load
     *
     * @param component - the page component you expect to load if the click is successful
     */
    public WebElement click(BaseComponent component) {
        return Element.click(this.mainLocator, component);
    }

}
