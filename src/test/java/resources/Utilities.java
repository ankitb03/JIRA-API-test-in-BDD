package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Utilities {
	
	PreemptiveBasicAuthScheme as;
	
	public String getPropertyValue(String propertyname) throws IOException
	{
		Properties p = new Properties();
		FileInputStream f = new FileInputStream("src/test/java/resources/config.properties");
		p.load(f);
		return p.getProperty(propertyname);
	}
	
	//method to return PreemptiveBasicAuthScheme object to authenticate all APIs
	public PreemptiveBasicAuthScheme authentication() throws IOException
	{
		as = new PreemptiveBasicAuthScheme();
		as.setUserName(getPropertyValue("username"));
		as.setPassword(getPropertyValue("password"));
		return as;		
	}
	
	public RequestSpecification requestbuilder() throws IOException
	{
		PrintStream ps = new PrintStream(new FileOutputStream("Log.txt"));
		RequestSpecification request = new RequestSpecBuilder().setBaseUri(this.getPropertyValue("baseURL")).setAuth(authentication()).addHeader("Content-Type", "application/json")
				.addFilter(RequestLoggingFilter.logRequestTo(ps)).addFilter(ResponseLoggingFilter.logResponseTo(ps)).build();
		return request;
	}
	
}
