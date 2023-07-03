package com.restassuredframework.rough;

import com.restassuredframework.API.ReqResAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class TestViaJsonBody {

    @Test(enabled = true, priority = 1)
    public void verifyCreateUser()
    {
        Response response = given().contentType(ContentType.JSON).
                body(new File("G:\\RestAssured\\FrameworkRestAssured\\src\\test\\resources\\jsonFiles\\Users.json")).
                when().post("https://reqres.in/api/users").then().extract().response();
        System.out.println(response.asString());
        response.prettyPrint();
    }
}
