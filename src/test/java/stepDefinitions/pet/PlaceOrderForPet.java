package stepDefinitions.pet;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PlaceOrderForPet {

    @Test
    public void placeOrder (){
        given().contentType("application/json")
                .body("{\n" +
                        "    \"id\": 9,\n" +
                        "    \"petId\": 9,\n" +
                        "    \"quantity\": 2,\n" +
                        "    \"shipDate\": \"2022-09-15T21:37:48.707Z\",\n" +
                        "    \"status\": \"placed\",\n" +
                        "    \"complete\": true\n" +
                        "}")
        .when().post("https://petstore.swagger.io/v2/store/order")
                .then().statusCode(200).log().all();
    }
    @Test
    public void getOrder (){
        given().contentType("application/json")
                .body("{\n" +
                        "  \"id\": 9,\n" +
                        "  \"petId\": 9,\n" +
                        "  \"quantity\": 2,\n" +
                        "  \"shipDate\": \"2022-09-15T21:37:48.707+0000\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when().get("https://petstore.swagger.io/v2/store/order/9\n")
                .then().statusCode(200).log().all();

    }
}
