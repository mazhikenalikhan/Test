package org.example.project;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestTestPost {
    @Test
    public void testRegisterFull() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("""
                        {
                          "email": "eve.holt@reqres.in",
                          "password": "pistol",
                          "username": ""
                        }""")
                .when()
                .request("POST", "https://reqres.in/api/register")
                .then()
                .statusCode(200);
    }
    @Test
    public void testRegisterRequired() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("""
                        {
                            "email": "eve.holt@reqres.in",
                            "password": "pistol"
                        }
                        """)
                .when()
                .request("POST", "https://reqres.in/api/register")
                .then()
                .statusCode(200);
    }
    @Test
    public void testRegisterNoEmail() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("""
                        {
                            "password": "pistol"
                        }
                        """)
                .when()
                .request("POST", "https://reqres.in/api/register")
                .then()
                .statusCode(400);
    }
    @Test
    public void testRegisterNoPassword() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("""
                        {
                            "email": "eve.holt@reqres.in"
                        }""")
                .when()
                .request("POST", "https://reqres.in/api/register")
                .then()
                .statusCode(400);
    }
    @Test
    public void testRegisterEmptyJson() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("""
                        {
                            "email": "",
                            "password": ""
                        }
                        """)
                .when()
                .request("POST", "https://reqres.in/api/register")
                .then()
                .statusCode(400);
    }
    @Test
    public void testRegisterNoData() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "}")
                .when()
                .request("POST", "https://reqres.in/api/register")
                .then()
                .statusCode(400);
    }
    @Test
    public void date(){
        System.out.println(given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "}")
                .when()
                .request("POST", "https://reqres.in/api/register")
                .getHeaders()
                .getValue("date"));
    }
}
