package com.juaracoding;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPostMovieRating {

    @Test
    public void testPost() {
        float rating = 8.5f;
        JSONObject request = new JSONObject();
        request.put("value", rating);
        System.out.println(request.toJSONString());

        given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMTM5YmEwODg2YmUyMjRkZmQwYTYzOGM2YTliZWJiMyIsInN1YiI6IjY0ODMxOTk3ZTI3MjYwMDBlOGJmZjg3ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.-XGsf2b-7cJXx0I0687VigNEvvXuDPXVg447Ney6JXs")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://api.themoviedb.org/3/movie/385687/rating")
                .then()
                .statusCode(201)
                .log().all();
    }
}