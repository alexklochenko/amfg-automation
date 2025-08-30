package amfgProject.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper
{

    /**
     * Wait methods for visibility Of Element Located
     */
    public static WebElement WaitVisibilityOfElementLocated (WebDriver driver, By loctor, int time)
    {
        return (new WebDriverWait(driver, Duration.ofSeconds(time))).until(ExpectedConditions.visibilityOfElementLocated(loctor));
    }


    /**
     * Wait methods for invisibility of Element presented on the page
     */
    public static boolean WaitForInvisibilityOfElementLocated2(WebDriver driver, By loctor, int time)
    {
        return (new WebDriverWait(driver, Duration.ofSeconds(time))).until(ExpectedConditions.invisibilityOfElementLocated(loctor));
    }


}
