package amfgProject.Common;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static amfgProject.Common.Config.DRIVER_INDEX;
import static amfgProject.Common.Config.IS_HEADLESS;

public class DriverUtils
{
    private static final Logger logger = LoggerFactory.getLogger(DriverUtils.class);



    /**
     * Check headless
     */
    private static void isHeadless()
    {

    }
    /**
     * Creates a new instance of WebDriver based on the configured browser type.
     * The browser type is determined by the value of DRIVER_INDEX
     * If an unsupported driver type is specified, an UnsupportedOperationException is thrown.
     */
    public static @NotNull WebDriver createDriver ()
        {
            WebDriver driver=null;

            switch (DRIVER_INDEX)
            {
                case 1:
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    ChromeOptions options=new ChromeOptions();
                    if(IS_HEADLESS)
                    {
                        options.addArguments("--headless");
                    }
                    driver=new ChromeDriver(options);
                    break;

                case 2:
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if(IS_HEADLESS)
                    {
                        firefoxOptions.addArguments("--headless");
                    }
                    driver=new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    logger.info("Unsupported driver type");
                    throw new UnsupportedOperationException("Unsupported driver type");

            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().setSize(new Dimension(1500,980));

            return driver;
        }


        public static void clearAllCookies (WebDriver driver)
        {
            driver.manage().deleteAllCookies();
        }


        public static void clearLocalAndSessionStorage (WebDriver driver)
        {
            JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
            javascriptExecutor.executeScript("window.localStorage.clear()");

        }




}
