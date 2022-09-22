package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
    public String homeURL = "https://demo.ebanq.com/log-in";
    @FindBy(css="[href=\"/sign-up\"]")
    public WebElement signUpButton;
    @FindBy(css="#first-n-input")
    public WebElement firstNameInput;
    @FindBy(css="#last-name-input")
    public WebElement lastNameInput;
    @FindBy(css="#username")
    public WebElement usernameInput;
    @FindBy(css="#em")
    public WebElement emailInput;
    @FindBy(css="#confirm-em")
    public WebElement confirmEmailInput;
    @FindBy(css="#no-autocomplete")
    public WebElement passwordInput;
    @FindBy(css="#confirm-ps")
    public WebElement confirmPasswordInput;
    @FindBy(css="#securityQuestionId")
    public WebElement securityQuestion;
    @FindBy(css=".ng-option:nth-child(3)")
    public WebElement option3SecQues;
    @FindBy(css="#securityQuestionAnswer")
    public WebElement securityQuestionAnswerInput;
    @FindBy(css=".checkbox-checkmark")
    public WebElement checkbox;
    @FindBy(css=".controls__submit:last-child")
    public WebElement submitSignUpButton;
    @FindBy(css=".success-popup .popup-message")
    public WebElement signUpComplate;
    @FindBy(css=".fields-container #corporate-account")
    public WebElement profileType;
    @FindBy(css=".ng-option:nth-child(2)")
    public WebElement corporate;
    @FindBy(css="#company-n-corp")
    public WebElement companyName;
    @FindBy(css=".fields-container__row:nth-child(3) .input-field .error-word")
    public WebElement errorMessageLoct;

    public String successMessage=" A welcome message with further instructions has been sent to your e-mail address.";
    public String errorMessage= "Field is required.";
}
