package resources;

public enum APIResource {	
	
	AddIssueAPI("rest/api/3/issue"),
	GetIssueAPI("rest/api/3/issue/{IssueKey}"),
	AddCommentAPI("rest/api/3/issue/{key}/comment"),
	UpdateCommentAPI("rest/api/3/issue/{IssueKey}/comment/{commentID}"),
	DeleteCommentAPI("rest/api/3/issue/{IssueKey}/comment/{commentID}"),
	AddAttachmentAPI("rest/api/3/issue/{IssueKey}/attachments");
	
	private String resource;
	
	APIResource(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
		
}
