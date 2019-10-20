package com.apex.webservices.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.BasicResponseHandler;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.apex.webservices.base.ClientServerBaseClass;
import com.apex.webservices.base.CustomerServiceaConstant;
import com.apex.webservices.response.RestResponse;

public class ClientServerGetRequest extends ClientServerBaseClass implements CustomerServiceaConstant{
	
	
	
	SoftAssert sAssert=new SoftAssert();
	@Test
	public void testGetSuccessData() throws ClientProtocolException, IOException {
		
		RestResponse response = ClientServerBaseClass.getRequestResponse(BASEURL+"/3");
		System.out.println(response.toString());
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		/*
		 * Assert.assertEquals("<?xml version=\"1.0\" standalone=\"no\"?>\r\n" +
		 * "<CUSTOMER xmlns:xlink=\"http://www.w3.org/1999/xlink\">\r\n" +
		 * "    <ID>3</ID>\r\n" + "    <FIRSTNAME>Michael</FIRSTNAME>\r\n" +
		 * "    <LASTNAME>Clancy</LASTNAME>\r\n" +
		 * "    <STREET>542 Upland Pl.</STREET>\r\n" +
		 * "    <CITY>San Francisco</CITY>\r\n" + "</CUSTOMER>",
		 * response.getResponseBody());
		 */
		Map<String,String> headersSet=new HashMap<String,String>();
		for (Header header : response.getHeaders()) {
			headersSet.put(header.getName(),header.getValue());
		}
		Set<String> keys = headersSet.keySet();
		for (String c : keys) {
			if(c.equalsIgnoreCase("Server"))
				Assert.assertEquals(headersSet.get(c), "Apache-Coyote/1.1");
			if(c.equalsIgnoreCase("Content-Type"))
				Assert.assertEquals(headersSet.get(c), "application/xml");
			if(c.equalsIgnoreCase("Content-Length"))
				Assert.assertEquals(headersSet.get(c), "242");
		}		 
	}
	@Test
	public void testGetSuccessData_Using_Closeableresponse() throws ClientProtocolException, IOException {
		
		CloseableHttpResponse response = ClientServerBaseClass.UsingCloseableHttpClient_getRequestResponse(BASEURL+"/1");
		Header[] headers=response.getAllHeaders();
		for (int i = 0; i < headers.length; i++) {
			System.out.println(headers[i]);
		}
		sAssert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
		sAssert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");
		ResponseHandler<String> body = new BasicResponseHandler();
		String getBody =  body.handleResponse(response);
		System.out.println(getBody);
	}
	
	
	  @Test public void testGetNotExistingData() throws ClientProtocolException,IOException {
	  RestResponse response=ClientServerBaseClass.getRequestResponse(BASEURL+"/100");
	  System.out.println(response.toString());
	  }
	 
}
