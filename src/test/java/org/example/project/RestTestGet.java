package org.example.project;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class RestTestGet {
    @Test
    public void getEmptyList(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=3&per_page=6")
                .then()
                .statusCode(200);
    }
    @Test
    public void getFullList(){
        given()
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200);
    }
    @Test
    public void getPageList(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2&per_page=2")
                .then()
                .statusCode(200);
    }
    @Test
    public void getListWithLimit(){
        given()
                .when()
                .get("https://reqres.in/api/users?per_page=12")
                .then()
                .statusCode(200);
    }
    @Test
    public void getListWithOffset(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
    }
    @Test
    public void getIncorrectParam(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=1.5&per_page='sd'")
                .then()
                .statusCode(400);
    }

    @Test
    public void getNegativeOffset(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=-1")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data.id", hasItem(1));
    }
    @Test
    public void getNonExistedOffset(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=100")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data", empty());
    }
    @Test
    public void getSorted(){
        ArrayList<Integer> sorted = when().get("https://reqres.in/api/users?page=1").then().extract().path("data.id");
        Collections.sort(sorted);
        given()
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .assertThat()
                .body("data.id", equalTo(sorted));
    }
    @Test
    public void getCorrectID(){
        when()
                .get("https://reqres.in/api/users/1")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("data.id", equalTo(1));
    }
    @Test
    public void getIncorrectID(){
        when()
                .get("https://reqres.in/api/users/13")
                .then()
                .statusCode(404);
    }
    @Test
    public void getInvalidID(){
        when()
                .get("https://reqres.in/api/users/1.5")
                .then()
                .statusCode(404);
    }
    @Test
    public void getEmptyListResources(){
        given()
                .when()
                .get("https://reqres.in/api/resource?page=3&per_page=6")
                .then()
                .statusCode(200);
    }
    @Test
    public void getFullListResources(){
        given()
                .when()
                .get("https://reqres.in/api/resource")
                .then()
                .statusCode(200);
    }
    @Test
    public void getPageListResources(){
        given()
                .when()
                .get("https://reqres.in/api/resource?page=2&per_page=2")
                .then()
                .statusCode(200);
    }
    @Test
    public void getListWithLimitResources(){
        given()
                .when()
                .get("https://reqres.in/api/resource?per_page=12")
                .then()
                .statusCode(200);
    }
    @Test
    public void getListWithOffsetResources(){
        given()
                .when()
                .get("https://reqres.in/api/resource?page=2")
                .then()
                .statusCode(200);
    }
    @Test
    public void getIncorrectParamResources(){
        given()
                .when()
                .get("https://reqres.in/api/resource?page=1.5&per_page='sd'")
                .then()
                .statusCode(400);
    }

    @Test
    public void getNegativeOffsetResources(){
        given()
                .when()
                .get("https://reqres.in/api/resource?page=-1")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data.id", hasItem(1));
    }
    @Test
    public void getNonExistedOffsetResources(){
        given()
                .when()
                .get("https://reqres.in/api/resource?page=100")
                .then()
                .statusCode(200)
                .assertThat()
                .body("data", empty());
    }
    @Test
    public void getSortedResources(){
        ArrayList<Integer> sorted = when().get("https://reqres.in/api/resource?page=1").then().extract().path("data.id");
        Collections.sort(sorted);
        given()
                .when()
                .get("https://reqres.in/api/resource?page=1")
                .then()
                .assertThat()
                .body("data.id", equalTo(sorted));
    }
    @Test
    public void getCorrectIDResources(){
        when()
                .get("https://reqres.in/api/resource/1")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("data.id", equalTo(1));
    }
    @Test
    public void getIncorrectIDResources(){
        when()
                .get("https://reqres.in/api/resource/13")
                .then()
                .statusCode(404);
    }
    @Test
    public void getInvalidIDResources(){
        when()
                .get("https://reqres.in/api/resource/1.5")
                .then()
                .statusCode(404);
    }
}
