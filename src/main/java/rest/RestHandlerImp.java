package rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import model.CommentObject;
import model.UserObject;
import utils.PropertyLoader;

import java.util.HashMap;
import java.util.Map;

public class RestHandlerImp implements RestHandler {

    private PropertyLoader prop;

    public RestHandlerImp(){
        this.prop = new PropertyLoader();
    }

    @Override
    public Response makePost(String post) {
        return RestAssured.given().header(new Header("application/json","charset=UTF-8")).body(post).post(prop.getRestMainUrl()+prop.getRestUrlPosts());
    }

    @Override
    public Response makeComment(String comment) {
        return RestAssured.given().header(new Header("application/json","charset=UTF-8")).body(comment).post(prop.getRestMainUrl()+prop.getRestUrlComments());
    }

    @Override
    public Map<String, CommentObject> getCommentsForId(String postId) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,CommentObject> commentMap = new HashMap<>();
        try {
            mapper.readTree(sendCustomGetRequest(prop.getRestMainUrl()+prop.getRestUrlComments()+"?postId="+postId).getBody().asString()).forEach(s -> {
                try {
                    commentMap.put(s.findValue("id").toString(),mapper.treeToValue(s,CommentObject.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return commentMap;
    }


    @Override
    public Map<String, UserObject> listOfUsers()  {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,UserObject> userMap = new HashMap<>();
        try {
            mapper.readTree(sendCustomGetRequest(prop.getRestMainUrl()+prop.getRestUrlUsers()).getBody().asString()).forEach(s -> {
                try {
                    userMap.put(s.findValue("id").toString(),mapper.treeToValue(s,UserObject.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userMap;
    }

    @Override
    public Response sendCustomGetRequest(String url) {
        return RestAssured.get(url);
    }
}
