package StepDef;

import config.environment_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class filterProduct extends environment_target {
    @Given("User on the product list page")
    public void userOnTheProductListPage() {
        //Set driver location Path
        System.setProperty("webdriver.chrome.driver","src/main/resources/FirefoxSetup118.0.2x64.exe");
        driver = new FirefoxDriver();
        //Maximize driver
        driver.manage().window().maximize();
        //Set URL
        driver.get(BaseUrl);
        driver.findElement(By.name("user-name")).sendKeys("visual_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //Set driver location Path

        //Set URL
        driver.get(ProductListPageUrl);
    }

    @When("User filter products by name \\(Z to A)")
    public void userFilterProductsByNameZToA() {
        driver.findElement(By.cssSelector(".product_sort_container")).click();
        driver.findElement(By.cssSelector(".product_sort_container > option:nth-child(2)")).click();
    }

    @Then("User should see product list by name \\(Z to A)")
    public void userShouldSeeProductListByNameZToA() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#item_3_title_link > div:nth-child(1)"))
        );
        driver.quit();
    }
}
