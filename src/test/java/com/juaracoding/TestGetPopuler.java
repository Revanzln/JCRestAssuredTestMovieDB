package com.juaracoding;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetPopuler {

    @Test
    public void testApi() {
        given()
                .queryParam("api_key", "f139ba0886be224dfd0a638c6a9bebb3")
                .when()
                .get("https://api.themoviedb.org/3/movie/popular")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGet() {
        Response response = given()
                .queryParam("api_key", "f139ba0886be224dfd0a638c6a9bebb3")
                .when()
                .get("https://api.themoviedb.org/3/movie/popular");

        response.then()
                .statusCode(200);

        String responseBody = response.getBody().asString();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String total_pages = jsonPathEvaluator.getString("total_pages");
        String total_results = jsonPathEvaluator.getString("total_results");

        System.out.println(responseBody);
        System.out.println(total_pages);
        System.out.println(total_results);
    }
}