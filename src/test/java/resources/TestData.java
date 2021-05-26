package resources;

public class TestData {
	
	Payloads p = new Payloads();
	
	public String getAddIssueTestData()
	{
		String summary = "This is summary of issue";
		int issuetypeID = 10004;
		int projectID = 10000;
		String description = "This is description of issue";
		String reporter = "609e1a30391e56006e14028e";
		String assignee = "609e1a30391e56006e14028e";		
		return p.addIssuePayload(summary, issuetypeID, projectID, description, reporter, assignee);
	}
	
	public String getAddCommentTestData()
	{
		String comment = "This is a test comment";
		return p.addCommentPayload(comment);
	}
	
	public String getUpdatedCommentTestData()
	{
		String comment = "This is updated test comment";
		return p.updateCommentPayload(comment);
	}

}
