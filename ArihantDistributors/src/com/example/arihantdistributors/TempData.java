package com.example.arihantdistributors;

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
   CartOperation cart = new CartOperation();
	
	private static TempData tData = new TempData();
	
	
	public static TempData getInstance()
	{
		return tData;
	}
}
