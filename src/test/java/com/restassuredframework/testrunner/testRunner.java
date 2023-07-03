package com.restassuredframework.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@CucumberOptions
        (
                features = "src/test/resources/FeatureFiles/CreateCustomerAPI.feature",
                glue = {"com/restassuredframework/stepdefinition"}
        )

public class testRunner extends AbstractTestNGCucumberTests{
    private TestNGCucumberRunner testNGCucumberRunner;
    @Test()
    public void testRunnerWithTestng() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

}
