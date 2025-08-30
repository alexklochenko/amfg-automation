package Base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest
{

    WebDriver driver=CommonActions.createDriver();
    Actions action=new Actions(driver);
    Select select;



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

