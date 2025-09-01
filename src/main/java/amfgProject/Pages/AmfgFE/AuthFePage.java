package amfgProject.Pages.AmfgFE;

import amfgProject.Common.UserActions;
import amfgProject.Common.WaitHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static amfgProject.Common.ElementHelper.isElementVisible;
import static amfgProject.Common.ElementHelper.sendKeysToInputField;
import static amfgProject.Common.TestData.FE_SIGN_IN_VALID_EMAIL;
import static amfgProject.Common.TestData.FE_SIGN_IN_VALID_PASSWORD;


public class AuthFePage
{
    WebDriver driver;
    public AuthFePage (WebDriver driver)
    {
        this.driver=driver;
    }

    /**
     *  Locator list
     */
    By signInButton= By.cssSelector("div.rp-sign-in-button");
    By signInPopUp= By.cssSelector("div.k-widget.k-window.k-dialog");
    By signInPopUpEmailInput= By.cssSelector("input[name='email']");
    By signInPopUpPassInput= By.cssSelector("input[name='password']");
    By createAnAccountButton= By.cssSelector("");
    By forgottenYourPasswordButton= By.cssSelector("");



    public void userSignInWithValidPassAndEmail ()
    {
        Assertions.assertTrue(isElementVisible(driver,createAnAccountButton,5), "");
        Assertions.assertTrue(isElementVisible(driver,forgottenYourPasswordButton,5), "");

        if(!UserActions.checkUserIsSignIn(driver, signInButton, 10))
        {
            WaitHelper.waitVisibilityOfElementLocated(driver,signInButton, 2).click();
            WaitHelper.waitVisibilityOfElementLocated(driver,signInPopUp, 5 );
            sendKeysToInputField(driver, signInPopUpEmailInput, FE_SIGN_IN_VALID_EMAIL);
            sendKeysToInputField(driver, signInPopUpEmailInput, FE_SIGN_IN_VALID_PASSWORD);

        }

    }





}
