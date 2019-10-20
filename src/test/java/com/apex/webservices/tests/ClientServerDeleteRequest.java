package com.apex.webservices.tests;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.webservices.base.ClientServerBaseClass;
import com.apex.webservices.base.CustomerServiceaConstant;

public class ClientServerDeleteRequest implements CustomerServiceaConstant {
	
	@Test
	public void clientServerDeleteRequest() throws ClientProtocolException, IOException {
		HttpResponse response= ClientServerBaseClass.deleteRequestResponse(BASEURL+"/100");
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");
	}
	@Test
	public void clientServerDeleteRequestNotExisting() throws ClientProtocolException, IOException {
		HttpResponse response= ClientServerBaseClass.deleteRequestResponse(BASEURL+"/100");
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");
	}

}
