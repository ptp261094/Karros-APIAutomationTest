package stepDefinitions;


import org.junit.Assert;

import commons.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DemoSteps extends BaseClass {

	private Response response;
	private RequestSpecification request;
	private static String happyPath; 
	private static String negativePath; 
	
	@Given("^I set up happy path$")
	public void iSetUpHappyPath() {
		init();
		request = RestAssured.given();
		happyPath = "/1";
	}
	
	@When("^I send a GET request with happy path$")
	public void iSendAGETRequestWithHappyPath(){
		response = request.get(happyPath);
	}

	@When("^I send a GET request with negative path$")
	public void iSendAGETRequestWithNegativePath(){
		response = request.get(negativePath);
	}

	@Then("^The status code is (\\d+)$")
	public void theStatusCodeIs(int statusCode) {
	    Assert.assertEquals("The status code is not equal", statusCode, response.getStatusCode());
	}

	@Then("^The id is (\\d+)$")
	public void theIdIs(int id) {
	    Assert.assertEquals("The id is not equal", id, response.getBody().jsonPath().getInt("id"));
	}

	@Then("^The title is \"([^\"]*)\"$")
	public void theTitleIs(String title) {
	    Assert.assertEquals("The title is not equal", title, response.getBody().jsonPath().getString("title"));
	}

	@Given("^I set up negative path$")
	public void iSetUpNegativePath() {
		init();
		request = RestAssured.given();
		negativePath = "/a";
	}

	@Then("^The response is empty$")
	public void theResponseIsEmpty() {
		Assert.assertEquals("The response is not empty", "{}", response.getBody().asString());	    
	}

}
