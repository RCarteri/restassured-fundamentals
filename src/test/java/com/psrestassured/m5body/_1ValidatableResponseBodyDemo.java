package com.psrestassured.m5body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.http.ContentType.JSON;
import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.*;

public class _1ValidatableResponseBodyDemo {
    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void matcherExample(){
      RestAssured.get(BASE_URL).then()
              .body("current_user_url", equalTo(BASE_URL + "/user"))
              .body(containsString("feeds_url"))
              .body(containsString("feeds_url"), containsString("feeds_url"));
    }

    @Test
    public void complexBodyExamples(){
        RestAssured.get(BASE_URL + "/users/andrejs-ps").then()
                .body("url", response -> containsString("andrejs-ps"))
                .body("url", response -> containsString(response.body().jsonPath().get("login")));
    }

    @DataProvider
    public Object[][] names(){
        return new Object[][]{
                {"andrejs-ps"},
                {"rest-assured"}
        };
    }

    @Test(dataProvider = "names")
    public void complexBodyExampleWithDp(String name){
        RestAssured.get(BASE_URL + "/users/" + name)
                .then()
                .body("url", response -> containsString(response.body().jsonPath().get("login")));
    }
}
