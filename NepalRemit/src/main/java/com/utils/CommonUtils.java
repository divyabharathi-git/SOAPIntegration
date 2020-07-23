package com.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CommonUtils {
	
	public static Document parseXmlFile(String outputString) throws ParserConfigurationException, SAXException, IOException {
		 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = dbf.newDocumentBuilder();
	      InputSource is = new InputSource(new StringReader(outputString));
	      return db.parse(is);
	}

	public static String createConnection(String wsUrl,String xmlInput) {
		String responseString = "";
		String outputString = "";
		URL url;
		try {
			url = new URL(wsUrl);
		
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		
		httpConn.setRequestProperty("Content-Length",
		String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();
		out.write(b);
		out.close();
		
		InputStreamReader isr =
		new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		
		while ((responseString = in.readLine()) != null) {
			outputString = outputString + responseString;
					}
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputString;

		
	}

}
