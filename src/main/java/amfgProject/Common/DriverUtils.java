package amfgProject.Common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static amfgProject.Common.Config.DRIVER_INDEX;

public class DriverUtils
{
    private static final Logger logger = LoggerFactory.getLogger(DriverUtils.class);

    /**
     * Creates a new instance of WebDriver based on the configured browser type.
     * The browser type is determined by the value of DRIVER_INDEX
     * If an unsupported driver type is specified, an UnsupportedOperationException is thrown.
     */
    public static WebDriver createDriver ()
        {
            WebDriver driver=null;

            switch (DRIVER_INDEX)
            {
                case 1:
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver=new ChromeDriver();
                    break;

                case 2:
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    driver=new FirefoxDriver();
                    break;

                default:
                    logger.info("Unsupported driver type");
                    throw new UnsupportedOperationException("Unsupported driver type");

            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
            driver.manage().window().setSize(new Dimension(1980,980));

            return driver;
        }



}
