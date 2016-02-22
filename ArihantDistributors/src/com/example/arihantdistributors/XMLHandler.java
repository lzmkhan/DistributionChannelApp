package com.example.arihantdistributors;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;

public class XMLHandler {

	
	
	
	public List<String> parseXML(String Source) throws XmlPullParserException, IOException
	{
		List<String> contents = new ArrayList<String>();
		
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	     factory.setNamespaceAware(true);
	     XmlPullParser xpp = factory.newPullParser();

	     xpp.setInput( new StringReader ( Source ) );
	     int eventType = xpp.getEventType();
	     while (eventType != XmlPullParser.END_DOCUMENT) {
	      if(eventType == XmlPullParser.START_TAG) {
	    	
	      } else if(eventType == XmlPullParser.END_TAG) {
	       
	      } else if(eventType == XmlPullParser.TEXT) {
	        contents.add(xpp.getText());
	        
	     
	      }
	      eventType = xpp.next();
	     }
	
		
		return contents;
		
	}
	
	public String makeXMLFromInfoStore()
	{
		
		
		StringBuilder Contents = new StringBuilder();

		
		Contents.append("<AccountID>");
		Contents.append(Info_Store.getInstance().AccountID);
		Contents.append("</AccountID>");
		Contents.append("<Name>");
		Contents.append(Info_Store.getInstance().Name);
		Contents.append("</Name>");
		Contents.append("<Street_1>");
		Contents.append(Info_Store.getInstance().Street_1);
		Contents.append("</Street_1>");
		Contents.append("<Street_2>");
		Contents.append(Info_Store.getInstance().Street_2);
		Contents.append("</Street_2>");
		Contents.append("<Area>");
		Contents.append(Info_Store.getInstance().Area);
		Contents.append("</Area>");
		Contents.append("<City>");
		Contents.append(Info_Store.getInstance().City);
		Contents.append("</City>");
		Contents.append("<District>");
		Contents.append(Info_Store.getInstance().District);
		Contents.append("</District>");
		Contents.append("<State>");
		Contents.append(Info_Store.getInstance().State);
		Contents.append("</State>");
		Contents.append("<Pincode>");
		Contents.append(Info_Store.getInstance().Pincode);
		Contents.append("</Pincode>");
		Contents.append("<Mobile>");
		Contents.append(Info_Store.getInstance().Mobile);
		Contents.append("</Mobile>");
		Contents.append("<Email>");
		Contents.append(Info_Store.getInstance().Email);
		Contents.append("</Email>");
		
		return Contents.toString();
	}
	
	public String makeXML(List<String> input)
	{
		
		
		StringBuilder Contents = new StringBuilder();

		for(int i =0 ; i < input.size(); i++)
		{
		Contents.append("<Item" + i + ">");
		Contents.append(input.get(i));
		Contents.append("</Item" + i + ">");
		}
		
		return Contents.toString();
	}
	
}
