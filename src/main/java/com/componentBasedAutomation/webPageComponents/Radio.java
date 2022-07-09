package com.componentBasedAutomation.webPageComponents;

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;

public class Radio extends BaseComponent{

    public Radio(By radioBy) {
        this.mainLocator = radioBy;
    }

    public void select(){
        Element.click(this.mainLocator);
    }
}
