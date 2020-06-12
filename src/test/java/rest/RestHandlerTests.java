package rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;
import model.CommentObject;
import model.UserObject;
import org.junit.Assert;
import org.junit.Test;
import utils.PropertyLoader;

import java.util.Map;

public class RestHandlerTests {

    @Test
    public void testRestHandlerUser() throws JsonProcessingException {
        RestHandler restHandler = new RestHandlerImp();
        Map<String,UserObject> userMap = restHandler.listOfUsers();
        Assert.assertEquals(10,userMap.size());
    }

    @Test
    public void testRestHandlerComment() throws JsonProcessingException {
        RestHandler restHandler = new RestHandlerImp();
        Map<String, CommentObject> commentMap = restHandler.getCommentsForId("1");
        Assert.assertEquals(5,commentMap.size());
    }

    @Test
    public void testRestHandlerPost() throws JsonProcessingException {
        String json = "  {\n" +
                "    \"userId\": 123,\n" +
                "    \"title\": \"testing testing testing aivaras\",\n" +
                "    \"body\": \"testing body over here aivaras\"\n" +
                "  }";
        RestHandler restHandler = new RestHandlerImp();
        Response apiResponse = restHandler.makePost(json);
        System.out.println(apiResponse.asString());
        Assert.assertEquals(201,apiResponse.getStatusCode());
        Assert.assertEquals("{\n" +
                "  \"id\": 101\n" +
                "}",apiResponse.asString());
    }

    @Test
    public void testRestHandlerCommentPost() throws JsonProcessingException {
        String json = "  {\n" +
                "    \"userId\": 123,\n" +
                "    \"title\": \"testing testing testing aivaras\",\n" +
                "    \"body\": \"testing body over here aivaras\"\n" +
                "  }";
        RestHandler restHandler = new RestHandlerImp();
        Response apiResponse = restHandler.makeComment(json);
        Assert.assertEquals(201,apiResponse.getStatusCode());
        Assert.assertEquals("{\n" +
                "  \"id\": 501\n" +
                "}",apiResponse.asString());
    }

    @Test
    public void checkStatusValidRequest1(){
        RestHandler restHandler = new RestHandlerImp();
        Assert.assertEquals(200,restHandler.sendCustomGetRequest("https://jsonplaceholder.typicode.com/users").getStatusCode());
    }

    @Test
    public void checkStatusValidRequest2(){
        RestHandler restHandler = new RestHandlerImp();
        Assert.assertEquals(200,restHandler.sendCustomGetRequest("https://jsonplaceholder.typicode.com/comments").getStatusCode());
    }

    @Test
    public void checkStatusValidRequest3(){
        RestHandler restHandler = new RestHandlerImp();
        Assert.assertEquals(200,restHandler.sendCustomGetRequest("https://jsonplaceholder.typicode.com/posts").getStatusCode());
    }

    @Test
    public void checkStatusValidRequest4(){
        RestHandler restHandler = new RestHandlerImp();
        PropertyLoader propertyLoader = new PropertyLoader();
        Assert.assertEquals(200,restHandler.sendCustomGetRequest(propertyLoader.getRestMainUrl()+propertyLoader.getRestUrlUsers()).getStatusCode());
    }

    @Test
    public void checkStatusValidRequest5(){
        RestHandler restHandler = new RestHandlerImp();
        PropertyLoader propertyLoader = new PropertyLoader();
        Assert.assertEquals(200,restHandler.sendCustomGetRequest(propertyLoader.getRestMainUrl()+propertyLoader.getRestUrlComments()).getStatusCode());
    }

    @Test
    public void checkStatusValidRequest6(){
        RestHandler restHandler = new RestHandlerImp();
        PropertyLoader propertyLoader = new PropertyLoader();
        Assert.assertEquals(200,restHandler.sendCustomGetRequest(propertyLoader.getRestMainUrl()+propertyLoader.getRestUrlPosts()).getStatusCode());
    }

}
