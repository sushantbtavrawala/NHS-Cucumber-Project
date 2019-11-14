package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverInitiate;

public class Hooks extends DriverInitiate {

    @Before
    public void startup() {
        driver.manage().deleteAllCookies();
      //  driver.manage().window().fullscreen();
    }

    @After
    public void afterScenario() {
       // driver.quit();
    }
}