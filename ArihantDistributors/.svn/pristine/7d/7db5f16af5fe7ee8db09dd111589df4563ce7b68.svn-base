package com.example.arihantdistributors;

import java.util.Calendar;
import java.util.List;



import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Cart extends Activity{

	
	CartAdapter1 cartAdapter;
	
	private EditText changeDate;
	 Calendar cal;
    private int year;
    private int month;
    private int day;
    private String aDate;
    private String startDate;
    static final int DATE_PICKER_ID = 1111;
	Context c = this;
	TextView total;
	PorterDuff p;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cartlayout);
		
		ListView cartList = (ListView)findViewById(R.id.listviewCart); 
		cartAdapter = new CartAdapter1(TempData.getInstance().cart.copyCartContents());
		cartList.setAdapter(cartAdapter);
		ActionBar ab = getActionBar();
		ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF9800")));
		ab.setSplitBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF9800")));
		 changeDate = (EditText) findViewById(R.id.EditText01);
		 
		 total = (TextView)findViewById(R.id.TextView02);
		 total.setText("Total " + TempData.getInstance().cart.getTotal());
	        // Get current date by calender
	         
	        final Calendar c = Calendar.getInstance();
	        year  = c.get(Calendar.YEAR);
	        month = c.get(Calendar.MONTH);
	        day   = c.get(Calendar.DAY_OF_MONTH);
	 
	        // Show current date
	        aDate = new StringBuilder().append(day).append('/')
                 .append(month + 1).append("/").append(year).toString();
	        startDate =aDate;
	       changeDate.setText(aDate);
	        // Button listener to show date picker dialog
	         
	        changeDate.setOnClickListener(new OnClickListener() {
	 
	            @SuppressWarnings("deprecation")
				public void onClick(View v) {
	                 
	                // On button click show datepicker dialog
	                showDialog(DATE_PICKER_ID);
	            
	                
	            }
	 
	        });
	        
	        Button checkout = (Button) findViewById(R.id.btnCheckout);
	        checkout.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String[] text = changeDate.getText().toString().split("/");
					int day1 = Integer.parseInt(text[0]);
					int month1 = Integer.parseInt(text[1]);
					int year1 = Integer.parseInt(text[2]);
					if(TempData.getInstance().cart.cartStack.size() > 0)
					{
					if(year1 >= year)
					{
						if(month1 >= month)
						{
							if(day1 >= day)
							{
								
								if((Info_Store.getInstance().Street_1.equals("") ) || (Info_Store.getInstance().Mobile.equals("")) || (Info_Store.getInstance().City.equals("") ))
								{
									Toast.makeText(Cart.this,"Cannot place order without shipping details or phone number", Toast.LENGTH_SHORT).show();
									Intent myIntent = new Intent(Cart.this, SettingsActivity.class);
									myIntent.putExtra("mode", 1 );
							    	Cart.this.startActivity(myIntent);
							    
									
								}
								else
								{
								TempData.getInstance().Date = changeDate.getText().toString();
								Intent i = new Intent(Cart.this,CheckoutActivity.class);
								startActivity(i);
								Cart.this.finish();
								}
							}
							else
								Toast.makeText(Cart.this,"Please select valid day", Toast.LENGTH_SHORT).show();
						}
						else
							Toast.makeText(Cart.this,"Please select valid month", Toast.LENGTH_SHORT).show();
					}
					else
						Toast.makeText(Cart.this,"Please select valid year", Toast.LENGTH_SHORT).show();
					}
					else
					{
						Toast.makeText(Cart.this,"Cannot place order with empty cart!", Toast.LENGTH_SHORT).show();
					}
				
					
					
				}
	        	
	        });
	        
	        
	        
	}

	
	
	
	
	@SuppressLint("NewApi")
	@Override
	public void onActivityReenter(int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityReenter(resultCode, data);
		if(TempData.getInstance().cart.cartStack.size() == 0)
		cartAdapter.notifyDataSetChanged();
	}





	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
		if(TempData.getInstance().cart.cartStack.size() == 0)
		cartAdapter.notifyDataSetChanged();
	}





	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(TempData.getInstance().cart.cartStack.size() == 0)
		cartAdapter.notifyDataSetChanged();
	}





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
	
	class CartAdapter1 extends ArrayAdapter<Item> {
		
		List<Item> contents = null;
		
		public CartAdapter1(List<Item> contents) {
			
			super(Cart.this, R.layout.cart_row, contents);
			this.contents = contents;
			}
		public void refresh()
		{
			notifyDataSetChanged();
			total = (TextView)findViewById(R.id.TextView02);
			total.setText("Total " + TempData.getInstance().cart.getTotal());
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Make sure we have a view to work with (may have been given null)
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.cart_row, parent, false);
			}
			
			// Find the Item to work with.
			Item currentItem = contents.get(position);
			
			// Fill the view
			ImageView imageView = (ImageView)itemView.findViewById(R.id.cartItemImage);
			imageView.setImageResource(R.drawable.foodicon);
			
			// title
			TextView titleText = (TextView) itemView.findViewById(R.id.cartItemTitle);
			int length = currentItem.getItemName().length();
			if(length > 12)
			titleText.setText(currentItem.getItemName().substring(0, 11) +"...");
			else
				titleText.setText(currentItem.getItemName());	
			
			TextView priceText = (TextView) itemView.findViewById(R.id.cartINR);
			priceText.setText("INR " + currentItem.getItemPrice());
		
			TextView qntyText = (TextView) itemView.findViewById(R.id.cartQnty);
			qntyText.setText("x"+ currentItem.getItemQnty());
			final int posit =position;
			
			ImageView editButton = (ImageView) itemView.findViewById(R.id.cartEdit);
			editButton.setOnClickListener(new OnClickListener(){
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					//Display a dialog with edittext to get the qnty
					// custom dialog
					final customDialog dialog = new customDialog(c);
					dialog.setContentView(R.layout.editqntydiag);
					dialog.setTitle(Html.fromHtml("<font color='##FF9800'>Quantity</font>"));
					
					// set the custom dialog components - text, image and button
					EditText editText = (EditText) dialog.findViewById(R.id.qntyText);
					editText.getBackground().mutate().setColorFilter(getResources().getColor(R.color.primary_light), PorterDuff.Mode.SRC_ATOP);
					Button dialogButton = (Button) dialog.findViewById(R.id.button1);
					// if button is clicked, close the custom dialog
					dialogButton.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							EditText ed1 = (EditText) dialog.findViewById(R.id.qntyText);
							String qnty = ed1.getText().toString();
							if(!qnty.equals(""))
							{
							TempData.getInstance().cart.updateCartItem(posit, Integer.parseInt(qnty));
							refresh();
							}
							else
							{
								
							}
							
							
							
							dialog.dismiss();
						}
					});

					dialog.show();
				
				}
				
				
			});

			ImageView delButton = (ImageView) itemView.findViewById(R.id.cartRemove);
			delButton.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0)
				{
					//Remove the item from the list.
					//notifydatasetchange();
					TempData.getInstance().cart.removeFromCart(TempData.getInstance().cart.cartStack.get(posit));
					 notifyDataSetChanged();
					 total = (TextView)findViewById(R.id.TextView02);
					 total.setText("Total " + TempData.getInstance().cart.getTotal());

			}});
			
			return itemView;
		}	
	
	}

	
	//**************************************************************************************
		//for date change button
		
		  @SuppressLint("NewApi") @Override
		    protected Dialog onCreateDialog(int id) {
		        switch (id) {
		        case DATE_PICKER_ID:
		             
		            // open datepicker dialog.
		            // set date picker for current date
		            // add pickerListener listner to date picker
		        	
		        	DatePickerDialog dpd = new DatePickerDialog(this, pickerListener, year, month,day);
		        	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
		        	    // (picker is a DatePicker)
		        		cal = Calendar.getInstance();
		        	    dpd.getDatePicker().setMinDate(cal.getTimeInMillis()-1000);
		        	} else {
		        	    Log.w("TAG", "API Level < 11 so not restricting date range...");
		        	}
		        	return dpd;
		        	
		     
		        
		      
		          
		        }
		        return null;
		    }
		 
		    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {
		 
		        // when dialog box is closed, below method will be called.
		        @Override
		        public void onDateSet(DatePicker view, int selectedYear,
		                int selectedMonth, int selectedDay) {
		             
		            year  = selectedYear;
		            month = selectedMonth;
		            day   = selectedDay;
		 
		            
		            
		            aDate = new StringBuilder().append(day).append('/')
		                    .append(month+1).append("/").append(year).toString();
		     
		          
		            changeDate.setText(aDate);
		            // Show selected date
		           Log.d("selected date",year+"/"+month+"/"+day);
		     
		           }
		        };
	
}
