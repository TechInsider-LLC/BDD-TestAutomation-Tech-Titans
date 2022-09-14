package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.IncomingWireTransferPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

import static utility.Hooks.getDriver;

public class IncomingWireTransfer {

    IncomingWireTransferPage transfer = PageFactory.initElements(getDriver(), IncomingWireTransferPage.class);

    String username;
    String password;

    @Given("User on Ebanq page")
    public void user_on_ebanq_page() {
        username = transfer.validUsername;
        password = transfer.validPassword;

    }
    @When("User Logs in and click on transfers then click on Incoming wire transfer")
    public void user_logs_in_and_click_on_transfers_then_click_on_incoming_wire_transfer() throws InterruptedException {
        transfer.load();
        transfer.usernameInput.sendKeys(transfer.validUsername);
        transfer.passwordInput.sendKeys(transfer.validPassword,Keys.ENTER);
        Thread.sleep(4000);
        transfer.transfers.click();
        transfer.incomingWireTransfer.click();

    }
    @When("User Select account and click on continue button")
    public void user_select_account_and_click_on_continue_button() throws InterruptedException {
        transfer.selectAccount.click();
        transfer.selectChecking.click();
        Thread.sleep(2000);
        transfer.continueButton.click();
    }
    @Then("User sees bank details")
    public void user_sees_bank_details() {
        String expected  = transfer.bankDetails;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(transfer.beneficiaryBankDetails,expected));
        String actual = transfer.beneficiaryBankDetails.getText().trim();
        assertEquals(expected,actual);
    }
}
