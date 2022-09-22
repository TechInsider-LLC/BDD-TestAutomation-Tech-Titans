package stepDefinitions.pet;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPetStore {

    @Test
    public void createUser() {
        given().contentType("application/json")
                .body("{\n" +
                        "  \"id\":9222968140497270183,\n" +
                        "  \"username\": \"Sammy345\",\n" +
                        "  \"firstName\": \"sammy\",\n" +
                        "  \"lastName\": \"son\",\n" +
                        "  \"email\": \"son1234567890@gmail.com\",\n" +
                        "  \"password\": \"1234567890\",\n" +
                        "  \"phone\": \"1234567890\",\n" +
                        "  \"userStatus\": 1\n" +
                        "}")
                .when().post("https://petstore.swagger.io/v2/user")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getUser() {
        given().contentType("application/json")
                .body("{\n" +
                        "    \"id\": 9222968140497270183,\n" +
                        "    \"username\": \"Sammy345\",\n" +
                        "    \"firstName\": \"sammy\",\n" +
                        "    \"lastName\": \"son\",\n" +
                        "    \"email\": \"son1234567890@gmail.com\",\n" +
                        "    \"password\": \"1234567890\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 1\n" +
                        "}")
                .when().get("https://petstore.swagger.io/v2/user/Sammy345")
                .then().statusCode(200).log().all();

    }

    @Test
    public void updateUser() {
        given().contentType("\"application/json\"")
                .body("{\n" +
                        "  \"id\": 9222968140497270183,\n" +
                        "  \"username\": \"Sammy345\",\n" +
                        "  \"firstName\": \"Sammy\",\n" +
                        "  \"lastName\": \"Sonny\",\n" +
                        "  \"email\": \"Sonny123456@gmail.com\",\n" +
                        "  \"password\": \"1234567890\",\n" +
                        "  \"phone\": \"1234567890\",\n" +
                        "  \"userStatus\": 1\n" +
                        "}")
                .when().put("https://petstore.swagger.io/v2/user/Sammy345")
                .then().log().all().statusCode(200);
    }
}
