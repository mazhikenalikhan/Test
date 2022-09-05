package org.example.project;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class RestTestDelete {
    @Test
    public void deleteReal(){
        when()
                .delete("https://reqres.in/api/users/1")
                .then()
                .statusCode(204);
    }
    @Test
    public void deleteNotReal(){
        when()
                .delete("https://reqres.in/api/users/13")
                .then()
                .statusCode(404);
    }
    @Test
    public void deleteValid(){
        when()
                .delete("https://reqres.in/api/users/1.5")
                .then()
                .statusCode(400);
    }
}
