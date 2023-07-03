package com.restassuredframework.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCustomerAPISteps {

    @Given("I set the auth for the Create Customer API")
    public void i_set_the_auth_for_the_create_customer_api() {
        System.out.println("Hi BDD");
    }

    @When("I pass {string} as the email")
    public void i_pass_as_the_email(String email) {
        System.out.println("Hi BDD");
    }

    @When("I pass the sample description {string}")
    public void i_pass_the_sample_description(String description) {
        System.out.println("Hi BDD");
    }

    @When("I send the {string} request to the customer")
    public void i_send_the_request_to_the_customer(String string) {
        System.out.println("Hi BDD");
    }

    @Then("I should be able to create the customer")
    public void i_should_be_able_to_create_the_customer() {
        System.out.println("Hi BDD");
    }

    @Then("the email id in the response should be {string}")
    public void the_email_id_in_the_response_should_be(String string) {
        System.out.println("Hi BDD");
    }

    @Then("the details in the description should be {string}")
    public void the_details_in_the_description_should_be(String string) {
        System.out.println("Hi BDD");
    }
}
