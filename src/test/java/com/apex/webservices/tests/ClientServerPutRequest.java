package com.apex.webservices.tests;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.webservices.base.ClientServerBaseClass;
import com.apex.webservices.base.CustomerServiceaConstant;

public class ClientServerPutRequest implements CustomerServiceaConstant {

	@Test
	public void clientServerPutRquest() throws ClientProtocolException, IOException {
		HttpResponse response = ClientServerBaseClass.putRequestResponse(BASEURL,PUT_REQUEST_MESSAGE);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 201);
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(), "OK");
	}
}
