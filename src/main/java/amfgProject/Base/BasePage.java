package amfgProject.Base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static amfgProject.Common.Config.MAIN_FE_URL;

public class BasePage
{
    WebDriver driver;

    public BasePage (WebDriver driver) {this.driver=driver;}

    public void getFeUrl ()
    {
        driver.get(MAIN_FE_URL);
    }





}
