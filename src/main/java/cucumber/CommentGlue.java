package cucumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.CommentObject;
import org.junit.Assert;
import rest.RestHandler;
import rest.RestHandlerImp;

import java.util.Map;

public class CommentGlue {

    private Map<String, CommentObject> commentMap;
    private CommentObject comment;
    private String request;
    private Response response;


    @Given("^I get all comment data for postId: (.*?)$")
    public void getCommentDataForPostId(String postId){
        RestHandler restHandler = new RestHandlerImp();
        commentMap = restHandler.getCommentsForId(postId);
    }

    @Given("^I provide values for comment request:$")
    public void getCommentData(DataTable dataTable){
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
        CommentObject commentObject = new CommentObject();
        commentObject.setBody(dataMap.get("body"));
        commentObject.setName(dataMap.get("name"));
        commentObject.setId(dataMap.get("id"));
        commentObject.setEmail(dataMap.get("email"));
        commentObject.setPostId("postId");
        try {
            this.request = mapper.writeValueAsString(commentObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @When("^I send the request to comments endpoint$")
    public void sendRequestToApi(){
        RestHandler restHandler = new RestHandlerImp();
        response = restHandler.makeComment(request);
    }

    @When("^I get a comment by comment id: (.*?)$")
    public void getCommentById(String id){
        comment = commentMap.get(id);
    }

    @Then("^I assert the following values in the post response:$")
    public void assertResponseObject(DataTable dataTable){
        Map<String,String> assertionMap = dataTable.asMap(String.class,String.class);
        CommentObject expectedComment = new CommentObject();
        expectedComment.setPostId(assertionMap.get("postId"));
        expectedComment.setEmail(assertionMap.get("email"));
        expectedComment.setId(assertionMap.get("id"));
        expectedComment.setName(assertionMap.get("name"));
        expectedComment.setBody(assertionMap.get("body"));
        Assert.assertEquals(expectedComment,comment);
    }

    @Then("^I verify that response status from comments endpoint is (.*?)$")
    public void verifyStatus(String status){
        Assert.assertEquals(status, String.valueOf(response.getStatusCode()));
    }

    @And("^I verify that response body from comments endpoint is (.*?)$")
    public void verifyResponse(String response){
        Assert.assertTrue(this.response.asString().contains(response));
    }
}
