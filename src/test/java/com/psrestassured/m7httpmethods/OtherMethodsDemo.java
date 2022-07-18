package com.psrestassured.m7httpmethods;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class OtherMethodsDemo {
    public static final String BASE_URL = "https://api.github.com/user/repos";
    public static final String TOKEN = "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";

    @Test(description = "Create a repo")
    public void postTest(){
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme\"}")
                .when()
                    .post(BASE_URL)
                .then()
                    .statusCode(201);
    }
}
