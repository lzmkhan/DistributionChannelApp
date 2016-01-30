package com.example.arihantdistributors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		
		
		 Button login = (Button) findViewById(R.id.login_btn);
			login.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						//login functionality will come here
						Intent i = new Intent(Login_Activity.this,MainActivity.class);
						startActivity(i);    
					}

				
					
			});
			
			
			 Button Signup = (Button) findViewById(R.id.signup_btn);
				Signup.setOnClickListener(new OnClickListener(){
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							
							//signup screen should be called here. preferably fragment.
							Intent i = new Intent(Login_Activity.this, SignupActivity.class);
							startActivity(i);    
						}

					
						
				});
				
			
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	 public void forgot_password(View v) {
		 //do the forgot password activity

			Intent i = new Intent(Login_Activity.this, FrgtPswrdActivity.class);
			startActivity(i);         
       }  
	
}
