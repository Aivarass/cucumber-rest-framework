package cucumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.PostObject;
import org.junit.Assert;
import rest.RestHandler;
import rest.RestHandlerImp;

import java.util.Map;

public class PostGlue {

    private String request;
    private Response response;

    @Given("^I provide values for request:$")
    public void getPostData(DataTable dataTable){
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
        try {
           this.request = mapper.writeValueAsString(new PostObject(dataMap.get("userId"),dataMap.get("title"),dataMap.get("body")));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @When("^I send the request to posts endpoint$")
    public void sendRequestToApi(){
        RestHandler restHandler = new RestHandlerImp();
        response = restHandler.makePost(request);
    }

    @Then("^I verify that response status is (.*?)$")
    public void verifyStatus(String status){
        Assert.assertEquals(status, String.valueOf(response.getStatusCode()));
    }

    @And("^I verify that response body is (.*?)$")
    public void verifyResponse(String response){
        Assert.assertTrue(this.response.asString().contains(response));
    }

}
