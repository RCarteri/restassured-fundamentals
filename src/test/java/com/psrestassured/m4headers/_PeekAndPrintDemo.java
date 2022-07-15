package com.psrestassured.m4headers;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class _PeekAndPrintDemo {
    public static final String BASE_URL = "http://api.github.com";
    @Test
    public void peek(){
        RestAssured.get(BASE_URL)
                .peek();
    }

    @Test
    public void prettyPeek(){
        RestAssured.get(BASE_URL)
                .prettyPeek();
    }

    @Test
    public void print(){
        RestAssured.get(BASE_URL)
                .print();
    }

    @Test
    public void prettyPrint(){
        RestAssured.get(BASE_URL)
                .prettyPrint();
    }
}
