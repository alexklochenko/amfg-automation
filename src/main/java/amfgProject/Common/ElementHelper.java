package amfgProject.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper
{

    /**
     *Check element visibility on the page
     */
    public static boolean isElementVisible(WebDriver driver, By locator, int time)
    {
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e)
        {
            return false;
        }
    }

    /**
     * Send key to input field
     */
    public static void sendKeysToInputField (WebDriver driver, By locator, String inputValue)
    {
        WebElement element=driver.findElement(locator);
        element.clear();
        element.sendKeys(inputValue);
    }

    /**
     * Get text from element
     */

    public static String getTextFromElement (WebDriver driver, By locator)
    {
        WebElement element =driver.findElement(locator);
        return element.getText();
    }



}

