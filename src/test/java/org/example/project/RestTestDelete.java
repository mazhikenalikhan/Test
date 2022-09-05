package org.example.project;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestTestDelete {
    @Test
    public void deleteDeleted(){
        delete("https://reqres.in/api/users/1");
        when()
            .delete("https://reqres.in/api/users/1")
            .then()
            .statusCode(404);
    }
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
    public void deleteNonValid(){
        when()
                .delete("https://reqres.in/api/users/1.5")
                .then()
                .statusCode(400);
    }
    @Test
    public void deleteAndRegister(){
        delete("https://reqres.in/api/users/4");
        given()
                .header("Content-type", "application/json")
                .and()
                .body("""
                        {
                            "id": 4,
                            "email": "eve.holt@reqres.in",
                            "password": "pistol",
                            "first_name": "Eve",
                            "last_name": "Holt",
                            "avatar": "https://reqres.in/img/faces/4-image.jpg"
                        }""")
                .when()
                .request("POST", "https://reqres.in/api/register")
                .then()
                .statusCode(200);
    }
    @Test
    public void deleteDeletedResources(){
        delete("https://reqres.in/api/resource/1");
        when()
                .delete("https://reqres.in/api/resource/1")
                .then()
                .statusCode(404);
    }
    @Test
    public void deleteRealResources(){
        when()
                .delete("https://reqres.in/api/resource/1")
                .then()
                .statusCode(204);
    }
    @Test
    public void deleteNotRealResources(){
        when()
                .delete("https://reqres.in/api/resource/13")
                .then()
                .statusCode(404);
    }
    @Test
    public void deleteNonValidResources(){
        when()
                .delete("https://reqres.in/api/resource/1.5")
                .then()
                .statusCode(400);
    }
}
