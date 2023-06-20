package com.juaracoding;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class TestGetNowPlaying {

    @Test
    public void testApi() {
        given()
                .queryParam("api_key", "f139ba0886be224dfd0a638c6a9bebb3")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGet() {
        Response response = given()
                .queryParam("api_key", "f139ba0886be224dfd0a638c6a9bebb3")
                .when()
                .get("https://api.themoviedb.org/3/movie/now_playing");

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