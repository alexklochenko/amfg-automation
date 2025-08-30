package amfgProject.Base;

import amfgProject.Common.DriverUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static amfgProject.Common.Config.NEED_TO_CLOSE_BROWSER_AFTER_TEST;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest
{
    WebDriver driver= DriverUtils.createDriver();


    @AfterAll
    public void closeBrowser()
    {
        if (NEED_TO_CLOSE_BROWSER_AFTER_TEST)
        {
            driver.close();
            driver.quit();
        }
    }


}

