package com.componentBasedAutomation.webPageComponents;/*
 * Copyright (c) 2022. Saurabh Srivastava
 */

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;

public class Text extends BaseComponent{

    public Text(By inputBy) {
        this.mainLocator = inputBy;
    }

    public String getText() {
        return Element.getText(this.mainLocator);
    }
}
