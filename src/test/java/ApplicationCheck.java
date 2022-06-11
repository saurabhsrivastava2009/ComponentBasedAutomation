import com.componentBasedAutomation.base.BaseTest;
import com.componentBasedAutomation.base.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        WebDriver driver = getDriver();
        navigateToPage("https://www.google.com", By.cssSelector("[aria-label=\"Search\"]"));
        Assert.assertEquals(driver.getTitle().contains("Google"),true);
    }
}
