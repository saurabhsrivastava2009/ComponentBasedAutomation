package com.componentBasedAutomation.webPageComponents;

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseComponent{

    private By buttonBy;
    private By destinationBy;

    public Button(By buttonBy) {
       // this.buttonBy = buttonBy;
        this.mainLocator = buttonBy;
    }

    /**
     * Method to click the button and then wait for destination By to load
     * @param destinationBy
     */
    public WebElement click(By destinationBy){
        return Element.click(this.mainLocator,destinationBy);
    }

}
