package com.example.arihantdistributors;

import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TempData {

	public String brandTemp;
	public String categoryTemp;
	public String itemTemp;
	public String selectedBrand;
	public String selectedCategory;
	public Item selectedItem;
	public String Date;
	public String tempOrder;
	public TextView ed1;
	public ImageView im;
	public String query1; 
	public String query2;
	public String number;
   CartOperation cart = new CartOperation();
   public Context signupContext;
	
	private static TempData tData = new TempData();
	
	
	public static TempData getInstance()
	{
		return tData;
	}
}
