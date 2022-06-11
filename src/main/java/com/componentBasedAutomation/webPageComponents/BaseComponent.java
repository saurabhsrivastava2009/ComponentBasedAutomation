package com.componentBasedAutomation.webPageComponents;

import com.componentBasedAutomation.base.Element;
import org.openqa.selenium.By;

public abstract class BaseComponent implements Element {

     protected By mainLocator;

     /**
      * Method to click a locator
      */
     public void click(){
          Element.click(this.mainLocator);
     }
}
