package StepDef;
import config.environment_target;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks extends environment_target {

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/FirefoxSetup118.0.2x64.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl);
    }

    @After
    public void after() {
        driver.quit();
    }
}
