package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utility.Hooks.getDriver;


public class TransferAccount {
    String username;
    String password;

    @Given("user has given credentials")
    public void user_has_given_credentials() {
        username = "Demo-User";
        password = "Demo-Access1";

    }
    @When("user transfers money between accounts")
    public void user_transfers_money_between_accounts() throws InterruptedException {
        //getDriver().manage().window().maximize();
        getDriver().get("https://demo.ebanq.com/log-in");
        getDriver().findElement(By.cssSelector(".fields-container [type=\"email\"]")).sendKeys(username);
        getDriver().findElement(By.cssSelector(".fields-container [type=\"password\"]")).sendKeys(password);
        getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();
        getDriver().findElement(By.cssSelector("div[ng-reflect-router-link='/transfer']")).click();
        getDriver().findElement(By.cssSelector("div[ng-reflect-router-link='/transfer']")).click();
        getDriver().findElement(By.cssSelector(".section:nth-child(1) .section__heading")).click();
        getDriver().findElement(By.cssSelector(".account-select:nth-child(1) [role=\"listbox\"]")).click();
        getDriver().findElement(By.cssSelector(".ng-option:nth-child(1)")).click();
        getDriver().findElement(By.cssSelector(".account-select:nth-child(2) [role=\"listbox\"]")).click();
        getDriver().findElement(By.cssSelector(".ng-option:nth-child(2)")).click();
        getDriver().findElement(By.cssSelector(".two-in-row .native-input ")).sendKeys("100");
        getDriver().findElement(By.cssSelector(".native-text-area")).sendKeys("Happy Birthday");
        Thread.sleep(2000);
        getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();


    }
    @Then("User sees success transfer message")
    public void user_sees_success_transfer_message() {
        String expected = " Your request has been sent for approval. ".trim();
        String actual = getDriver().findElement(By.cssSelector(".success-popup .popup-message")).getText();
        System.out.println(actual);

        assertTrue(actual.contains(expected));
    }
    @When("user logs out")
    public void user_logs_out() {
        getDriver().findElement(By.cssSelector(".controls .controls__logout")).click();
    }
    @Then("user is back to home page")
    public void user_is_back_to_home_page() {
        String expected1 = "EBANQ".trim();
        String actual1 = getDriver().getTitle();
        assertEquals(actual1, expected1);
    }

}
