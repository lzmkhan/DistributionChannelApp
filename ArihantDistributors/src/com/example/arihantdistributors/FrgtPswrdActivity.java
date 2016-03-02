package com.example.arihantdistributors;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
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
import android.widget.Toast;


public class FrgtPswrdActivity extends Activity {
	static OTPHandler otp = new OTPHandler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frgtpswrdcntinr);
		
		ActionBar ab = getActionBar();
		ab.hide();
		 FragmentManager fragmentManager = getFragmentManager();
	      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	      Forgetfragment fragment = new Forgetfragment();
	   
	         fragmentTransaction.replace(R.id.content_frame, fragment);				
		     fragmentTransaction.commit();
		

		
		
		
		
	}

	public void callLogin()
	{
		Intent i = new Intent(FrgtPswrdActivity.this, Login_Activity.class);
		startActivity(i);
		finish();
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
		public int fragNum = 0;
		TextView txt1;
		 View rootView;
		 @Override
		   public View onCreateView(LayoutInflater inflater,
		      ViewGroup container, Bundle savedInstanceState) {
		      /**
		       * Inflate the layout for this fragment
		       */
			 
			 
			
			 
			 
			 if(fragNum == 2)
			 {			 
			 rootView = inflater.inflate(R.layout.forgot_2, container,
						false);
		
			 EditText field2 = (EditText)rootView.findViewById(R.id.editText2);
			  field1 = (EditText)rootView.findViewById(R.id.edtgetQnty);
			  field1.getBackground().mutate().setColorFilter(getResources().getColor(R.color.primary_light), PorterDuff.Mode.SRC_ATOP);
			  field2.getBackground().mutate().setColorFilter(getResources().getColor(R.color.primary_light), PorterDuff.Mode.SRC_ATOP);
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
				    	 txt1.setTextColor(Color.GREEN);
				     }
				     else
				     {
				    	 txt1.setText("No Match");
				    	 txt1.setTextColor(Color.RED);
				     }
				     
				   }
				  });
			 
			 Button updateBtn = (Button) rootView.findViewById(R.id.btnPassReset);
			 updateBtn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					if(txt1.getText().toString().trim().equals("Matches"))
					{
					try{
					WebserviceHandler wbx = new WebserviceHandler(3);
					wbx.set_context(getActivity());
					wbx.submode =1;
					wbx.query = "UPDATE `accounts` SET `Password` = '"+ field1.getText() +"' WHERE `Username` = '"+Info_Store.getInstance().Mobile+"' ;";
					wbx.execute();
					}
					catch(Exception e)
					{
						Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
					}
					}
					else
					{
						Toast.makeText(getActivity(), "The password entered in the two fields are not same!", Toast.LENGTH_SHORT).show();
					}
				}
				 
			 });
			 }
			 else if(fragNum == 1)
			 {
				 rootView = inflater.inflate(R.layout.forgot_1, container,
							false);
				 Toast.makeText(getActivity(), otp.OTPHolder, Toast.LENGTH_SHORT).show();
				 Button Reset = (Button)rootView.findViewById(R.id.btnPassReset);
				
				 
				 Reset.setOnClickListener(new OnClickListener(){
							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								
								//reset functionality will come here.
						    EditText ed1 = (EditText) rootView.findViewById(R.id.txtOTP);
						    ed1.getBackground().mutate().setColorFilter(getResources().getColor(R.color.primary_light), PorterDuff.Mode.SRC_ATOP);
							String enteredOTP = ed1.getText().toString();
							// The generated OTP is sent to Email. It is also Stored in OTP_Holder global in OTP_Handler class.
						
							
							String generatedOTP = otp.OTPHolder;// need to assign it.
							
							if(generatedOTP.equals(enteredOTP))
							{
								 FragmentManager fragmentManager = getFragmentManager();
							      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
							      Forgetfragment fragment = new Forgetfragment();
							      fragment.fragNum=2;
							      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
							      fragmentTransaction.replace(R.id.content_frame, fragment);		
							        
								  //  fragmentTransaction.addToBackStack(null);
							         fragmentTransaction.commit();
							}
							else
							{
								Toast.makeText(getActivity(), "OTP not valid, please check and enter again", Toast.LENGTH_SHORT).show();
							}
							}

						
							
					});
					
					 Button Resend = (Button) rootView.findViewById(R.id.btnResend);
						Resend.setOnClickListener(new OnClickListener(){
								@Override
								public void onClick(View arg0) {
									// TODO Auto-generated method stub
									otp.generateOTP();
									otp.sendOTP(getActivity());
									Toast.makeText(getActivity(), "We have sent you an new OTP!", Toast.LENGTH_SHORT).show();
									//Resend OTP functionality will come here.
									Toast.makeText(getActivity(), otp.OTPHolder, Toast.LENGTH_SHORT).show();
								}

							
								
						});  
				
			 }
			 else if(fragNum == 0)
			 {
				 rootView = inflater.inflate(R.layout.frgtpswrd0, container,
							false);
								
				 EditText number = (EditText) rootView.findViewById(R.id.txtTIN);
				 Info_Store.getInstance().Mobile = number.getText().toString().trim();
					 Button next = (Button) rootView.findViewById(R.id.btnNext);
						next.setOnClickListener(new OnClickListener(){
								@Override
								public void onClick(View arg0) {
									// TODO Auto-generated method stub
									otp.generateOTP();
									
									otp.sendOTP(getActivity());
									
									 FragmentManager fragmentManager = getFragmentManager();
								      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
								      Forgetfragment fragment = new Forgetfragment();
								      fragment.fragNum=1;
								      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
								      fragmentTransaction.replace(R.id.content_frame, fragment);		
								        
									    //fragmentTransaction.addToBackStack(null);
								         fragmentTransaction.commit();
									
									
								}

							
								
						});  
				
				 
				 
				 
			 }
			 else
			 {
				 
			 }
			 
			 
			 
			 
			 
			 
		      return rootView;
		      
		      
		      
		      
		   }
		
		
	}
	
}
