package com.apex.webservices.tests;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.webservices.base.ClientServerBaseClass;
import com.apex.webservices.base.CustomerServiceaConstant;

public class ClientServerPostRequest extends ClientServerBaseClass implements CustomerServiceaConstant {

	@Test
	public void clientServerPostRequest() throws ClientProtocolException, IOException {
		HttpResponse response =  ClientServerBaseClass.postRequestResponse(BASEURL, REQUEST_MESSAGE);
		Header[] headers=response.getAllHeaders();
		for (int i = 0; i < headers.length; i++) {
			System.out.println(headers[i]);
		}
		Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Created");
	}
	@Test
	public void clientServerPostRequestError() throws ClientProtocolException, IOException {
		HttpResponse response =  ClientServerBaseClass.postRequestResponse(BASEURL, REQUEST_MESSAGE);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 500);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Internal Server Error");
		
	}
}
