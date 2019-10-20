package com.apex.webservices.base;

public interface CustomerServiceaConstant {

	String BASEURL="http://www.thomas-bayer.com/sqlrest/CUSTOMER";
	String REQUEST_MESSAGE="<?xml version=\"1.0\" standalone=\"no\"?>\r\n" + 
			"<CUSTOMER xmlns:xlink=\"http://www.w3.org/1999/xlink\">\r\n" + 
			"    <ID>100</ID>\r\n" + 
			"    <FIRSTNAME>Susanne</FIRSTNAME>\r\n" + 
			"    <LASTNAME>King</LASTNAME>\r\n" + 
			"    <STREET>366 - 20th Ave.</STREET>\r\n" + 
			"    <CITY>Olten</CITY>\r\n" + 
			"</CUSTOMER>";
	String PUT_REQUEST_MESSAGE="<?xml version=\"1.0\" standalone=\"no\"?>\r\n" + 
			"<CUSTOMER xmlns:xlink=\"http://www.w3.org/1999/xlink\">\r\n" + 
			"    <ID>100</ID>\r\n" + 
			"    <FIRSTNAME>John</FIRSTNAME>\r\n" + 
			"    <LASTNAME>King</LASTNAME>\r\n" + 
			"    <STREET>366 - 20th Ave.</STREET>\r\n" + 
			"    <CITY>Texas</CITY>\r\n" + 
			"</CUSTOMER>";
}
