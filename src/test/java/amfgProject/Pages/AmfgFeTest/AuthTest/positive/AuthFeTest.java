package amfgProject.Pages.AmfgFeTest.AuthTest.positive;

import amfgProject.Base.BaseTest;
import org.junit.jupiter.api.Test;

public class AuthFeTest  extends BaseTest
{
    @Test
    public void checkAMFG_4696_Step_6()
    {
        basePage.getFeUrl();
        authFePage.userSignInWithValidPassAndEmail();
    }
}
