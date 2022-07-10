package APITests;/*
 * Copyright (c) 2022. Saurabh Srivastava
 */

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APICheck {

    public String getToken;

    @Test
    public void authToken() {

        String payload = "{\n" +
                "\"username\":\"admin\",\n" +
                "\"password\":\"password123\"\n" +
                "}";

        Response response = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/auth")
                .then()
                .log()
                .all()
                .extract().response();
        getToken = response.jsonPath().getString("token");
        System.out.println("Token:"+getToken );
    }

}
