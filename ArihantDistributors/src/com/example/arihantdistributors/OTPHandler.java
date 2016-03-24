package com.example.arihantdistributors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class OTPHandler {

	public String OTPHolder ="";
	
	
	public void generateOTP()
	{
		Random r = new Random();
	    String OTP = new String("" + r.nextInt(9));
		OTP = new String(OTP + r.nextInt(9));
		OTP = new String(OTP + r.nextInt(9));
		OTP = new String(OTP + r.nextInt(9));
		OTPHolder = new String(OTP);
	}
	
	public boolean sendOTP(Context c, int mode)
	{
		boolean status = false;
	
		MyPostByPHP mp = new MyPostByPHP();
		if(mode==1)
		{
			mp.mode=1;
		}
				mp.execute();

		return status;
	}
	
	public boolean compareOTP(String input)
	{
		if(OTPHolder.equals(input))
			return true;
		else
			return false;
	}
	
	
	private class MyPost extends AsyncTask<Void, Void, Void> 
	{
	    @SuppressWarnings("deprecation")
		@Override
	    protected Void doInBackground(Void... arg0) 
	    {
	      
	     //Your authentication key
	       String authkey = "";
	       //Multiple mobiles numbers separated by comma
	       if(Info_Store.getInstance().Mobile.equals("") || Info_Store.getInstance().Mobile.equals("None"))
	    	   Info_Store.getInstance().Mobile = TempData.getInstance().number;
	       String mobiles = "91" + Info_Store.getInstance().Mobile;
	       //Sender ID,While using route4 sender id should be 6 characters long.
	       String senderId = "MARCUS";
	       //Your message to send, Add URL encoding here.
	       String message = "Your OTP is " + OTPHolder;
	       //define route
	       String route="4";

	       URLConnection myURLConnection=null;
	       URL myURL=null;
	       BufferedReader reader=null;

	       //encoding message 
	       String encoded_message=URLEncoder.encode(message);

	       //Send SMS API
	       String mainUrl="https://control.msg91.com/api/sendhttp.php?";

	       //Prepare parameter string 
	       StringBuilder sbPostData= new StringBuilder(mainUrl);
	       sbPostData.append("authkey="+authkey); 
	       sbPostData.append("&mobiles="+mobiles);
	       sbPostData.append("&message="+encoded_message);
	       sbPostData.append("&route="+route);
	       sbPostData.append("&sender="+senderId);

	       //final string
	       mainUrl = sbPostData.toString();
	       try
	       {
	           //prepare connection
	           myURL = new URL(mainUrl);
	           myURLConnection = myURL.openConnection();
	           myURLConnection.connect();
	           reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
	           
	           //reading response 
	           String response;
	           while ((response = reader.readLine()) != null) 
	           //print response 
	           Log.d("RESPONSE", ""+response);
	           
	           
	           //finally close connection
	           reader.close();
	       } 
	       catch (IOException e) 
	       { 
	       	e.printStackTrace();
	       }
		return null; 

	    }
	}
	
	
	private class MyPostByPHP extends AsyncTask<Void, Void, Void> 
	{
		
		int mode =0;
	    @SuppressWarnings("deprecation")
		@Override
	    protected Void doInBackground(Void... arg0) 
	    {
	      
	       if(Info_Store.getInstance().Mobile.equals("") || Info_Store.getInstance().Mobile.equals("None"))
	    	   Info_Store.getInstance().Mobile = TempData.getInstance().number;
	       String mobiles =  Info_Store.getInstance().Mobile;
	       //Sender ID,While using route4 sender id should be 6 characters long.
	    
	       //Your message to send, Add URL encoding here.
	       String message = "Your OTP is " + OTPHolder;


	       URLConnection myURLConnection=null;
	       URL myURL=null;
	       BufferedReader reader=null;

	       //encoding message 
	       String encoded_message=URLEncoder.encode(message);
	       String mainUrl;
	       //Send SMS API
	       if(mode==0)
	       {
	    	   mainUrl ="http://autestdomain.comule.com/Arihantwebservices/otp.php?";
	       }
	       else
	       {
	    	   mainUrl ="http://autestdomain.comule.com/Arihantwebservices/otp_sign.php?";
	       }
	       //Prepare parameter string 
	       StringBuilder sbPostData= new StringBuilder(mainUrl);
	        
	       sbPostData.append("phone="+mobiles);
	       sbPostData.append("&otp="+encoded_message);
	       
	       //final string
	       mainUrl = sbPostData.toString();
	       try
	       {
	           //prepare connection
	           myURL = new URL(mainUrl);
	           myURLConnection = myURL.openConnection();
	           myURLConnection.connect();
	           reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
	           
	           //reading response 
	           String response;
	           while ((response = reader.readLine()) != null) 
	           //print response 
	           Log.d("RESPONSE", ""+response);
	           
	           
	           //finally close connection
	           reader.close();
	       } 
	       catch (IOException e) 
	       { 
	       	e.printStackTrace();
	       }
		return null; 

	    }
	}

}
