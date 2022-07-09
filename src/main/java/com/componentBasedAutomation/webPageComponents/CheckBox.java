package com.componentBasedAutomation.webPageComponents;/*
 * Copyright (c) 2022. Saurabh Srivastava
 */

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;

public class CheckBox extends BaseComponent{

    public CheckBox(By checkBoxBy) {
        this.mainLocator = checkBoxBy;
    }

    public boolean isSelected(){
        return Element.getWebElement(this.mainLocator).isSelected();
    }

    public void select(){
        if(!isSelected()) {
            Element.click(this.mainLocator);
        }
        else {
            LOGGER.info("Checkbox is already selected");
        }
    }

    public void deSelect(){
        if(isSelected()) {
            Element.click(this.mainLocator);
        }
        else {
            LOGGER.info("Checkbox already not selected");
        }
    }
}
