package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private String restMainUrl;
    private String restUrlPosts;
    private String restUrlComments;
    private String restUrlUsers;

    public PropertyLoader(){
        FileInputStream fis = null;
        Properties prop = null;

        try {
            fis = new FileInputStream("application.properties");
            prop = new Properties();
            prop.load(fis);
            this.restMainUrl = prop.getProperty("rest.url.main");
            this.restUrlPosts = prop.getProperty("rest.url.posts");
            this.restUrlComments = prop.getProperty("rest.url.comments");
            this.restUrlUsers = prop.getProperty("rest.url.user");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRestMainUrl() {
        return restMainUrl;
    }

    public String getRestUrlPosts() {
        return restUrlPosts;
    }

    public String getRestUrlComments() {
        return restUrlComments;
    }

    public String getRestUrlUsers() {
        return restUrlUsers;
    }
}
