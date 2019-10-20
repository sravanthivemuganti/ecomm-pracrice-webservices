package com.apex.webservices.base;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.apex.webservices.response.RestResponse;

public class ClientServerBaseClass {

	public static RestResponse getRequestResponse(String url) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response= client.execute(request);
		ResponseHandler<String> body = new BasicResponseHandler();
		Header[] headers=response.getAllHeaders();		
		RestResponse restResponse=new RestResponse(response.getStatusLine().getStatusCode(), 
				response.getStatusLine().getReasonPhrase(),body.handleResponse(response) , headers);
		return restResponse;
	}
	public static CloseableHttpResponse UsingCloseableHttpClient_getRequestResponse(String url) throws ClientProtocolException, IOException {
		
			CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		CloseableHttpResponse response= client.execute(request);
		return response;	
	}
	
	public static HttpResponse postRequestResponse(String url,String requestMessage) throws ClientProtocolException, IOException {
		HttpClient client =HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		request.addHeader("Authorization","Basic dmdzOnZncw==");
		request.addHeader("Content-Type", "application/xml");
		request.addHeader("Accept", "application/xml");
		StringEntity stringEntity = new StringEntity(requestMessage,ContentType.APPLICATION_XML);
		request.setEntity(stringEntity);
		return client.execute(request);
		
	}
	public static HttpResponse putRequestResponse(String url,String requestMessage) throws ClientProtocolException, IOException {
		HttpClient client =HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		StringEntity stringEntity = new StringEntity(requestMessage);
		request.setEntity(stringEntity);
		return client.execute(request);
	}
	public static HttpResponse deleteRequestResponse(String url) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		return client.execute(request);
	}
}
