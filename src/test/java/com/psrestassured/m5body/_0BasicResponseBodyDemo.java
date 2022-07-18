package com.psrestassured.m5body;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.*;

public class _0BasicResponseBodyDemo {
    public static final String BASE_URL = "https://api.github.com/rate_limit";

    @Test
    public void jsonPathReturnsMap(){
        Response response = RestAssured.get(BASE_URL);

        ResponseBody<?> body = response.body();
        JsonPath jsonPath = body.jsonPath();

        JsonPath jPath = response.body().jsonPath();

        Map<String, String> fullJson = jPath.get();
        Map<String, String> subMap = jPath.get("resources");
        Map<String, String> subMap2 = jPath.get("resources.core");

        int value = jPath.get("resources.core.limit");
        int value2 = jPath.get("resources.graphql.remaining");

        System.out.println(fullJson);
        System.out.println(subMap);
        System.out.println(subMap2);
        System.out.println(value);
        System.out.println(value2);

        assertEquals(value, 60);
        assertEquals(value2, 10);
    }

    @Test
    public void castingFailure(){
        JsonPath jPath = RestAssured.get(BASE_URL).body().jsonPath();
        Map<String, String> isNull = jPath.get("incorrect.path"); //NullPointerException porque o caminho é incorreto
        int aMap = jPath.get("resources.core");                   //ClassCastException   porque retorna um map salvando em um int
        String value = jPath.get("resources.core.limit");         //ClassCastException   porque retorna um int salvando numa String
    }
}
