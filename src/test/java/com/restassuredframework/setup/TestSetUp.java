package com.restassuredframework.setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.restassuredframework.testutils.ConfigProperties;
import com.restassuredframework.testutils.ExcelReader;
import com.restassuredframework.testutils.ExtentManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class TestSetUp {

    int flag;
    public static ConfigProperties configproperties;
    public ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") +
            "\\src\\test\\resources\\testData\\TestData.xlsx");
    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> classLevelLogger = new ThreadLocal<ExtentTest>();
    protected static ThreadLocal<ExtentTest> testLevelLogger = new ThreadLocal<ExtentTest>();
    public static RequestSpecification requestSpecification;

    @BeforeSuite
    public void beforeSuite() {


        if (flag == 1) {
            ConfigFactory.setProperty("environment", "qa");
        } else
        {
            ConfigFactory.setProperty("environment", "dev");
            /*System.out.println("From else multiple condition");*/
        }
        configproperties = ConfigFactory.create(ConfigProperties.class);
        RestAssured.baseURI = configproperties.getBaseURI();
        RestAssured.basePath = configproperties.getBasePath();
        extent = ExtentManager.GetExtent();
        System.out.println(configproperties.getBaseURI());
        System.out.println(configproperties.getBasePath());

    }

    @BeforeTest
    public void beforeTest() {

    }

    @BeforeClass
    public void beforeClass() {

        ExtentTest parent = extent.createTest(getClass().getSimpleName());
        classLevelLogger.set(parent);


    }

    @BeforeMethod
    public void beforeMethod(Method method) {

        requestSpecification = setRequestSpecification("key");
/*        System.out.println("Execution of " + method.getName() + " started.");*/
    }

    @AfterMethod
    public void afterMethod(ITestResult testCaseResult) {


    }

    @AfterClass
    public void afterClass() {

    }

    @AfterTest
    public void afterTest() {

    }

    @AfterSuite
    public void tearDown() {

    }

    public static ExtentTest testLogger() {
        return testLevelLogger.get();
    }

    public static RequestSpecification setRequestSpecification(String key) {

        return given().auth().basic(key, "");
    }

    public static RequestSpecification setFormParams(String arguments,RequestSpecification requestSpec)
//    public static RequestSpecification setFormParams(String arguments)
    {
        String[] argument = arguments.split(";");
        for (int i = 0; i < argument.length; i++) {
            String[] keyvaluepair = argument[i].split(":");
            requestSpec.formParam(keyvaluepair[0],keyvaluepair[1]);
//            requestSpecification.formParam(keyvaluepair[0],keyvaluepair[1]);
        }
        return requestSpec;
//        return requestSpecification;
    }
}
