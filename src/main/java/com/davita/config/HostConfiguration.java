/**
 * Grace Tshihata
 * */

package com.davita.config;

public class HostConfiguration {

	/**
	 * replace all the start *** with your company version 1 urls it can looks
	 * like this i.e: https://www15.v1host.com/mycompany
	 * 
	 */
	public static String YOUR_COMPANY_HOST_URL = "***************";
	
	
	// Your VersionOne UserName and Password here
	/**
	 * make sure you are and Admin in you versionOne change your username and
	 * password here: Delete the **** and replace with your credentials.
	 */
	public static String AuthUserName = "****";
	public static String AuthPassWord = "*****";

	
	/**
	 * make sure to do note change this as the bellow are the queries that is applied 
	 * to retrieve data from VersionOne
	 * You can always customized them*/
	public static String HostServerpost = "'&sel=Content,Author,AuthoredAt,BelongsTo.ChangeDate&sort=-BelongsTo.ChangeDate&page=10,0";

	// adding story server/queries
	public static String HostServerpreStory = YOUR_COMPANY_HOST_URL
			+ "/rest-1.v1/Data/Expression?where=BelongsTo.ContainedExpressions.Mentions:Story.Number='";
	// adding Task 'TK' server/queries
	public static String HostServerpreTask = YOUR_COMPANY_HOST_URL
			+ "/rest-1.v1/Data/Expression?where=BelongsTo.ContainedExpressions.Mentions:Task.Number='";
	// adding Defect'D' server/queries
	public static String HostServerpreDefect = YOUR_COMPANY_HOST_URL
			+ "/rest-1.v1/Data/Expression?where=BelongsTo.ContainedExpressions.Mentions:Defect.Number='";
	// adding Test 'AT' server/queries
	public static String HostServerpreTest = YOUR_COMPANY_HOST_URL
			+ "/rest-1.v1/Data/Expression?where=BelongsTo.ContainedExpressions.Mentions:Test.Number='";
	// adding Epic 'E' server/queries
	public static String HostServerpreEpic = YOUR_COMPANY_HOST_URL
			+ "rest-1.v1/Data/Expression?where=BelongsTo.ContainedExpressions.Mentions:Epic.Number='";

	
	

}
