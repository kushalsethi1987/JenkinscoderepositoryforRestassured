package com.restassuredframework.rough;

import org.testng.annotations.*;

public class TestNGUnderstanding {

    @Test(dataProvider="DataProviderMethod")
    public void TestCase(String s){System.out.println("This is the test case");}
    @BeforeClass
    public void BeforeClass(){System.out.println("This is before class");}
    @AfterClass
    public void AfterClass(){System.out.println("This is after class");}
    @BeforeMethod
    public void BeforeMethod(){System.out.println("This is Before Method");}
    @AfterMethod
    public void AfterMethod(){System.out.println("This is after Method");}
    @BeforeTest
    public void BeforeTest(){System.out.println("This is Before Test");}
    @AfterTest
    public void AfterTest(){System.out.println("This is after test");}
    @BeforeSuite
    public void BeforeSuite(){System.out.println("This is before Suite");}
    @AfterSuite
    public void AfterSuite(){System.out.println("This is after Suite");}
    @BeforeGroups
    public void BeforeGroups(){System.out.println("This is before Groups");}
    @AfterGroups
    public void AfterGroups(){System.out.println("This is after Groups");}
    @DataProvider(name="DataProviderMethod")
    public Object[][] DataProviderMethod(){ System.out.println("Data provider is executed");return new Object[1][1];}
}
