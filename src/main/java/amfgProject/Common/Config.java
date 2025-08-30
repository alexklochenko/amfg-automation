package amfgProject.Common;

public class Config
{
    /**
     *Type of driver
     *     CHROME_DRIVER=1;
     *     MOZILLA_DRIVER=2;
     */
    protected static final int DRIVER_INDEX=1;

    /**
     *Environments URL
     */
    public static final String MAIN_FE_URL="https://demo.amfg.ai/new/stage/nataliiaakoieva.html";
    public static final String MAIN_MC_URL=null;
    public static final String MAIN_AC_URL=null;

    /**
     * Need to close browser after test end
     */
    public static final boolean NEED_TO_CLOSE_BROWSER_AFTER_TEST=false;


}
