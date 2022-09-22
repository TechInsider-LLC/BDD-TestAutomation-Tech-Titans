package stepDefinitions.pet;

import io.cucumber.java.en.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PetAutomation {
private String body;
    @Given("Admin has all the data from creating")
    public void admin_has_all_the_data_from_creating() {

    }
    @When("admin creates a user")
    public void admin_creates_a_user() {
        body = "{\n" +
                "  \"id\":9222968140497270183,\n" +
                "  \"username\": \"Sammy345\",\n" +
                "  \"firstName\": \"sammy\",\n" +
                "  \"lastName\": \"son\",\n" +
                "  \"email\": \"son1234567890@gmail.com\",\n" +
                "  \"password\": \"1234567890\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        given().contentType("application/json")
                .log().all()
                .body(body)
                .when().post("https://petstore.swagger.io/v2/user")
                .then().log().all().statusCode(200);

    }
    @When("admin gets the user")
    public void admin_gets_the_user() {
        given().contentType("application/json")
                .log().all()
                .when().get("https://petstore.swagger.io/v2/user/Sammy345")
                .then().log().all().statusCode(200);
    }
    @When("admin updates the user")
    public void admin_updates_the_user() {
        given().contentType("application/json")
                .log().all()
                .body("{\n" +
                        "  \"id\":9222968140497270183,\n" +
                        "  \"username\": \"Sammy345\",\n" +
                        "  \"firstName\": \"sammy\",\n" +
                        "  \"lastName\": \"sonnnnyyyyy\",\n" +
                        "  \"email\": \"son1234567890@gmail.com\",\n" +
                        "  \"password\": \"1234567890\",\n" +
                        "  \"phone\": \"1234567890\",\n" +
                        "  \"userStatus\": 1\n" +
                        "}")
                .when().put("https://petstore.swagger.io/v2/user/Sammy345")
                .then().log().all().statusCode(200);

    }
    @When("admin gets the user again")
    public void admin_gets_the_user_again() {
        given().contentType("application/json")
                .log().all()
                .when().get("https://petstore.swagger.io/v2/user/Sammy345")
                .then().log().all().statusCode(200);
    }
    @When("Admin deletes the user")
    public void admin_deletes_the_user() {
        given().contentType("application/json")
                .log().all()
                .when().delete("https://petstore.swagger.io/v2/user/Sammy345")
                .then().log().all().statusCode(200);
    }
    @Then("User account should no longer be available")
    public void user_account_should_no_longer_be_available() {
        String actual =
                given().contentType("application/json")
                .log().all()
                .when().get("https://petstore.swagger.io/v2/user/Sammy345")
                .then().log().all().statusCode(404).extract().path("message");
                String expected = "User not found";
                        assertEquals(expected, actual);

    }
}
