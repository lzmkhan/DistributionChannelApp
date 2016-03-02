package com.example.arihantdistributors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends Activity {

	Context c = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);
		
		ActionBar ab = getActionBar();
		ab.hide();
		 Button login = (Button) findViewById(R.id.login_btn);
			login.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						//login functionality will come here
						
						EditText ed1 = (EditText) findViewById(R.id.txtUsername);
					String	username = ed1.getText().toString().trim();
					
					EditText ed2 = (EditText) findViewById(R.id.txtPassword);
						String password = ed2.getText().toString().trim();
						
						if(!username.equals(""))
						{
							
							if(!password.equals(""))
							{
								
							
						String query = "SELECT a.Username, a.Account_Type, b.MobileNo, b.Name, b.Street_1, b.Street_2, b.Area, b.City, b.District, b.State, b.Pincode, b.Email, b.Account_ID FROM accounts a JOIN acc_user_info b ON a.Username = b.MobileNo WHERE a.Username = '"+ username +"' AND a.Password = '"+ password +"'";
						
						 WebserviceHandler wb = new WebserviceHandler(8); //setup login()
							if(isOnline())
							{
							wb.query =query;
							wb.set_context(c);
							wb.execute();
							}
						    else
							{
								Toast.makeText(getApplicationContext(), "No Internet connection!", Toast.LENGTH_SHORT).show();
							}
							}
							else
							{
								Toast.makeText(getApplicationContext(), "Password field cannot be empty!", Toast.LENGTH_SHORT).show();
							}
						}
						else
						{
							Toast.makeText(getApplicationContext(), "TIN/Mobile number cannot be empty!", Toast.LENGTH_SHORT).show();
						}
					//	call_Main();
						    
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

	
	public void call_Main()
	{
		//calling main activity when login succeeds
		Intent i = new Intent(Login_Activity.this,MainActivity.class);
		i.putExtra("mode", 0 );
		startActivity(i);
		finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 public  boolean isOnline() {
		  ConnectivityManager connectivityManager  = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		  NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		  return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
