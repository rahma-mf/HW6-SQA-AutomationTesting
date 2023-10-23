package StepDef;

import config.environment_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends environment_target {
    @Given("^User is on login page$")
    public void userIsOnLoginPage() {
        //Set driver location Path
        System.setProperty("webdriver.chrome.driver","src/main/resources/FirefoxSetup118.0.2x64.exe");
        driver = new FirefoxDriver();
        //Maximize driver
        driver.manage().window().maximize();
        //Set URL
        driver.get(BaseUrl);

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );
    }

    @When("^User enter the valid credentials$")
    public void userEnterTheValidCredentials() {
        driver.findElement(By.name("user-name")).sendKeys("visual_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("^User click login button$")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^User verify login result$")
    public void userVerifyLoginResult() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
        );
        driver.quit();
    }

    @When("^User enter the invalid credentials$")
    public void userEnterTheInvalidCredentials() {
        driver.findElement(By.name("user-name")).sendKeys("visual_usera");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("error-button"))
        );
        driver.quit();
    }
}
