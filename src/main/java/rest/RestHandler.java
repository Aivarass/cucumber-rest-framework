package rest;

import com.jayway.restassured.response.Response;
import model.CommentObject;
import model.UserObject;

import java.util.Map;

public interface RestHandler {

    Response makePost(String post);

    Response makeComment(String comment);

    Map<String, CommentObject> getCommentsForId(String postId);

    Map<String, UserObject> listOfUsers();

    Response sendCustomGetRequest(String url);
}
