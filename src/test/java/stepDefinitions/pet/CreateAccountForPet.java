package stepDefinitions.pet;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateAccountForPet {

    @Test
    public void createUser(){

       Response response = given().contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"Sammy345\",\n" +
                        "  \"firstName\": \"sammy\",\n" +
                        "  \"lastName\": \"son\",\n" +
                        "  \"email\": \"son1234567890@gmail.com\",\n" +
                        "  \"password\": \"1234567890\",\n" +
                        "  \"phone\": \"1234567890\",\n" +
                        "  \"userStatus\": 1\n" +
                        "}")
               .when().post("https://petstore.swagger.io/v2/user")
               .then().statusCode(200).extract().response();


      long actual = given().contentType("application/json")
               .when().post("https://petstore.swagger.io/v2/user/Sammy345", "Sammy345")
               .then().log().all().statusCode(200).extract().response().path("username");
       //assertEquals(username, actual);
    }
}
