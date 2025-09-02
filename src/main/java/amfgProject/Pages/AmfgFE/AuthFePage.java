package amfgProject.Pages.AmfgFE;

import amfgProject.Common.ElementHelper;
import amfgProject.Common.UserActions;
import amfgProject.Common.WaitHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static amfgProject.Common.DriverUtils.clearAllCookies;
import static amfgProject.Common.DriverUtils.clearLocalAndSessionStorage;
import static amfgProject.Common.ElementHelper.*;
import static amfgProject.Common.TestData.*;


public class AuthFePage
{
    WebDriver driver;
    public AuthFePage (WebDriver driver)
    {
        this.driver=driver;
    }
    private static final Logger logger = LoggerFactory.getLogger(AuthFePage.class);

    /**
     *  Sign in locator list
     */
    By amfgIframe= By.cssSelector("iframe#amfg-iframe");
    By signInButton= By.cssSelector("div.rp-sign-in-button");
    By signInPopUp= By.cssSelector("div.k-widget.k-window.k-dialog");
    By signInPopUpEmailInput= By.cssSelector("input[name='email']");
    By signInPopUpPasswordInput= By.cssSelector("input[name='password']");
    By signInButtonOnPopUp= By.cssSelector("div.rp-form-inline-items-wrapper>button:nth-of-type(2)");
    By createAccountButton= By.cssSelector("div.rp-sign-in-suggestion>button");
    By forgottenYourPasswordButton= By.cssSelector("div.rp-form-inline-items-wrapper>button:nth-of-type(1)");
    By signInButtonAfterSignIn= By.cssSelector("span.rp-link.rp-navigation-link.rp-navigation-link--without-line.rp-navigation-link--small>span");

    /**
     * Error pop up locator list
     */
    By errorAlert= By.cssSelector("div.message");

    /**
     * Main FE page locator list
     */
    By DashboardButton= By.cssSelector("div.rp-navigation-container>span:nth-of-type(1)");
    By QuotesButton= By.cssSelector("div.rp-navigation-container>span:nth-of-type(2)");
    By ProjectsButton= By.cssSelector("div.rp-navigation-container>span:nth-of-type(3)");
    By InstantQuoteButton= By.cssSelector("div.rp-navigation-container>span:nth-of-type(4)");
    By CatalogueButton= By.cssSelector("div.rp-navigation-container>span:nth-of-type(5)");




    private void UserSignInFe (String Emain, String password)
    {
        try
        {
            WaitHelper.waitVisibilityOfElementLocated(driver,signInButton, 2).click();
            WaitHelper.waitVisibilityOfElementLocated(driver,signInPopUp, 5 );
            sendKeysToInputField(driver, signInPopUpEmailInput, Emain);
            sendKeysToInputField(driver, signInPopUpPasswordInput, password);
        }
        catch(TimeoutException e)
        {
            logger.error("Sign in popup is not present on the page");
            throw new TimeoutException("Sign in popup is not present on the page");
        }
    }

    public void checkheaderTabs ()
    {
        driver.switchTo().frame(driver.findElement(amfgIframe));
        Assertions.assertTrue(ElementHelper.isElementVisible(driver, DashboardButton, 2), "DashboardButton was not displayed");
        Assertions.assertTrue(ElementHelper.isElementVisible(driver, QuotesButton, 2), "QuotesButton was not displayed");
        Assertions.assertTrue(ElementHelper.isElementVisible(driver, ProjectsButton, 2), "ProjectsButton was not displayed");
        Assertions.assertTrue(ElementHelper.isElementVisible(driver, InstantQuoteButton, 2), "InstantQuoteButton was not displayed");
        Assertions.assertTrue(ElementHelper.isElementVisible(driver, CatalogueButton, 2), "CatalogueButton was not displayed");
    }

    public void checkSignInPopup ()
    {
        driver.switchTo().frame(driver.findElement(amfgIframe));
        WaitHelper.waitVisibilityOfElementLocated(driver,signInButton, 2).click();
        WaitHelper.waitVisibilityOfElementLocated(driver,signInPopUp, 5 );

        Assertions.assertTrue(isElementVisible(driver,createAccountButton,2),
                "The create account button is not present on the Sign In popup");
        logger.info("The create account button is  present on the Sign In popup");

        Assertions.assertTrue(isElementVisible(driver,forgottenYourPasswordButton,2),
                "The forgotten your password button is not present on the Sign In popup");
        logger.info("The forgotten your password button is present on the Sign In popup");

        Assertions.assertTrue(isElementVisible(driver,signInButtonOnPopUp,2),
                "The create account button is not present on the Sign In popup");
        logger.info("The create account button is  present on the Sign In popup");
    }



    public void userSignInWithValidEmailAndPass ()
    {
        clearAllCookies(driver);
        clearLocalAndSessionStorage(driver);
        if(UserActions.checkUserIsSignOut(driver, signInButton,amfgIframe, 10))
        {
            UserSignInFe(FE_SIGN_IN_VALID_EMAIL, FE_SIGN_IN_VALID_PASSWORD);
        }

        WaitHelper.waitVisibilityOfElementLocated(driver,signInButtonOnPopUp, 2 ).click();
        Assertions.assertEquals(FE_SIGN_IN_USER_NAME, getTextFromElement(driver, signInButtonAfterSignIn));

    }

    public void userSignInWithValidEmailAndInvalidPassword ()
    {
        if(UserActions.checkUserIsSignOut(driver, signInButton,amfgIframe, 10))
        {
            UserSignInFe(FE_SIGN_IN_VALID_EMAIL, FE_SIGN_IN_NOT_VALID_PASSWORD);
            WaitHelper.waitVisibilityOfElementLocated(driver,signInButtonOnPopUp, 2 ).click();
        }

        try
        {
            ElementHelper.isElementVisible(driver, errorAlert,2);
        }
        catch(TimeoutException e)
        {
            logger.error("Your email or password did not match any customers in our system, please try again or register as a new customer" +
                    " - was not displayed");
            throw new TimeoutException();
        }
    }



    public void userSignInWithInvalidEmailAndValidPassword () {
        if (UserActions.checkUserIsSignOut(driver, signInButton, amfgIframe, 10)) {
            UserSignInFe(FE_SIGN_IN_NOT_VALID_EMAIL, FE_SIGN_IN_VALID_PASSWORD);
            WaitHelper.waitVisibilityOfElementLocated(driver, signInButtonOnPopUp, 2).click();
        }

        try {
            ElementHelper.isElementVisible(driver, errorAlert, 2);
        } catch (TimeoutException e) {
            logger.error("Your email or password did not match any customers in our system, please try again or register as a new customer - was not displayed");
            throw new TimeoutException();
        }
    }



    public void userSignInWithInvalidEmailAndInvalidPassword () {
        if (UserActions.checkUserIsSignOut(driver, signInButton, amfgIframe, 10)) {
            UserSignInFe(FE_SIGN_IN_NOT_VALID_EMAIL, FE_SIGN_IN_NOT_VALID_PASSWORD);
            WaitHelper.waitVisibilityOfElementLocated(driver, signInButtonOnPopUp, 2).click();
        }

        try {
            ElementHelper.isElementVisible(driver, errorAlert, 2);
        } catch (TimeoutException e) {
            logger.error("Your email or password did not match any customers in our system, please try again or register as a new customer - was not displayed");
            throw new TimeoutException();
        }
    }




}
