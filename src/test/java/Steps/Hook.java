package Steps;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    /* Dependency injection */

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initailazedTest() {

        /* Implementation of the Firefox webdriver */

        System.setProperty("webdriver.gecko.driver", "src/geckodriver-v0.23.0-win64/geckodriver.exe");
        base.driver = new FirefoxDriver();
        base.driver.manage().window().maximize();

        /* Implementation of the global wait */

        base.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @After
    public void tearDownTest() {

        base.driver.close();

    }

}
