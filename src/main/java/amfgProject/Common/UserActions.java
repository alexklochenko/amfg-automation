package amfgProject.Common;

import amfgProject.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserActions
{

    private static final Logger logger = LoggerFactory.getLogger(UserActions.class);

    /**
     * Check user sign in
     */
    public static boolean checkUserIsSignOut(WebDriver driver, By locator, int time) {
        try {
            WaitHelper.waitVisibilityOfElementLocated(driver, locator, time);
            return true;
        } catch (TimeoutException e) {
            logger.error("Sign in button is not present on the page");
            return false;
        }
    }

}
