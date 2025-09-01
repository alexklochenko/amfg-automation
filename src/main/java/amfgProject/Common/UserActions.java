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
    public static boolean checkUserIsSignIn(WebDriver driver, By locator, int time)
    {
        try
        {
            if(WaitHelper.waitForTextAtElement(driver, locator, time, "SIGN IN"))
            {
                return true;
            }
            else
            {
                logger.info("User is not sign in");
                return false;
            }
        }
        catch (TimeoutException e)
        {
            logger.error("Sine in button out of page");
            throw new TimeoutException("Sine in button out of page");

        }


    }



}
