package com.restassuredframework.API;

import com.aventstack.extentreports.Status;
import com.restassuredframework.setup.TestSetUp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jsoup.Connection;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class DefaultHomeLayoutAPI extends TestSetUp {
    public static Response verifyWithEngineVersion(Hashtable<String, String> data) {
//Comment : Hitting API with the secret key
        /*Response response=given().auth().basic("sk_test_WJTlE8wgK2mZ6HLN7RqZdx6O","").
                param("email","testingbluestacks@gmail.com").
                post("customers").then().extract().response();*/
        int flag = 2;
/*        System.out.println("testMethod Test Case");
        System.out.println(data.get("android_id"));
        System.out.println(data.get("android_image"));*/
        testLogger().assignAuthor("Kushal Sethi");
        testLogger().assignCategory("Regression");
        testLogger().log(Status.INFO, "Entered userName: " + data.get("android_id"));
        testLogger().log(Status.INFO, "Entered Password: " + data.get("android_image"));



        //Comment : Hitting the API without the secret key as Bluestacks API does not support secret key
        Response response = given().

                param("android_id", data.get("android_id")).
                param("android_image", "data.get(\"android_image\")").
                param("campaign_hash", "data.get(\"campaign_hash\")").
                param("country", "data.get(\"country\")").
                param("guid", "data.get(\"guid\")").
                param("hypervisor", "data.get(\"hypervisor\")").
                param("install_id", "data.get(\"install_id\")").
                param("instance", "data.get(\"instance\")").
                param("locale", "data.get(\"locale\")").
                param("machine_id", "data.get(\"machine_id\")").
                param("oem", "data.get(\"oem\")").
                param("player_version", "data.get(\"player_version\")").
                param("session_id", "data.get(\"session_id\")").
                param("version_machine_id", "data.get(\"version_machine_id\")").
                //param("email","testingbluestacks@gmail.com").
                        post("get_default_home_layout").then().extract().response();

        JsonPath json = response.jsonPath();
        String str=json.get("layout.items[0].items[0].app_package");
        System.out.println(str);
        return response;
    }

    public static Response verifyWithoutHypervisor(Hashtable<String, String> data) {
//Comment : Hitting API with the secret key
        /*Response response=given().auth().basic("sk_test_WJTlE8wgK2mZ6HLN7RqZdx6O","").
                param("email","testingbluestacks@gmail.com").
                post("customers").then().extract().response();*/
        int flag = 2;
/*        System.out.println("testMethod Test Case");
        System.out.println(data.get("android_id"));
        System.out.println(data.get("android_image"));*/
        testLogger().assignAuthor("Kushal Sethi");
        testLogger().assignCategory("Regression");
        testLogger().log(Status.INFO, "Entered userName: " + data.get("android_id"));
        testLogger().log(Status.INFO, "Entered Password: " + data.get("android_image"));

        //Comment : Hitting the API without the secret key as Bluestacks API does not support secret key
        Response response = setFormParams(data.get("arguments"), requestSpecification).
//                Response response = setFormParams(data.get("arguments")).

              /*  param("android_id", data.get("android_id")).
                param("android_image", "data.get(\"android_image\")").
                param("campaign_hash", "data.get(\"campaign_hash\")").
                param("country", "data.get(\"country\")").
                param("guid", "data.get(\"guid\")").
//                param("hypervisor", "data.get(\"hypervisor\")").
                param("install_id", "data.get(\"install_id\")").
                param("instance", "data.get(\"instance\")").
                param("locale", "data.get(\"locale\")").
                param("machine_id", "data.get(\"machine_id\")").
                param("oem", "data.get(\"oem\")").
                param("player_version", "data.get(\"player_version\")").
                param("session_id", "data.get(\"session_id\")").
                param("version_machine_id", "data.get(\"version_machine_id\")").*/
                //param("email","testingbluestacks@gmail.com").
                        post("get_default_home_layout").then().extract().response();
        JsonPath json = response.jsonPath();
        String str=json.get("layout.items[0].app_package");
        System.out.println(str);
        return response;

    }
}
