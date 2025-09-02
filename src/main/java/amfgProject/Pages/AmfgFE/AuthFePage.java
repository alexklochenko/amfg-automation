package amfgProject.Pages.AmfgFE;

import amfgProject.Common.UserActions;
import amfgProject.Common.WaitHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     *  Locator list
     */
    By signInButton= By.cssSelector("div.rp-sign-in");
    By signInPopUp= By.cssSelector("div.k-widget.k-window.k-dialog");
    By signInPopUpEmailInput= By.cssSelector("input[name='email']");
    By signInPopUpPasswordInput= By.cssSelector("input[name='password']");
    By signInButtonOnPopUp= By.cssSelector("div.rp-form-inline-items-wrapper>button:nth-of-type(2)");
    By createAccountButton= By.cssSelector("div.rp-sign-in-suggestion>button");
    By forgottenYourPasswordButton= By.cssSelector("div.rp-form-inline-items-wrapper>button:nth-of-type(1)");
    By signInButtonAfterSignIn= By.cssSelector("span.rp-link.rp-navigation-link.rp-navigation-link--without-line.rp-navigation-link--small>span");



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



    public void userSignInWithValidPassAndEmail ()
    {
        if(UserActions.checkUserIsSignOut(driver, signInButton, 10))
        {
            UserSignInFe(FE_SIGN_IN_NOT_VALID_EMAIL, FE_SIGN_IN_NOT_VALID_PASSWORD);
        }
        Assertions.assertTrue(isElementVisible(driver,createAccountButton,5), "");
        Assertions.assertTrue(isElementVisible(driver,forgottenYourPasswordButton,5), "");

        WaitHelper.waitVisibilityOfElementLocated(driver,signInButtonOnPopUp, 2 ).click();
        Assertions.assertEquals(FE_SIGN_IN_USER_NAME, getTextFromElement(driver, signInButtonAfterSignIn));

    }





}
