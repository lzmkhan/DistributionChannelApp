package com.example.arihantdistributors;
import java.util.*;

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
	
	public boolean sendOTP()
	{
		boolean status = false;
		//WebServiceHandler wsHandler = new WebServiceHandler();
	
		
		//status = sendOTPtoSMS(Info_Store.getInstance().AccountID, OTPHolder);
		return status;
	}
	
	public boolean compareOTP(String input)
	{
		if(OTPHolder.equals(input))
			return true;
		else
			return false;
	}
	
}
