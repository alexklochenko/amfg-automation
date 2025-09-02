package amfgProject.Pages.AmfgFeTest.AuthTest.positive;

import amfgProject.Base.BaseTest;
import org.junit.jupiter.api.Test;

public class AuthFeTest  extends BaseTest
{

    @Test
    public void check_AMFG_4696_Step_1()
    {
        basePage.getFeUrl();
        authFePage.checkheaderTabs ();
    }

    @Test
    public void check_AMFG_4696_Step_2()
    {
        basePage.getFeUrl();
        authFePage.checkSignInPopup ();
    }

    @Test
    public void check_AMFG_4696_Step_3()
    {
        basePage.getFeUrl();
        authFePage.userSignInWithValidEmailAndInvalidPassword();
    }

    @Test
    public void check_AMFG_4696_Step_4()
    {
        basePage.getFeUrl();
        authFePage.userSignInWithInvalidEmailAndValidPassword();
    }

    @Test
    public void check_AMFG_4696_Step_5()
    {
        basePage.getFeUrl();
        authFePage.userSignInWithInvalidEmailAndInvalidPassword();
    }

    @Test
    public void check_AMFG_4696_Step_6()
    {
        basePage.getFeUrl();
        authFePage.userSignInWithValidEmailAndPass();
    }




}
