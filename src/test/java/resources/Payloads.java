package resources;

public class Payloads {
	
	public String addIssuePayload(String summary, int issuetypeID, int projectID, String description, String reporter, String assignee)
	{
		return("{\r\n" + 
				"  \"fields\": {\r\n" + 
				"    \"summary\": \""+summary+"\",\r\n" + 
				"    \"issuetype\": {\r\n" + 
				"      \"id\": \""+issuetypeID+"\"\r\n" + 
				"    },\r\n" + 
				"    \"project\": {\r\n" + 
				"      \"id\": \""+projectID+"\"\r\n" + 
				"    },\r\n" + 
				"    \"description\": {\r\n" + 
				"      \"type\": \"doc\",\r\n" + 
				"      \"version\": 1,\r\n" + 
				"      \"content\": [\r\n" + 
				"        {\r\n" + 
				"          \"type\": \"paragraph\",\r\n" + 
				"          \"content\": [\r\n" + 
				"            {\r\n" + 
				"              \"text\": \""+description+"\",\r\n" + 
				"              \"type\": \"text\"\r\n" + 
				"            }\r\n" + 
				"          ]\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    \"reporter\": {\r\n" + 
				"      \"id\": \""+reporter+"\"\r\n" + 
				"    },\r\n" + 
				"\r\n" + 
				"    \"assignee\": {\r\n" + 
				"      \"id\": \""+assignee+"\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}");
	}
	
	public String addCommentPayload(String comment)
	{
		return("{\r\n" + 
				"  \"body\": {\r\n" + 
				"    \"type\": \"doc\",\r\n" + 
				"    \"version\": 1,\r\n" + 
				"    \"content\": [\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"paragraph\",\r\n" + 
				"        \"content\": [\r\n" + 
				"          {\r\n" + 
				"            \"text\": \""+comment+"\",\r\n" + 
				"            \"type\": \"text\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"}");
	}
	
	public String updateCommentPayload(String updatedComment)
	{
		return("{\r\n" + 
				"  \"body\": {\r\n" + 
				"    \"type\": \"doc\",\r\n" + 
				"    \"version\": 1,\r\n" + 
				"    \"content\": [\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"paragraph\",\r\n" + 
				"        \"content\": [\r\n" + 
				"          {\r\n" + 
				"            \"text\": \""+updatedComment+"\",\r\n" + 
				"            \"type\": \"text\"\r\n" + 
				"          }\r\n" + 
				"        ]\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"}");
	}
	
	
	

}
