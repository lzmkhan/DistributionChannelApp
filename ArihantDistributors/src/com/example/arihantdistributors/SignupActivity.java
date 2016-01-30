package com.example.arihantdistributors;



import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;



public class SignupActivity extends Activity {
	  static SignUpFragment fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
	
		
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
	
	
	
	private static class SignUpFragment extends Fragment
	{
	
		public int fragNum = 1;
	
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
							String[] formContents = getFragmentData();
							//call signup_formSend()
							
							//placeholder logic
							for(int i=0; i < formContents.length;i++)
							{
								 Toast.makeText(getActivity(), formContents[i],
										   Toast.LENGTH_LONG).show();
							}
							//need to validate whether fields are empty are not
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
							String[] formContents = getFragmentData();
							//call signup_formSend()
							
							//placeholder logic
							for(int i=0; i < formContents.length;i++)
							{
								 Toast.makeText(getActivity(), formContents[i],
										   Toast.LENGTH_LONG).show();
							}
							//need to validate whether fields are empty are not.
							
						}
					});
					
				 break;
			 
			 }
			 
					 
			
			
			 
	
				
			
			 
			   return rootView;
		     
		      
		   }
		 
		 public String[] getFragmentData()
		 {
			//returns edittext contents from the fragments.
			 String[] formContent;
			 if(fragNum == 2){
				 //fetches contents from customer fragment
				 formContent = new String[4];
				 EditText editText1 = (EditText)rootView.findViewById(R.id.editText1);
				 EditText editText2 = (EditText)rootView.findViewById(R.id.editText2);
				 EditText editText3 = (EditText)rootView.findViewById(R.id.editText3);
				 EditText editText4 = (EditText)rootView.findViewById(R.id.editText4);
				 
				 formContent[0]=editText1.getText().toString();
				 formContent[1]=editText2.getText().toString();
				 formContent[2]=editText3.getText().toString();
				 formContent[3]=editText4.getText().toString();
			 }
			 else if (fragNum==1)
			 {
				 //fetches contents from distributer fragment
				 formContent = new String[7];
				 EditText editText1 = (EditText)rootView.findViewById(R.id.editText1);
				 EditText editText2 = (EditText)rootView.findViewById(R.id.editText2);
				 EditText editText3 = (EditText)rootView.findViewById(R.id.editText3);
				 EditText editText4 = (EditText)rootView.findViewById(R.id.editText4);
				 EditText editText5 = (EditText)rootView.findViewById(R.id.editText5);
				 EditText editText6 = (EditText)rootView.findViewById(R.id.editText6);
				 EditText editText7 = (EditText)rootView.findViewById(R.id.editText7);
				 
				 formContent[0]=editText1.getText().toString();
				 formContent[1]=editText2.getText().toString();
				 formContent[2]=editText3.getText().toString();
				 formContent[3]=editText4.getText().toString();
				 formContent[4]=editText5.getText().toString();
				 formContent[5]=editText6.getText().toString();
				 formContent[6]=editText7.getText().toString();
			 }
			 else
			 {
				 formContent = new String[1];
				 formContent[0] ="None";
			 }
			 
			 return formContent;
			 }
		 
		 
		
		 
		 
		 
			 }
			 
			 
		 
		
		
	}
	

