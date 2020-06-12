package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CommentObject {

    @JsonProperty("postId")
    private String postId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("body")
    private String body;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentObject)) return false;
        CommentObject that = (CommentObject) o;
        return Objects.equals(postId, that.postId) &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, id, name, email, body);
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
