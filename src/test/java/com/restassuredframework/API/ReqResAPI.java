package com.restassuredframework.API;
import com.aventstack.extentreports.Status;
import com.restassuredframework.setup.TestSetUp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.util.Hashtable;
import static io.restassured.RestAssured.given;

public class ReqResAPI
{
    public static Response CreateUserViaJsonBody()
    {
        Response response = given().contentType(ContentType.JSON).
                body(new File("G:\\RestAssured\\FrameworkRestAssured\\src\\test\\resources\\jsonFiles\\Users.json")).
                when().post("https://reqres.in/api/users").then().extract().response();
        return response;
    }
}
