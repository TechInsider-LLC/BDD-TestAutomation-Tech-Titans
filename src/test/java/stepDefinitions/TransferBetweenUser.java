package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TransferBetweenUser {
    WebDriver driver;
    @Given("User successfully log in")
    public void user_successfully_log_in() throws InterruptedException {
        driver.get("https://demo.ebanq.com/log-in");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".fields-container [type=\"email\"]")).sendKeys("Demo-User");
        driver.findElement(By.cssSelector(".fields-container [type=\"password\"]")).sendKeys("Demo-Access1", Keys.ENTER);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("div[ng-reflect-router-link='/transfer']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div[ng-reflect-router-link=\"transfer-between-users\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div[class=\"ng-value-container\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("DIV[class=\"ng-option ng-option-marked\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#username")).sendKeys("jsmith");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#account")).sendKeys("EBQ22123487654");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).sendKeys("1");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).submit();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).submit();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".popup-message [href=\"/transfer\"]")).getText().trim();





    }
    @When("User click on TransferBetweenUser")
    public void user_click_on_transfer_between_user() throws InterruptedException {
        driver.findElement(By.cssSelector("div[ng-reflect-router-link='/transfer']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div[ng-reflect-router-link=\"transfer-between-users\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @When("User fill out the form and confirm")
    public void user_fill_out_the_form_and_confirm() throws InterruptedException {
        driver.findElement(By.cssSelector("div[class=\"ng-value-container\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("DIV[class=\"ng-option ng-option-marked\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#username")).sendKeys("jsmith");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#account")).sendKeys("EBQ22123487654");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).sendKeys("1");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[ng-reflect-name=\"outgoingAmount\"]")).submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Then("User get verify message")
    public void user_get_verify_message() {
        driver.findElement(By.cssSelector(".popup-message [href=\"/transfer\"]")).getText();

    }
}
