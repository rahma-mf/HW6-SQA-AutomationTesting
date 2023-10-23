package StepDef;

import config.environment_target;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import ObjectRepository.productpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class successbuyproduct extends environment_target {
    @Test
    public void main() {

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
        // --------------------------------------------------------------------------
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        // --------------------------------------------------------------------------
        WebElement addtocart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addtocart.click();
        WebElement shoppingcart = driver.findElement(By.id("shopping_cart_container"));
        shoppingcart.click();
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        WebElement firstname = driver.findElement(By.id("first-name"));
        WebElement lastname = driver.findElement(By.id("last-name"));
        WebElement postalcode = driver.findElement(By.id("postal-code"));

        firstname.sendKeys("Alina");
        lastname.sendKeys("Suhita");
        postalcode.sendKeys("10420");

        WebElement btncontinue = driver.findElement(By.id("continue"));
        btncontinue.click();

        WebElement btnfinish = driver.findElement(By.id("finish"));
        btnfinish.click();
    }
}