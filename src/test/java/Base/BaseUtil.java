package Base;

import org.openqa.selenium.WebDriver;

public class BaseUtil {

    /* Webdriver implementation */

    public WebDriver driver;

    /* URL implementation */

    private static final String FRENCHMAINPAGE = "https://www.smartbox.com/fr/";

    /* Getters */

    protected static String FRENCHMAINPAGE() {
        return FRENCHMAINPAGE;
    }
}
