package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleApiTest {

    @Test
    public void testGetRequest() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = RestAssured.get("/posts/1");

        assertEquals(200, response.getStatusCode(), "Статус відповіді не 200");

        String title = response.jsonPath().getString("title");
        System.out.println("Title: " + title);
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", title, "Title не відповідає очікуваному значенню");
    }
}
