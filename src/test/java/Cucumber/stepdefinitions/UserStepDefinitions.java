package Cucumber.stepdefinitions;

import Cucumber.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.notNullValue;

public class UserStepDefinitions {

    private Response response;

    @Given("I have a user ID")
    public void i_have_a_user_id() {
        // No need to set user ID explicitly for the GET, PUT, PATCH, DELETE requests
    }

    @When("I send a GET request to the /api/users/{userId} endpoint")
    public void i_send_a_get_request_to_the_api_users_endpoint(Integer userId) {
        response = RestAssured.get("https://reqres.in/api/users/{userId}", userId);
    }

    @When("I send a POST request to the /api/users endpoint with payload")
    public void i_send_a_post_request_to_the_api_users_endpoint_with_payload(String payload) {
        response = RestAssured.given().contentType("application/json").body(payload)
                .post("https://reqres.in/api/users");
    }

    @When("I send a PUT request to the /api/users/{userId} endpoint with payload")
    public void i_send_a_put_request_to_the_api_users_endpoint_with_payload(Integer userId, String payload) {
        response = RestAssured.given().contentType("application/json").body(payload)
                .put("https://reqres.in/api/users/{userId}", userId);
    }

    @When("I send a PATCH request to the /api/users/{userId} endpoint with payload")
    public void i_send_a_patch_request_to_the_api_users_endpoint_with_payload(Integer userId, String payload) {
        response = RestAssured.given().contentType("application/json").body(payload)
                .patch("https://reqres.in/api/users/{userId}", userId);
    }

    @When("I send a DELETE request to the /api/users/{userId} endpoint")
    public void i_send_a_delete_request_to_the_api_users_endpoint(Integer userId) {
        response = RestAssured.delete("https://reqres.in/api/users/{userId}", userId);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatusCode) {
        response.then().statusCode(Constants.STATUS_CODE_OK);
    }

    @And("the response should contain the user details")
    public void the_response_should_contain_the_user_details() {
        // Verify that the response body contains the name and job fields
        response.then().body("name", notNullValue());
        response.then().body("job", notNullValue());
    }

    }
}
