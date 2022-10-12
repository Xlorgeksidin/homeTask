package ru.home_task.weather.helpers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    private static final ContentType CONTENT_TYPE = ContentType.JSON;
    private static final ContentType ACCEPT = ContentType.JSON;

    public static Response get(String path){
        return prepare()
                .when()
                .get(path)
                .thenReturn();
    }

    private static RequestSpecification prepare() {
        return given()
                .log().all(true)
                .contentType(CONTENT_TYPE)
                .accept(ACCEPT);
    }
}
