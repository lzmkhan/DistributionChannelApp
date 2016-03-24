package com.example.arihantdistributors;


import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class Splash_Screen extends Activity {

	Context c = this; 
	// Splash screen timer
	private static int SPLASH_TIME_OUT = 1500;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		ActionBar ab = getActionBar();
		ab.hide();
		new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity
				
				/* if contact already saved  = true
				 * do nothing
				 * else
				 * save contact
				 */
				try{
					XMLHandler xml = new XMLHandler();
					FileHandler file1 = new FileHandler();
					file1.c = c;
					List<String> list = xml.parseXML(file1.readFromFile("usrinfo"));
					Info_Store.getInstance().AccountID =list.get(0);
					
					Info_Store.getInstance().Area=list.get(4);
					Info_Store.getInstance().City=list.get(5);
					Info_Store.getInstance().District=list.get(6);
					Info_Store.getInstance().Email=list.get(10);
					Info_Store.getInstance().Mobile=list.get(9);
					Info_Store.getInstance().Name=list.get(1);
					Info_Store.getInstance().Pincode=list.get(8);
					Info_Store.getInstance().State=list.get(7);
					Info_Store.getInstance().Street_1=list.get(2);
					Info_Store.getInstance().Street_2=list.get(3);
				
				}catch(Exception e)
				{
					Log.d("splash screen",e.toString());
				}

				if(Info_Store.getInstance().AccountID.equals("None") || Info_Store.getInstance().AccountID.equals(""))
				{
				Intent i = new Intent(Splash_Screen.this, Login_Activity.class);
				startActivity(i);
				}
				else
				{
					Intent i = new Intent(Splash_Screen.this, MainActivity.class);
					i.putExtra("mode", 0 );
					startActivity(i);
				}
				
				// close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

	
   

}

