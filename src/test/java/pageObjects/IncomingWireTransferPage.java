package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Hooks;

public class IncomingWireTransferPage {

    WebDriver getDriver = Hooks.getDriver();

    public String validUsername = "Demo-User";
    public String validPassword = "Demo-Access1";

    public String URL = "https://demo.ebanq.com/log-in";
    public void load() {
        getDriver.get(URL);
    }
    @FindBy(xpath = "//input[@placeholder='Enter username or email address']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public WebElement passwordInput;

    @FindBy(css = "div[ng-reflect-router-link='/transfer']")
    public WebElement transfers;

    @FindBy(css = "div[ng-reflect-router-link='incoming-wire-transfer']")
    public WebElement incomingWireTransfer;

    @FindBy(css = ".select-container-large .ng-select-container")
    public WebElement selectAccount;

    @FindBy(css = ".ng-option-marked")
    public WebElement selectChecking;

    @FindBy(css = ".bottom .main_color")
    public WebElement continueButton;

    @FindBy(css = ".line")
    public WebElement beneficiaryBankDetails;

    public String bankDetails = "Beneficiary Bank Details";

}
