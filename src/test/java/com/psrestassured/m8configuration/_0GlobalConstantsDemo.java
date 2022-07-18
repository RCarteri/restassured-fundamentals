package com.psrestassured.m8configuration;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class _0GlobalConstantsDemo {
    @BeforeSuite
    public void setup(){
        baseURI = "http://reqres.in/";
        basePath = "api/users";
        rootPath = "data";
    }

    @Test
    public void testOneUsinglobalConstants() {
        RestAssured.get()
                .then()
                .body("id[0]", is(1));
    }

    @Test
    public void testTwoUsinglobalConstants() {
        RestAssured.get()
                .then()
                .body("id[1]", is(2));
    }
}
