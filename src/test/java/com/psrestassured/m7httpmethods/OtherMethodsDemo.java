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

    @Test(description = "Update a repo")
    public void patchTest(){
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme-patched\"}")
                .when()
                    .post("https://api.github.com/repos/RCarteri/deleteme")
                .then()
                    .statusCode(200);
    }

    @Test(description = "Delete a repo")
    public void deleteTest(){
        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                .when()
                    .delete("https://api.github.com/repos/RCarteri/deleteme-patched")
                .then()
                    .statusCode(204);
    }
}
