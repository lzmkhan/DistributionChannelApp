package com.example.arihantdistributors;

import java.util.ArrayList;
import java.util.List;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity  extends Activity{
	
	static List<String> settingList = new ArrayList<String>();
	static ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_main);
		
		Intent i = this.getIntent();
		 int mode = (int)i.getSerializableExtra("mode");
		 
		 
		 
		List<String> settingList = new ArrayList<String>();
		settingList.add("About Us");
		settingList.add("Update Profile");
		settingList.add("Feedback");
		settingList.add("Logout");
		settingList.add("Privacy Policy");
		settingList.add("Terms and Conditions");
		settingList.add("About Developer");
		
		adapter = new SettingListAdapter(settingList);
		ActionBar ab = getActionBar();
		ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF9800")));
		ab.setSplitBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF9800")));
	
		if(mode ==0)
		{
		 FragmentManager fragmentManager = getFragmentManager();
	      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	      fragment fragment = new fragment();
	      fragment.fragNum=99;
	      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
	      fragmentTransaction.replace(R.id.content_frame2, fragment);		
	        
		  fragmentTransaction.addToBackStack(null);
	      fragmentTransaction.commit();
		}
		else if(mode==1) 
		{
			FragmentManager fragmentManager = getFragmentManager();
		      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		      fragment fragment = new fragment();
		      fragment.fragNum=1;
		      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
		      fragmentTransaction.replace(R.id.content_frame2, fragment);		
		        
			  fragmentTransaction.addToBackStack(null);
		      fragmentTransaction.commit();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	
	
public class SettingListAdapter extends ArrayAdapter<String> {
		
		List<String> contents = null;
		
		public SettingListAdapter(List<String> contents) {
			
			super(SettingsActivity.this, R.layout.list_row3, contents);
			this.contents = contents;
			}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Make sure we have a view to work with (may have been given null)
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.list_row3, parent, false);
			}
			
			// Find the Item to work with.
			String currentString = contents.get(position);
			
			// title
			
			TextView titleText = (TextView) itemView.findViewById(R.id.settingsTitle);			
			titleText.setText(currentString);
			
			return itemView;
		}	
	
	}
	
private static class fragment extends Fragment
{
	
	public int fragNum = 1;
	
	/* 
	 * 99 = settings home
	 * 2 = About us
	 * 3 = Update profile
	 * 4 = feedback
	 * 5 = privacy policy
	 * 6 = terms and conditions
	 * 7 = about developer
	 */
	
	
	
	 View rootView;
	 @Override
	   public View onCreateView(LayoutInflater inflater,
	      ViewGroup container, Bundle savedInstanceState) {
	      /**
	       * Inflate the layout for this fragment
	       */
		 

		 ActionBar ab = getActivity().getActionBar();
		
		switch(fragNum)
		{
		 
		case 99: //settingslist
		 			 
		 rootView = inflater.inflate(R.layout.settings_list, container,
					false);
		
		
		 
		 ab.setTitle("Settings");
		 
		 ListView list = (ListView)rootView.findViewById(R.id.listviewS);			
		 list.setAdapter(adapter);
		 list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View viewClicked,
						int position, long id) {
					
					
				Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
					 FragmentManager fragmentManager = getFragmentManager();
				      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				      fragment fragment = new fragment();
				      fragment.fragNum=position;
				      fragmentTransaction.setCustomAnimations(R.animator.enter_from_right, R.animator.exit_to_left,R.animator.enter_from_left,R.animator.exit_to_right);
				      fragmentTransaction.replace(R.id.content_frame2, fragment);		
				        
					    fragmentTransaction.addToBackStack(null);
				         fragmentTransaction.commit();
			        
					}
			});		 
		
		 break;
		 
		 case 0: // about us
		 
			 rootView = inflater.inflate(R.layout.aboutus, container,
						false);
			 ab.setTitle("About Us");
			
		 break;
		 
		 case 1: // update profile
		 
			
			  rootView = inflater.inflate(R.layout.updateprofile, container,
			 		false);
			 
		
			 ab.setTitle("Update Profile");
			 

			 final EditText editStreet1 = (EditText) rootView.findViewById(R.id.streetText1);
			 final EditText editStreet2 = (EditText) rootView.findViewById(R.id.streetText2);
			 final EditText editArea = (EditText) rootView.findViewById(R.id.areaText);
			 final EditText editCity = (EditText) rootView.findViewById(R.id.cityText);
			 final EditText editState = (EditText) rootView.findViewById(R.id.stateText);
			 final EditText editDistrict = (EditText) rootView.findViewById(R.id.districtText);
			 final EditText editPIN = (EditText) rootView.findViewById(R.id.pinText);
			 final EditText editPhone = (EditText) rootView.findViewById(R.id.phoneText);
			 Button btnUpdate =(Button) rootView.findViewById(R.id.btnUpdate);
			 
			 editStreet1.setText(Info_Store.getInstance().Street_1);
			 editStreet2.setText(Info_Store.getInstance().Street_2);
			 editArea.setText(Info_Store.getInstance().Area);
			 editCity.setText(Info_Store.getInstance().City);
			 editState.setText(Info_Store.getInstance().State);
			 editDistrict.setText(Info_Store.getInstance().District);
			 editPIN.setText(Info_Store.getInstance().Pincode);
			 editPhone.setText(Info_Store.getInstance().Mobile);
			 
			 
			 btnUpdate.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					if(!editStreet1.getText().toString().equals(""))
					{
						Info_Store.getInstance().Street_1 = editStreet1.getText().toString();
						
						if(!editStreet2.getText().toString().equals(""))
						{
							Info_Store.getInstance().Street_2 = editStreet2.getText().toString();
							
							if(!editArea.getText().toString().equals(""))
							{
								Info_Store.getInstance().Area = editArea.getText().toString();
								
								if(!editCity.getText().toString().equals(""))
								{
									Info_Store.getInstance().City = editCity.getText().toString();
									
									if(!editState.getText().toString().equals(""))
									{
										Info_Store.getInstance().State = editState.getText().toString();
										
										if(!editDistrict.getText().toString().equals(""))
										{
											Info_Store.getInstance().District = editDistrict.getText().toString();
											
											if(!editPIN.getText().toString().equals(""))
											{
												Info_Store.getInstance().Pincode = editPIN.getText().toString();
												
												if(!editPhone.getText().toString().equals(""))
												{
													Info_Store.getInstance().Mobile = editPhone.getText().toString();	
													
													/*
													 * 
													 * Call webservice update all the above info where account id is this.
													 * 
													 */
													String query = "UPDATE `acc_user_info` SET `Street_1` = '" + Info_Store.getInstance().Street_1 + "', `Street_2` = '"+Info_Store.getInstance().Street_2+"', `Area` = '"+Info_Store.getInstance().Area+"', `City` = '"+Info_Store.getInstance().City+"', `District` = '"+Info_Store.getInstance().District+"', `State` = '"+Info_Store.getInstance().State+"', `Pincode` = '"+Info_Store.getInstance().Pincode+"', `MobileNo` = '"+Info_Store.getInstance().Mobile+"', `Email` = '"+Info_Store.getInstance().Email+"' WHERE `acc_user_info`.`Account_ID` = '"+Info_Store.getInstance().AccountID+"';";
													
													
													callUpdateService(query);
													
													
												}
												else
												{
													Toast.makeText(getActivity(), "phone number cannot be empty!", Toast.LENGTH_SHORT).show();
												}
											}
											else
											{
												Toast.makeText(getActivity(), "PINCODE cannot be empty!", Toast.LENGTH_SHORT).show();
											}
											
										}
										else
										{
											Toast.makeText(getActivity(), "District cannot be empty!", Toast.LENGTH_SHORT).show();
										}
									}
									else
									{
										Toast.makeText(getActivity(), "State cannot be empty!", Toast.LENGTH_SHORT).show();
									}
								}
								else
								{
									Toast.makeText(getActivity(), "City cannot be empty!", Toast.LENGTH_SHORT).show();
								}
									
							}
							else
							{
								Toast.makeText(getActivity(), "Area cannot be empty!", Toast.LENGTH_SHORT).show();
							}
							
						}
						else
						{
							Toast.makeText(getActivity(), "Street name cannot be empty!", Toast.LENGTH_SHORT).show();
						}
					}
					else
					{
						Toast.makeText(getActivity(), "Door no cannot be empty!", Toast.LENGTH_SHORT).show();
					}
					
				
				}
				 
			 });
			 
			 
		 break;
		 
		 case 2: //feedback
		 
			 rootView = inflater.inflate(R.layout.feedback, container,
						false);
			final EditText editName = (EditText) rootView.findViewById(R.id.nameText);
			final EditText editEmail =(EditText) rootView.findViewById(R.id.emailText);
			final EditText editFeed = (EditText) rootView.findViewById(R.id.feedbackText);
			final RadioButton rd1 = (RadioButton) rootView.findViewById(R.id.radio0);
			final RadioButton rd2 = (RadioButton) rootView.findViewById(R.id.radio1);
			
			editName.setText(Info_Store.getInstance().Name);
			editEmail.setText(Info_Store.getInstance().Email);
			
			
			Button btnSubmit = (Button) rootView.findViewById(R.id.btnSubmit);
			btnSubmit.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String query = "";
					if(!editFeed.getText().equals(""))
					{
					if(rd1.isChecked())
					{
						 query = new String("INSERT INTO `feedback` (`FeedbackID`, `Feedback_Type`, `Feedback_Content`, `Feedback_Time`, `Feedback_Author`) VALUES (NULL, 'App', '" + editFeed.getText().toString()  +"', CURRENT_TIMESTAMP, '"+ editName.getText().toString()+"');");
						
					}
					else if(rd2.isChecked())
					{
						 query = new String("INSERT INTO `feedback` (`FeedbackID`, `Feedback_Type`, `Feedback_Content`, `Feedback_Time`, `Feedback_Author`) VALUES (NULL, 'Service', '" + editFeed.getText().toString()  + "', CURRENT_TIMESTAMP, '" + editName.getText().toString() +"');");	
					}
					else
					{
						
					}
					}
										
					/*
					 * 
					 *  call webservice with the above insert stmnt
					 * 
					 */
					
					Toast.makeText(getActivity(), "Thank you for the feedback :)", Toast.LENGTH_SHORT).show();
					 }
				
			});
		
			 ab.setTitle("Feedback");
		 break;
		 
		 case 4: //privacy policy
		 
			 rootView = inflater.inflate(R.layout.privacypolicy, container,
						false);
					 ab.setTitle("Privacy policy");
		 break;
		 
		 case 5: //terms and condition
		 
			 rootView = inflater.inflate(R.layout.termandconditions, container,
						false);
					 ab.setTitle("Terms and Conditions");
		 break;
		 
		 case 6: //about developer
		 
			 rootView = inflater.inflate(R.layout.aboutus, container,
						false);
		
			 ab.setTitle("About Developer");
		 
		 break;
		 
		 default:
		Log.d("fragment switch", "default case executed");
	     break;
		}
	      return rootView;
	      
	      
	      
	      
	   }

	 
	 public  boolean isOnline() {
		  ConnectivityManager connectivityManager  = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
		  NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		  return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	 
	 public  void callUpdateService(String query)
	 {
		 WebserviceHandler wb = new WebserviceHandler(3); //setup searchquery
			if(isOnline())
			{
			wb.query = query;
			
			wb.set_context(getActivity());
			wb.execute();
			}
			else
			{
				Toast.makeText(getActivity(), "No Internet connection!", Toast.LENGTH_SHORT).show();
			}
	 }
	
	
}



}
