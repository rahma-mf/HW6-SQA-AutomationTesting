package StepDef;

import ObjectRepository.productpage;
import config.environment_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class logout extends environment_target {

    productpage elementProduct = new productpage();
    @Given("user is on homepage")
    public void userIsOnHomepage() {
        //Set driver location Path
        System.setProperty("webdriver.chrome.driver", "src/main/resources/FirefoxSetup118.0.2x64.exe");
        driver = new FirefoxDriver();
        //Maximize driver
        driver.manage().window().maximize();
        //Set URL
        driver.get(BaseUrl);
        driver.findElement(By.name("user-name")).sendKeys("visual_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //Set URL
        driver.get(ProductListPageUrl);
    }
    @When("user click burger button")
    public void UserClickBurgerButton(){
        WebElement burgerbtn = driver.findElement(By.id("react-burger-menu-btn"));
        burgerbtn.click();
    }
    @Then("user logout was successful")
    public void UserLogoutWasSuccessful(){
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        logout.click();
        System.out.println("Successfully Logout");
    }


}
