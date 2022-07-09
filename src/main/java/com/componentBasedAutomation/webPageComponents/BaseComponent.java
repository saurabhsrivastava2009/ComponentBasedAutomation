package com.componentBasedAutomation.webPageComponents;

import com.componentBasedAutomation.Utilities.CommonFrameworkLogger;
import com.componentBasedAutomation.base.Element;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public abstract class BaseComponent implements Element {

    protected static Logger LOGGER = new CommonFrameworkLogger(BaseComponent.class).getLOGGER();

    protected By mainLocator;

    /**
     * Method to click a locator
     */
    public void click() {
        Element.click(this.mainLocator);
    }

    /**
     * Method to get the main locator
     * @return {@link #mainLocator}
     */
    public By getMainLocator(){
        return this.mainLocator;
    }

    /**
     * Method to check if the main locator is visible or not
     * @return true if visible otherwise false
     */
    public boolean isVisible(){
        return Element.isElementVisible(this.mainLocator);
    }
}
