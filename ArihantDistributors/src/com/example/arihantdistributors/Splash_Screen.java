package com.example.arihantdistributors;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends Activity {

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
				

				
				Intent i = new Intent(Splash_Screen.this, Login_Activity.class);
				startActivity(i);

				// close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

	
   

}

