package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResource;
import resources.TestData;
import resources.Utilities;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;

public class IssueTestsStepDefinations extends Utilities{
	
	RequestSpecification req;
	Response response;
	TestData data = new TestData();
	
	@Given("AddIssueAPI payload for issue type {string}")
	public void addissueapi_payload_for_issue_type(String string) throws IOException 
	{
		req = given().spec(requestbuilder()).body(data.getAddIssueTestData());					
	}
	
	
	@Given("AddCommentAPI payload for issue key {string}")
	public void AddCommentAPI_payload_for_issue_key(String APIresource, String IssueKey ) throws IOException 
	{
		req = given().spec(requestbuilder().pathParam("key", IssueKey)).body(data.getAddCommentTestData());		
	}
	
	
	@Given("UpdateCommentAPI payload for issue key {string} & CommentID {int}")
	public void UpdateCommentAPI_payload_for_issue_key_CommentID(String issueKey, Integer commentID) throws IOException {
		req = given().spec(requestbuilder()).pathParam("IssueKey", issueKey).pathParam("commentID", commentID).body(data.getUpdatedCommentTestData());
	}
	
	
	@Given("{string} payload for {string} & {string}")
	public void payload_for(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	@Given("GetIssueDetailsAPI payload for Issue Key {string}")
	public void getissuedetailsapi_payload_for_Issue_Key(String issueKey) throws IOException {
	    req = given().spec(requestbuilder()).pathParam("IssueKey", issueKey);
	}
	
	
	@Given("DeleteCommetnAPI payload for issue key {string} & CommentID {int}")
	public void deletecommetnapi_payload_for_issue_key_CommentID(String issueKey, Integer commentID) throws IOException {
		req = given().spec(requestbuilder()).pathParam("IssueKey", issueKey).pathParam("commentID", commentID);
	 
	}
	
	
	@Given("AddAttachmentAPI payload for issue key {string}")
	public void addattachmentapi_payload_for_issue_key(String issueKey) throws IOException {
	    req = given().spec(requestbuilder()).pathParam("IssueKey", issueKey).header("X-Atlassian-Token","no-check").header("Content-Type","multipart/form-data")
	    		.multiPart(new File("TestFile.txt"));
	}
	

	@When("{string} is called with {string} http method")
	public void is_called_with_http_method(String APIresource, String httpmethod) 
	{
		
		APIResource resourceCalled = APIResource.valueOf(APIresource);
		
		if(httpmethod.equalsIgnoreCase("POST"))
		{
			System.out.println("POST method called on -"+resourceCalled.getResource());
			response = req.when().post(resourceCalled.getResource()).then().extract().response(); //resourceCalled is an ENUM which is returning API resourse from ENUM class 'APIResource'
		}
		
		else if(httpmethod.equalsIgnoreCase("GET"))
		{	
			System.out.println("GET method called on -"+resourceCalled.getResource());
			response = req.when().get(resourceCalled.getResource()).then().extract().response(); //resourceCalled is an ENUM which is returning API resourse from ENUM class 'APIResource'
		}
		
		else if(httpmethod.equalsIgnoreCase("PUT"))
		{
			System.out.println("PUT method called on -"+resourceCalled.getResource());
			response = req.when().put(resourceCalled.getResource()).then().extract().response(); //resourceCalled is an ENUM which is returning API resourse from ENUM class 'APIResource'
		}
		
		else if(httpmethod.equalsIgnoreCase("DELETE"))
		{
			System.out.println("Delete method called on -"+resourceCalled.getResource());
			response = req.when().delete(resourceCalled.getResource()).then().extract().response(); //resourceCalled is an ENUM which is returning API resourse from ENUM class 'APIResource'
		}
		
	}

	@Then("Status Code should be {int}")
	public void status_Code_should_be(int statuscodeexpected) 
	{
		Assert.assertEquals(statuscodeexpected, response.getStatusCode());

	}

}
