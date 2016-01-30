package com.example.arihantdistributors;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FrgtPswrdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frgtpswrdcntinr);
		
		
		 FragmentManager fragmentManager = getFragmentManager();
	      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	      Forgetfragment fragment = new Forgetfragment();
	   
	         fragmentTransaction.replace(R.id.content_frame, fragment);				
		     fragmentTransaction.commit();
		

		
		
		
		
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
	
	private static class Forgetfragment extends Fragment
	{
		 EditText field1 ;
		public int fragNum = 1;
		TextView txt1;
		 View rootView;
		 @Override
		   public View onCreateView(LayoutInflater inflater,
		      ViewGroup container, Bundle savedInstanceState) {
		      /**
		       * Inflate the layout for this fragment
		       */
			 
			 
			
			 
			 
			 if(fragNum != 1)
			 {			 
			 rootView = inflater.inflate(R.layout.forgot_2, container,
						false);
			 
			 EditText field2 = (EditText)rootView.findViewById(R.id.editText2);
			  field1 = (EditText)rootView.findViewById(R.id.editText1);
			
			 field2.addTextChangedListener(new TextWatcher() {

				   @Override
				   public void afterTextChanged(Editable s) {}

				   @Override    
				   public void beforeTextChanged(CharSequence s, int start,
				     int count, int after) {
				   }

				   @Override    
				   public void onTextChanged(CharSequence s, int start,
				     int before, int count) {
				     String str = field1.getText().toString();
				     String str1 = s.toString();
				     Color c1 = new Color();
				      txt1 = (TextView)rootView.findViewById(R.id.brandCatTitle);
				     
				     /*
				      *The below if else condition checks if the password in Edittext1 matches with the 
				      * password in the EditText2.
				      * If it matches, it displays matches in green color.
				      * else it displays no match in red color.
				      * 
				      */
				     if(str.equals(str1))
				     {
				 
				    	 txt1.setText("Matches");
				    	 txt1.setTextColor(c1.GREEN);
				     }
				     else
				     {
				    	 txt1.setText("No Match");
				    	 txt1.setTextColor(c1.RED);
				     }
				     
				   }
				  });
			 }
			 else
			 {
				 rootView = inflater.inflate(R.layout.forgot_1, container,
							false);
				 
				 Button Reset = (Button)rootView.findViewById(R.id.btnPassReset);
				
				 
				 Reset.setOnClickListener(new OnClickListener(){
							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								
								//reset functionality will come here.
						    EditText ed1 = (EditText) rootView.findViewById(R.id.txtOTP);
							String enteredOTP = ed1.getText().toString();
							// The generated OTP is sent to Email. It is also Stored in OTP_Holder global in OTP_Handler class.
							String generatedOTP = "xxx";// need to assign it.
							
							if(generatedOTP.equals(enteredOTP))
							{
								 FragmentManager fragmentManager = getFragmentManager();
							      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
							      Forgetfragment fragment = new Forgetfragment();
							      fragment.fragNum=2;
							      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
							      fragmentTransaction.replace(R.id.content_frame, fragment);		
							        
								    fragmentTransaction.addToBackStack(null);
							         fragmentTransaction.commit();
							}
							}

						
							
					});
					
					 Button Resend = (Button) rootView.findViewById(R.id.btnResend);
						Resend.setOnClickListener(new OnClickListener(){
								@Override
								public void onClick(View arg0) {
									// TODO Auto-generated method stub
									
									//Resend OTP functionality will come here.
									
								}

							
								
						});  
				
			 }
			 
			 
			 
			 
			 
			 
		      return rootView;
		      
		      
		      
		      
		   }
		
		
	}
	
}
