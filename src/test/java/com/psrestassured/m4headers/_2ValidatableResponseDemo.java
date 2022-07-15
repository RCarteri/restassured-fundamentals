package com.psrestassured.m4headers;

import io.restassured.RestAssured;
import org.hamcrest.number.OrderingComparison;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static io.restassured.http.ContentType.JSON;
import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.*;

public class _2ValidatableResponseDemo {
    public static final String BASE_URL = "http://api.github.com";

    @Test
    public void basicValidatableExample(){
      RestAssured.get(BASE_URL)
              .then().assertThat()
                .statusCode(200)
              .and()
                .contentType(JSON)
              .and()
                .header("x-ratelimit-limit", "60");
    }

    @Test
    public void simpleHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .statusCode(lessThan(300))
                .header("cache-control", containsStringIgnoringCase("max-age=60"))
                .time(lessThan(2L), SECONDS)
                .header("etag", notNullValue())
                .header("etag", not(emptyString()));
    }

    @Test
    public void complexHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .header("x-ratelimit-limit", Integer::parseInt, equalTo(60))
                .header("date", date -> parse(date, RFC_1123_DATE_TIME), comparesEqualTo(now()))
                .header("x-ratelimit-limit", response -> greaterThan(response.header("x-ratelimit-remaining")));
    }














}
