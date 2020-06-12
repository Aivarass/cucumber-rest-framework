package cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.UserObject;
import org.junit.Assert;
import rest.RestHandler;
import rest.RestHandlerImp;

import java.util.HashMap;
import java.util.Map;

public class UserGlue {

    static Map<String,UserObject> userMap = new HashMap<>();
    static UserObject user;


    @Given("^I get all user data from /user endpoint$")
    public void apiGetUserData(){
        RestHandler restHandler = new RestHandlerImp();
        this.userMap = restHandler.listOfUsers();
    }

    @When("^I get user data for id: (.*?)$")
    public void getObjectById(String key){
        this.user = userMap.get(key);
    }

    @Then("^I assert the following values in the api response:$")
    public void assertResponseObject(DataTable dataTable){
        Map<String,String> assertionMap = dataTable.asMap(String.class,String.class);
        Assert.assertEquals(assertionMap.get("id"),String.valueOf(user.getId()));
        Assert.assertEquals(assertionMap.get("username"),user.getUsername());
        Assert.assertEquals(assertionMap.get("name"),user.getName());
        Assert.assertEquals(assertionMap.get("email"),user.getEmail());
        Assert.assertEquals(assertionMap.get("phone"),user.getPhone());
        Assert.assertEquals(assertionMap.get("website"),user.getWebsite());
        Assert.assertEquals(assertionMap.get("address"),user.getAdditionalProperties().get("address").toString());
    }

}
