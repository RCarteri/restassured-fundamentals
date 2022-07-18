package com.psrestassured.m5body;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class _3ValidatableresponseRepeatingItemsDemo {
    public static final String BASE_URL = "https://reqres.in/api/users?page=1";

    @Test
    public void repeatingItems(){
     RestAssured.get(BASE_URL)
             .then()
//                .body("data.id", equalTo(1))
             .body("data.id[0]", equalTo(1))
             .body("data.id[1]", equalTo(2))
             .body("data.first_name[0]", equalTo("George"))
             .body("data.first_name[1]", equalTo("Janet"))
//             .body("data.first_name", containsInAnyOrder("George", "Janet"))
             .body("data.first_name", hasItem("George"))
             .body("data.first_name", hasItems("George", "Janet"))
             .body("data.first_name", hasItem(endsWith("ma")));
    }
}
