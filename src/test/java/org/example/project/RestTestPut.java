package org.example.project;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTestPut {
    @Test
    public void putCorrect() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/1")
                .then()
                .statusCode(200);
    }
    @Test
    public void putNonExistedID() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/15")
                .then()
                .statusCode(404);
    }
    @Test
    public void putNonValidID() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/1.5")
                .then()
                .statusCode(400);
    }
    @Test
    public void putNotFullID() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/1")
                .then()
                .statusCode(200);
    }
}
