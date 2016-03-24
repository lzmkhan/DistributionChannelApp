package com.example.arihantdistributors;





import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;



public class SignupActivity extends Activity {
	  static SignUpFragment fragment;
	  private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
	    private static final String TAG = "MainActivity";
	
	    private BroadcastReceiver mRegistrationBroadcastReceiver;
	
	    
	    private boolean isReceiverRegistered;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		ActionBar ab = getActionBar();
		ab.hide();
		TempData.getInstance().signupContext = this;
	      fragment = new SignUpFragment();
	
		  //start with fragment which gets the type of account the user wants to register for.
	      fragment.fragNum =0;
		   
		  FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction ft =  fragmentManager.beginTransaction();
		
		                  ft.replace(R.id.content_frame1, fragment);
		                  ft.commit();
		                
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public  void registerGCM()
	{

      
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken = sharedPreferences
                        .getBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false);
                if (sentToken) {
                   Toast.makeText(TempData.getInstance().signupContext,"Already Registered", Toast.LENGTH_SHORT).show();
                } else {
                	 Toast.makeText(TempData.getInstance().signupContext,"Something went wrong", Toast.LENGTH_SHORT).show();                }
            }
        };
     
        // Registering BroadcastReceiver
        registerReceiver();

        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
        	Log.d("register gcm", "checkingplayservices");
        	
            Intent intent = new Intent(SignupActivity.this, RegistrationIntentService.class);
            startService(intent);
        }
	}
	
	
	public void callOTPFragment()
	{
		 
		SignUpFragment fragment = new SignUpFragment();
		fragment.fragNum =3;
		  FragmentManager fragmentManager = getFragmentManager();
		  FragmentTransaction ft = fragmentManager.beginTransaction();
		  ft.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
		                  ft.replace(R.id.content_frame1, fragment);
		                  ft.addToBackStack(null);//adds the transaction to stack so later when back is pressed it will go back this fragment
		                  ft.commit();
	}
	 private void registerReceiver(){
	        if(!isReceiverRegistered) {
	            LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
	                    new IntentFilter(QuickstartPreferences.REGISTRATION_COMPLETE));
	            Log.d("Registering...", "registerreceiverfunction()");
	            isReceiverRegistered = true;
	        }
	    }
	
	 private boolean checkPlayServices() {
	        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
	        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
	        if (resultCode != ConnectionResult.SUCCESS) {
	            if (apiAvailability.isUserResolvableError(resultCode)) {
	                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
	                        .show();
	            } else {
	                Log.i(TAG, "This device is not supported.s");
	                finish();
	            }
	            return false;
	        }
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
	
    public  boolean isOnline() {
		  ConnectivityManager connectivityManager  = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		  NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		  return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
    
	
	private static class SignUpFragment extends Fragment
	{
	
		public int fragNum = 1;
		OTPHandler otp = new OTPHandler();
				 View rootView;
		 @Override
		   public View onCreateView(LayoutInflater inflater,
		      ViewGroup container, Bundle savedInstanceState) {
		      /**
		       * Inflate the layout for this fragment
		       */
			 
			 
			
			 switch(fragNum)
			 {
			 case 0:
				 //customer or distributor account option
				 rootView = inflater.inflate(R.layout.signup_type, container,
							false);
				 Button btnCust =(Button) rootView.findViewById(R.id.btnCust);
					btnCust.setOnClickListener(new OnClickListener(){
						public void onClick(View v)
						{
						
							 fragment = new SignUpFragment();
							 //invokes Customer fragment
						      fragment.fragNum =2;
							   
							  FragmentManager fragmentManager = getFragmentManager();
							  FragmentTransaction ft = fragmentManager.beginTransaction();
							  ft.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
							                  ft.replace(R.id.content_frame1, fragment);
							                  ft.addToBackStack(null);
							                  ft.commit();
							
							
							
						}
					});
				
					
					Button btnDist =(Button) rootView.findViewById(R.id.btnDist);
					btnDist.setOnClickListener(new OnClickListener(){
						public void onClick(View v)
						{
						
							 fragment = new SignUpFragment();
							 //invokes distributor fragment
						      fragment.fragNum =1;
							   
							  FragmentManager fragmentManager = getFragmentManager();
							  FragmentTransaction ft = fragmentManager.beginTransaction();
							  ft.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
							                  ft.replace(R.id.content_frame1, fragment);
							                  ft.addToBackStack(null);//adds the transaction to stack so later when back is pressed it will go back this fragment
							                  ft.commit();
							
							
							
						}
					});
				
				 break;
				 
			 case 1:
				//distributor fragment
				 rootView = inflater.inflate(R.layout.signup_dist, container,
							false);
				
				 
				 Button btnSignUpDist =(Button) rootView.findViewById(R.id.btnSignUpDist);
					btnSignUpDist.setOnClickListener(new OnClickListener(){
						public void onClick(View v)
						{
							
							//call signup_formSend()
							
							 EditText editText1 = (EditText)rootView.findViewById(R.id.edtgetQnty);
							
							 EditText editText3 = (EditText)rootView.findViewById(R.id.editText3);
							
							 EditText editText5 = (EditText)rootView.findViewById(R.id.editText5);
							 EditText editText6 = (EditText)rootView.findViewById(R.id.editText6);
							 EditText editText7 = (EditText)rootView.findViewById(R.id.editText7);
							 
							//need to validate whether fields are empty are not
							
							/*
							 * INSERT INTO `arihant`.`acc_user_info` (`ID`, `Name`, `Street_1`, `Street_2`, `Area`, `City`, `District`, `State`, `Pincode`, `MobileNo`, `Email`, `Account_ID`) VALUES (NULL, 'sdfsdf', 'sdfsdf', 'sdfsdf', 'sdfsdfsdf', 'dfsdf', 'sdfsdfs', '', '234233', 'sdfsdfsdf', 'sdfdfsdf', 'sdfsdfsdf');
							 * Need to insert records on both acc_user_info table and accounts table
							 * 
							 */
							 
							 if(!editText1.getText().toString().trim().equals(""))
							 { 
								 if(!editText3.getText().toString().trim().equals(""))
								 {
									 if(editText3.getText().toString().length()== 6)
									 {
										 if(!editText5.getText().toString().trim().equals(""))
										 {
											 if(!editText6.getText().toString().trim().equals(""))
											 { 
												 if(editText6.getText().toString().length() == 10)
												 {
													 if(!editText7.getText().toString().trim().equals(""))
													 {
														 if(editText7.getText().toString().contains("@") && editText7.getText().toString().contains("."))
														 {
															 //checks if number is already present in the database.
															 WebserviceHandler wh = new WebserviceHandler(7);
															 wh.query ="Select * from accounts where `Username` = '" + editText6.getText().toString() + "';";
															 wh.set_context(getActivity());
															 wh.submode =1;
															 wh.execute();
															
															 
															 TempData.getInstance().number = editText6.getText().toString();
															 
																TempData.getInstance().query1 = "INSERT INTO `accounts` (`ID` ,`Username` ,`Password` ,`Account_Type`)VALUES (NULL , '"+editText6.getText().toString()+"', '"+editText5.getText().toString()+"', 'type_dist');";
																TempData.getInstance().query2 = "INSERT INTO `acc_user_info` (`ID` ,`Name` ,`Street_1` ,`Street_2` ,`Area` ,`City` ,`District` ,`State` ,`Pincode` ,`MobileNo` ,`Email` ,`Account_ID` ,`verified`)VALUES (NULL , '"+editText1.getText().toString()+"', 'None', 'None', 'None', 'None', 'None', 'None', '"+editText3.getText().toString()+"', '"+editText6.getText().toString()+"', '"+editText7.getText().toString()+"', '[PLACEHOLDER]', 'yes');";
																
																 
																
														 }						
														 else
														 {
															 //enter valid email format
															 Toast.makeText(getActivity(), "Enter valid email!", Toast.LENGTH_SHORT).show();
														 }
													 }
													 else
													 {
														 //email
														 Toast.makeText(getActivity(), "Email cannot be empty!", Toast.LENGTH_SHORT).show();
													 }
												 }
												 else
												 {
											
													 //valid phonennumber
													 Toast.makeText(getActivity(), "Enter valid TIN/mobile!", Toast.LENGTH_SHORT).show();
												 }
											 }
											 else
											 {
												 //TINMOBILE
												 Toast.makeText(getActivity(), "TIN/Mobile number cannot be empty!", Toast.LENGTH_SHORT).show();
											 }
										 }
										 else
										 {
											 //password
											 Toast.makeText(getActivity(), "Password cannot be empty!", Toast.LENGTH_SHORT).show();
										 }
									 }
									 else
									 {
										 //enter valid pin
										 Toast.makeText(getActivity(), "Enter valid PINCODE!", Toast.LENGTH_SHORT).show();
									 }
								 }
								 else
								 {
									 //pincode
									 Toast.makeText(getActivity(), "PINCODE cannot be empty!", Toast.LENGTH_SHORT).show();
								 }
							 }
							 else
							 {
							
								 //firm name
								 Toast.makeText(getActivity(), "Firm name cannot be empty!", Toast.LENGTH_SHORT).show();
						
							 }
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 

							
							
						}
					});
			     break;
			    
			 case 2:
				 //customer fragment
				 rootView = inflater.inflate(R.layout.signup_cust, container,
							false);
				 
				 Button btnSignUpCust =(Button) rootView.findViewById(R.id.btnSignUpCusto);
					btnSignUpCust.setOnClickListener(new OnClickListener(){
						public void onClick(View v)
						{
							//call signup_formSend()
							
							 EditText editText1 = (EditText)rootView.findViewById(R.id.edtgetQnty);
							 EditText editText2 = (EditText)rootView.findViewById(R.id.editText2);
							 EditText editText3 = (EditText)rootView.findViewById(R.id.editText3);
							 EditText editText4 = (EditText)rootView.findViewById(R.id.editText4);
							 
							
							 if(!editText1.getText().toString().trim().equals(""))
							 {
								 if(!editText2.getText().toString().trim().equals(""))
								 {
									 if(!editText3.getText().toString().trim().equals(""))
									 {
										 if(editText3.getText().toString().trim().length() == 10)
										 {
											 if(!editText4.getText().toString().trim().equals(""))
											 {
												 if(editText4.getText().toString().trim().contains("@") && editText4.getText().toString().trim().contains(".") )
												 {
													 
													 
													 //checks if number is already present in the database.
													 WebserviceHandler wh = new WebserviceHandler(7);
													 wh.query ="Select * from accounts where `Username` = '" + editText3.getText().toString() + "';";
													 wh.set_context(getActivity());
													 wh.submode=1;
													 wh.execute();
													 
													 
													 TempData.getInstance().number = editText3.getText().toString();
													 
														TempData.getInstance().query1 = "INSERT INTO `accounts` (`ID` ,`Username` ,`Password` ,`Account_Type`)VALUES (NULL , '"+editText3.getText().toString()+"', '"+editText2.getText().toString()+"', 'type_cust');";
														TempData.getInstance().query2 = "INSERT INTO `a5531971_me`.`acc_user_info` (`ID` ,`Name` ,`Street_1` ,`Street_2` ,`Area` ,`City` ,`District` ,`State` ,`Pincode` ,`MobileNo` ,`Email` ,`Account_ID` ,`verified`)VALUES (NULL , '"+editText1.getText().toString()+"', 'None', 'None', 'None', 'None', 'None', 'None', 'None', '"+editText3.getText().toString()+"', '"+editText4.getText().toString()+"', '[PLACEHOLDER]', 'yes');";
														
														 
														//need to validate whether fields are empty are not.
														/*
														 * INSERT INTO `arihant`.`acc_user_info` (`ID`, `Name`, `Street_1`, `Street_2`, `Area`, `City`, `District`, `State`, `Pincode`, `MobileNo`, `Email`, `Account_ID`) VALUES (NULL, 'sdfsdf', 'sdfsdf', 'sdfsdf', 'sdfsdfsdf', 'dfsdf', 'sdfsdfs', '', '234233', 'sdfsdfsdf', 'sdfdfsdf', 'sdfsdfsdf');
														 * Need to insert records on both acc_user_info table and accounts table
														 * 
														 */
														
														
													 
													 
												 }
												 else
												 {
													 Toast.makeText(getActivity(), "Enter valid email address!", Toast.LENGTH_SHORT).show();
												 }
											 }
											 else
											 {
												 Toast.makeText(getActivity(), "Email cannot be empty!", Toast.LENGTH_SHORT).show();
											 }
										 }
										 else
										 {
											 //valid phone
											 Toast.makeText(getActivity(), "Enter valid mobile number!", Toast.LENGTH_SHORT).show();
										 }
									 }
									 else
									 {
										 Toast.makeText(getActivity(), "Mobile Number cannot be empty!", Toast.LENGTH_SHORT).show();
									 }
								 }
								 else
								 {
									 Toast.makeText(getActivity(), "Password cannot be empty!", Toast.LENGTH_SHORT).show();
								 }
							 }
							 else
							 {
								 Toast.makeText(getActivity(), "Name cannot be empty!", Toast.LENGTH_SHORT).show();
							 }
							 
							 
							 
							 
							 
							
						}
					});
					
				 break;
			 
				 
			 case 3:
				 //This fragment holds the otp code to verify the phone number
				 //send otp and once otp matches send verified as status for verified column
				 rootView = inflater.inflate(R.layout.checkout_1, container,
							false);
				 
				 otp.generateOTP();
				 if(((SignupActivity)getActivity()).isOnline())
				 {
				 otp.sendOTP(getActivity(),1);
				 Toast.makeText(getActivity(), otp.OTPHolder,Toast.LENGTH_SHORT).show();
				 Toast.makeText(getActivity(), "OTP sent",Toast.LENGTH_SHORT).show();
				 }
				 else
				 {
					 Toast.makeText(getActivity(), "Not connected to Internet!",Toast.LENGTH_SHORT).show();
				 }
				 
				 Button btnConfirm = (Button) rootView.findViewById(R.id.btnConfirm);
				 btnConfirm.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						
						
						
						Toast.makeText(getActivity(),otp.OTPHolder, Toast.LENGTH_SHORT).show();
						EditText edit1 = (EditText) rootView.findViewById(R.id.otpText);
						String input = edit1.getText().toString();
						
						/*
						 * Check whether the inputed code matches with the OTPHolder
						 */
						if(input.trim().equals(otp.OTPHolder.trim()))//input otp matches otpholder
						{
							
							
							
							
								 WebserviceHandler wb = new WebserviceHandler(7); //setup check()
									if(((SignupActivity)getActivity()).isOnline())
									{
									wb.query ="SELECT * FROM `accounts` WHERE Username = '"+ TempData.getInstance().number +"'";
									wb.submode = 0;
									
									wb.set_context(getActivity());
									wb.execute();
								//	((SignupActivity)getActivity()).registerGCM();
									}
								    else
									{
										Toast.makeText(getActivity(), "No Internet connection!", Toast.LENGTH_SHORT).show();
									}
						
						}
						else
						{
							Toast.makeText(getActivity(), "The entered OTP does not matches, Please try again or click Resend OTP", Toast.LENGTH_SHORT).show();
						}
					}
					 
				 });
				 
				 
				 
				 
				 break;
			
			 }
			 
					 
			
			
			 
	
				
			
			 
			   return rootView;
		     
		      
		   }
		 
		 
		
		 
		 
		 
			 }
			 
			 
		 
		
		
	}
	

