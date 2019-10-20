package com.apex.webservices.response;

import java.util.Arrays;

import org.apache.http.Header;

public class RestResponse {
private int statusCode;
private String resonPhrase;
private String responseBody;
private Header[] headers;
public int getStatusCode() {
	return statusCode;
}
public String getResonPhrase() {
	return resonPhrase;
}
public String getResponseBody() {
	return responseBody;
}
public Header[] getHeaders() {
	return headers;
}
public RestResponse(int statusCode, String resonPhrase, String responseBody, Header[] headers) {
	super();
	this.statusCode = statusCode;
	this.resonPhrase = resonPhrase;
	this.responseBody = responseBody;
	this.headers = headers;
}
@Override
public String toString() {
	return "RestResponse [statusCode=" + statusCode + ", resonPhrase=" + resonPhrase + ", responseBody=" + responseBody
			+ ", headers=" + Arrays.toString(headers) + "]";
}

}
