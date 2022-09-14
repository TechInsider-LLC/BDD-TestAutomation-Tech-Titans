package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.SignUpPage;
import utility.RandomText;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignUp {

    WebDriver driver = new ChromeDriver();
    SignUpPage signup= PageFactory.initElements(driver,SignUpPage.class);
    RandomText random = new RandomText();
    String email = random.getRandomGmail(8);
    StringBuilder name= random.getRandomText(8);
    String password;

    @Given("Customer go to EBANQ homepage")
    public void customer_go_to_ebanq_homepage() {
        password= "Demoebanq1$";
        driver.get(signup.homeURL);
    }
    @When("Customer enter all the requirements")
    public void customer_enter_all_the_requirements() throws InterruptedException {

        Thread.sleep(2000);
        signup.signUpButton.click();
        signup.firstNameInput.sendKeys(name);
        signup.lastNameInput.sendKeys(name);
        signup.usernameInput.sendKeys(name);
        signup.emailInput.sendKeys(email);
        signup.confirmEmailInput.sendKeys(email);
        signup.passwordInput.sendKeys(password);
        signup.confirmPasswordInput.sendKeys(password);
        signup.securityQuestion.click();
        Thread.sleep(2000);
        signup.option3SecQues.click();
        signup.securityQuestionAnswerInput.sendKeys(name);
        signup.checkbox.click();
        signup.submitSignUpButton.click();


    }
    @Then("Customer see success message")
    public void customer_see_success_message() throws InterruptedException {
        String expected = signup.successMessage.trim();
        Thread.sleep(2000);
        String actual = signup.signUpComplate.getText().trim();
        assertTrue(actual.contains(expected));

    }

    @Given("User go to EBANQ page")
    public void user_go_to_ebanq_page() {
        password= "Demoebanq1$";
        driver.get(signup.homeURL);
    }
    @When("User enter all requirements")
    public void user_enter_all_requirements() throws InterruptedException {
        Thread.sleep(2000);
        signup.signUpButton.click();
        signup.profileType.click();
        Thread.sleep(2000);
        signup.corporate.click();
        signup.companyName.sendKeys(name);
        signup.firstNameInput.sendKeys(name);
        signup.lastNameInput.sendKeys(name);
        signup.usernameInput.sendKeys(name);
        signup.emailInput.sendKeys(email);
        signup.confirmEmailInput.sendKeys(email);
        signup.passwordInput.sendKeys(password);
        signup.confirmPasswordInput.sendKeys(password);
        signup.securityQuestion.click();
        Thread.sleep(2000);
        signup.option3SecQues.click();
        signup.securityQuestionAnswerInput.sendKeys(name);
        signup.checkbox.click();
        signup.submitSignUpButton.click();
    }
    @Then("User see success message")
    public void user_see_success_message() throws InterruptedException {
        String expected = signup.successMessage.trim();
        Thread.sleep(2000);
        String actual = signup.signUpComplate.getText().trim();
        assertTrue(actual.contains(expected));
    }

    @Given("User at EBANQ page")
    public void user_at_ebanq_page() {
        driver.get(signup.homeURL);
    }
    @When("User signup without info")
    public void user_signup_without_info() throws InterruptedException {
        Thread.sleep(2000);
        signup.signUpButton.click();
        signup.submitSignUpButton.click();
    }
    @Then("User see message")
    public void user_see_message() throws InterruptedException {
        String expected = signup.errorMessage;
        Thread.sleep(2000);
        String  actual = signup.errorMessageLoct.getText().trim();
        assertEquals(expected,actual);
    }




}
