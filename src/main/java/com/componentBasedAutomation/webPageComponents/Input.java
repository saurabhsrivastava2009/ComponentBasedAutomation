package com.componentBasedAutomation.webPageComponents;

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;

public class Input extends BaseComponent {

    public Input(By inputBy) {
        //this.inputBy = inputBy;
        this.mainLocator = inputBy;
    }

    public void enterText(String value) {
        Element.enterText(this.mainLocator, value);
    }

    public String getText() {
        return Element.getText(this.mainLocator);
    }
}
