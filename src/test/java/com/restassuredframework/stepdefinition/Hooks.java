package com.restassuredframework.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void beforeMethodOfCucumber(){
        System.out.println("This is Before cucumber");
    }

    @After
    public void afterMethodOfCucumber(){
        System.out.println("This is After cucumber");
    }

}
