package com.restassuredframework.rough;

import com.restassuredframework.testutils.ConfigProperties;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.*;

public class TestClass {
    public static ConfigProperties configproperties;
   @Test
    public void testMethod() {

        ConfigFactory.setProperty("environment", "qa");
        configproperties = ConfigFactory.create(ConfigProperties.class);
        System.out.println(configproperties.getBasePath());
        System.out.println(configproperties.getBaseURI());
        RestAssured.basePath = configproperties.getBasePath();
        RestAssured.baseURI = configproperties.getBaseURI();

        /*Response response = given().*//*auth().basic("sk_test_WJTlE8wgK2mZ6HLN7RqZdx6O","").*//*
                param("android_id", "90c344a2067fdb95").
                param("android_image", "Pie64").
                param("campaign_hash", "36f9c514f6c3d7fc74c3b96376e9bde6").
                param("country", "IN").
                param("guid", "fdbbd6ad-a430-4140-9f46-7cfe27c2b607").
                param("hypervisor", "vbox").
                param("install_id", "bfcde5b6-731d-4fa6-b961-d0c0655ee570").
                param("instance", "Pie64").
                param("locale", "en-US").
                param("machine_id", "fdbbd6ad-a430-4140-9f46-7cfe27c2b607").
                param("oem", "nxt").
                param("player_version", "5.12.1.1001").
                param("session_id", "3").
                param("version_machine_id", "caab1847-1c6b-42f6-8509-8dfd2daf093f").
                param("email", "testingbluestacks@gmail.com").
                post("get_default_home_layout").then().extract().response();*/

        //System.out.println(response.asString());
        /*System.out.println(response.prettyPrint());
        JsonPath json = response.jsonPath();
        String str = json.get("layout.items[0].app_package");
        System.out.println(str);*/

    }
}
