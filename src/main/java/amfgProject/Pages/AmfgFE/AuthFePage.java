package amfgProject.Pages.AmfgFE;

import amfgProject.Common.UserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AuthFePage
{


    WebDriver driver;
    public AuthFePage (WebDriver driver)
    {
        this.driver=driver;
    }


    By signInButton= By.cssSelector("div.rp-sign-in-button");

    public void userSignIn ()
    {
        if(!UserActions.checkUserIsSignIn(driver, signInButton, 10))
        {

        }

    }





}
