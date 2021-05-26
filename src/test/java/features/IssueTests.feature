Feature: Verify different tests for JIRA issue

Scenario: Verify issue is being created successfully
	Given AddIssueAPI payload for issue type "Bug"
	When "AddIssueAPI" is called with "POST" http method
	Then Status Code should be 201
	
Scenario: Get Details of an issue
	Given GetIssueDetailsAPI payload for Issue Key "MYF-6"
	When "GetIssueAPI" is called with "GET" http method
 	Then Status Code should be 200
	
Scenario: Verify comment is being added in issue successfully
	Given AddCommentAPI payload for issue key "MYF-6"
 	When "AddCommentAPI" is called with "POST" http method
 	Then Status Code should be 201

Scenario: Verify comment is being updated
	Given UpdateCommentAPI payload for issue key "MYF-6" & CommentID 10012
	When "UpdateCommentAPI" is called with "PUT" http method	
 	Then Status Code should be 200

Scenario: Verify comment is being deleted in issue
	Given DeleteCommetnAPI payload for issue key "MYF-6" & CommentID 10012
	When "DeleteCommentAPI" is called with "DELETE" http method	
 	Then Status Code should be 204

@Test 	
Scenario: Verify attachment is being added in issue successfully
 	Given AddAttachmentAPI payload for issue key "MYF-6"
 	When "AddAttachmentAPI" is called with "POST" http method
 	Then Status Code should be 200