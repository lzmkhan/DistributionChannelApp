package com.example.arihantdistributors;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends Activity {



	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkoutcontainer);
		ActionBar ab = getActionBar();
		ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF9800")));
		ab.setSplitBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF9800")));
		 FragmentManager fragmentManager = getFragmentManager();
	      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	      Forgetfragment fragment = new Forgetfragment();
	      fragment.fragNum =1;
	      
	         fragmentTransaction.replace(R.id.checkout_frame, fragment);				
		     fragmentTransaction.commit();
		
		
	}

	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
	
	
	
	private static class Forgetfragment extends Fragment
	{
		 OTPHandler otp = new OTPHandler();
		public int fragNum = 1;
		
		 View rootView;
		 @Override
		   public View onCreateView(LayoutInflater inflater,
		      ViewGroup container, Bundle savedInstanceState) {
		      /**
		       * Inflate the layout for this fragment
		       */
			 
			 
			
			 
			 
			 if(fragNum == 1)
			 {			 
			 rootView = inflater.inflate(R.layout.checkout_1, container,
						false);
		
			 
			
			 otp.generateOTP();
			 if(isOnline())
			 {
			 otp.sendOTP();
			 Toast.makeText(getActivity(), otp.OTPHolder,Toast.LENGTH_SHORT).show();
			 Toast.makeText(getActivity(), "OTP sent",Toast.LENGTH_SHORT).show();
			 }
			 else
			 {
				 Toast.makeText(getActivity(), "Not connected to Internet!",Toast.LENGTH_SHORT).show();
			 }
			 ActionBar ab = getActivity().getActionBar();
			 ab.setTitle("Confirm Order");
			 
			 Button btnConfirm = (Button) rootView.findViewById(R.id.btnConfirm);
			 btnConfirm.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					
					
					//send the generated otp to webservice
				//	WebserviceHandler wb = new WebserviceHandler(2); //setup searchquery
					//wb.query ="Select * from brands";
					//wb.submode =0;
					//wb.set_context(getActivity());
					//wb.execute();
					Toast.makeText(getActivity(),otp.OTPHolder, Toast.LENGTH_SHORT).show();
					EditText edit1 = (EditText) rootView.findViewById(R.id.otpText);
					String input = edit1.getText().toString();
					
					/*
					 * Check whether the inputed code matches with the OTPHolder
					 */
					if(input.trim().equals(otp.OTPHolder.trim()))//input otp matches otpholder
					{
						
						String AccountID =Info_Store.getInstance().AccountID;//get AccountID from infostore
						String Date =TempData.getInstance().Date; //get Date from tempData
						String query1 = "INSERT INTO `orders` (`OrderID` ,`Account_ID` ,`Order_Amount` ,`Delivered_By` ,`Order_Date`) VALUES ( NULL , '"+AccountID +"', '"+TempData.getInstance().cart.getTotal()+"', '" + Date + "', NOW( ));";
						sUtility su = new sUtility();
						String query2 = su.createOrders();
						
						if(isOnline())
						{
						WebserviceHandler wb = new WebserviceHandler(2); //setup searchquery
						wb.query1 =query1;
						wb.query2 =query2;
						Log.d("query1", query1);
						Log.d("query2", query2);
						wb.mode =5;			
						wb.set_context(getActivity());
						wb.execute();
						
						
						
						
					  FragmentManager fragmentManager = getFragmentManager();
				      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				      Forgetfragment fragment = new Forgetfragment();
				      fragment.fragNum=2;
				      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
				      fragmentTransaction.replace(R.id.checkout_frame, fragment);		
				        
					   // fragmentTransaction.addToBackStack(null);
				         fragmentTransaction.commit();
						}
						else
						{
							Toast.makeText(getActivity(), "No internet Connection", Toast.LENGTH_SHORT).show();
						}
				         
					}
					else
					{
						Toast.makeText(getActivity(), "The entered OTP does not matches, Please try again or click Resend OTP", Toast.LENGTH_SHORT).show();
					}
				}
				 
			 });
			
			 }
			 else if(fragNum==2)
			 {
				 rootView = inflater.inflate(R.layout.checkout_2, container,
							false);
			
				 
				
				 ActionBar ab = getActivity().getActionBar();
				 ab.setTitle("Checkout");
				 TempData.getInstance().ed1 = (TextView) rootView.findViewById(R.id.orderNumber);
				TempData.getInstance().im = (ImageView) rootView.findViewById(R.id.imageView1);
				 
				
				 
			 }
		
			 
		      return rootView;
			 
		      
		      
		      
		   }
		 public final boolean isOnline() {
			  ConnectivityManager connectivityManager  = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
			  NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
			  return activeNetworkInfo != null && activeNetworkInfo.isConnected();
		}
	}
}

