package amfgProject.Base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static amfgProject.Common.Config.*;

public class BasePage
{
    WebDriver driver;

    public BasePage (WebDriver driver) {this.driver=driver;}

    public void getFeUrl ()
    {
        driver.get(MAIN_FE_URL);
    }

    public void getMcUrl ()
    {
        driver.get(MAIN_MC_URL);
    }

    public void getACUrl ()
    {
        driver.get(MAIN_AC_URL);
    }







}
