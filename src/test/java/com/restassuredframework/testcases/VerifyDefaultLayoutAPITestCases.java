package com.restassuredframework.testcases;
import com.aventstack.extentreports.Status;
import com.restassuredframework.API.DefaultHomeLayoutAPI;
import com.restassuredframework.setup.TestSetUp;
import com.restassuredframework.testutils.DataProviderClass;
import com.restassuredframework.testutils.DataProviderMultiple;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Hashtable;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


@Listeners(com.restassuredframework.customlisteners.CustomListener.class)
public class VerifyDefaultLayoutAPITestCases extends TestSetUp {

    @Test(dataProviderClass = DataProviderMultiple.class, dataProvider = "dpmultipletestcasemethod", enabled = true, priority = 1)
    public void verifyWithValidEngineVersion(Hashtable<String, String> data)
    {
        Response response= DefaultHomeLayoutAPI.verifyWithEngineVersion(data);
        System.out.println(response.asString());
    }

    @Test(dataProviderClass = DataProviderMultiple.class, dataProvider = "dpmultipletestcasemethod", enabled = false, priority = 1)
    public void verifyWithoutHypervisorDetails(Hashtable<String, String> data)
    {
        Response response= DefaultHomeLayoutAPI.verifyWithoutHypervisor(data);
        System.out.println(response.prettyPrint());
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "dpsingletestcasemethod", priority = 2, enabled = false)
    public void verifyCreateAPIWithValidAuthKey(Hashtable<String, String> data) {
        int flag = 1;
        System.out.println("verifyCreateAPIWithValidAuthKey Test Case");
        System.out.println(data.get("username"));
        System.out.println(data.get("password"));
        testLogger().assignAuthor("Kushal Sethi");
        testLogger().assignCategory("Regression");
        testLogger().log(Status.INFO, "Entered userName: " + data.get("username"));
        testLogger().log(Status.INFO, "Entered Password: " + data.get("password"));
    }

    @Test(dataProviderClass = DataProviderMultiple.class, dataProvider = "dpmultipletestcasemethod", priority = 3, enabled = false)
    public void verifyCreateAPIWithValidAuthKeyMultiple(Hashtable<String, String> data) {
        int flag = 2;
        System.out.println("verifyCreateAPIWithValidAuthKey Test Case");
        System.out.println(data.get("username"));
        System.out.println(data.get("password"));
        testLogger().assignAuthor("Kushal Sethi");
        testLogger().assignCategory("Regression");
        testLogger().log(Status.INFO, "Entered userName: " + data.get("username"));
        testLogger().log(Status.INFO, "Entered Password: " + data.get("password"));
    }
}
