package UITests;

/*
 * Copyright (c) 2022. Saurabh Srivastava
 */

import com.componentBasedAutomation.base.BaseTest;
import com.componentBasedAutomation.webPageComponents.Input;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplicationCheck extends BaseTest {

    @Test
    public void test(){
        System.out.println("Testing code!!");
        Assert.assertEquals(true,true);
    }

    @Test
    public void testEdgeDriver(){
        navigateToPage("https://www.google.com", new Input(By.cssSelector("[aria-label=\"Search\"]")));
        verify(getPageTitle().contains("Google"),true,"Page title verified");
    }
}
