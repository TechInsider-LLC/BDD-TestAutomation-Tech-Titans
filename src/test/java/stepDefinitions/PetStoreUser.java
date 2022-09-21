package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;
import static org.bouncycastle.cms.RecipientId.password;
import static org.junit.Assert.assertEquals;

public class PetStoreUser {
    private  String username;
    private String password;

    private String body;

    @Given("Admin has all the date for creating a user")
    public void admin_has_all_the_date_for_creating_a_user() {
        username = "AlexLee";
        password = "123456";




    }
    @When("Admin creates a user")
    public void admin_creates_a_user() {
        body = getBody(username,password);

        given().contentType("application/json")
                .log().all()
                .body(body)
                .when().post("https://petstore.swagger.io/v2/user")
                .then().log().all().statusCode(200);


    }



    @When("Admin gets the user")
    public void admin_gets_the_user() {
        given().contentType("application/json")
                .log().all()

                .when().get("https://petstore.swagger.io/v2/user/{username}", username)
                .then().statusCode(200);



    }
    @When("Admin updates the user")
    public void admin_updates_the_user() {
        given().contentType("application/json")
                .log().all()
                .body(getBody(username,"12345789"))
                .when().put("https://petstore.swagger.io/v2/user/{username}",username)
                .then().log().all().statusCode(200);

    }
    @When("Admin deletes the user")
    public void admin_deletes_the_user() {
        given().contentType("application/json")
                .log().all()
                .when().delete("https://petstore.swagger.io/v2/user/{username}",username)
                .then().log().all().statusCode(200);


    }
    @Then("Admin shoouldn't see the user")
    public void admin_shoouldn_t_see_the_user() {
        String actual =
        given().contentType("application/json")
                .log().all()

                .when().get("https://petstore.swagger.io/v2/user/{username}", username)
                .then().statusCode(404).extract().path("message");
        String expected = "User not found";
        assertEquals(expected,actual);

    }
    private String getBody(String username,String password) {
        return "{\n" +
                "  \"id\": 713000000000000399,\n" +
                "  \"username\":\"" + username + "\",\n" +
                "  \"firstName\": \"Leeeee\",\n" +
                "  \"lastName\": \"john\",\n" +
                "  \"email\": \"leejohn@gmail.com\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"phone\": \"2222222\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
    }
}
