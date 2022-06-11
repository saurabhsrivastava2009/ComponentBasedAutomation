package com.componentBasedAutomation.webPageComponents;/*
 * Copyright (c) 2022. Saurabh Srivastava
 */

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;
import org.testng.Reporter;

import java.util.logging.Logger;

public class CheckBox extends BaseComponent{

    public CheckBox(By checkBoxBy) {
        //this.inputBy = inputBy;
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
            Reporter.log("INFO : Checkbox is already selected",true);
        }
    }

    public void deSelect(){
        if(isSelected()) {
            Element.click(this.mainLocator);
        }
        else {
            Reporter.log("INFO : Checkbox already not selected",true);
        }
    }
}
