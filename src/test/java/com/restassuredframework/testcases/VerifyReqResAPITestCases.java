package com.restassuredframework.testcases;

import com.restassuredframework.API.DefaultHomeLayoutAPI;
import com.restassuredframework.API.ReqResAPI;
import com.restassuredframework.setup.TestSetUp;
import com.restassuredframework.testutils.DataProviderMultiple;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Hashtable;

/*@Listeners(com.restassuredframework.customlisteners.CustomListener.class)*/
public class VerifyReqResAPITestCases
{
    @Test(enabled = true, priority = 1)
    public void verifyCreateUser()
    {
        Response response = ReqResAPI.CreateUserViaJsonBody();
        System.out.println(response.asString());
    }
}
