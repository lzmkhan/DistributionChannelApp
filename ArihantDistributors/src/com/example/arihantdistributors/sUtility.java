package com.example.arihantdistributors;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class sUtility {

	
	
	public List<BrandCategory> fillListSource(List<String> input, int mode)
	{
		List<BrandCategory> list1 = new ArrayList<BrandCategory>();
	int iterate =0;
		if(mode == 0)
		{
			iterate = 4;
		}
		else if (mode ==1)
		{
			iterate = 5;
		}
		for(int i =0; i < input.size(); i+=iterate)
		{
			BrandCategory  bc= new BrandCategory(Integer.parseInt(input.get(i)),input.get(i+2), input.get(i+1));
			list1.add(bc);
			bc = null;
			
		}
			
		return list1;
	}
	
	public List<Item>  fillItemList(List<String> input)
	{
		List<Item> list = new ArrayList<Item>();
		try
		{
		
		if(input != null)
		for(int i =0; i < input.size();i +=10)
		{
			Item item = new Item(input.get(i),input.get(i+1),input.get(i+6),input.get(i+7),input.get(i+9), input.get(i+8),input.get(i+5),input.get(i+4),input.get(i+9),input.get(i+3));
			list.add(item);
		}
		}
		catch(Exception e)
		{
			Log.d("Exception  @ sUtility", e.toString());
		}
		
		return list;
	}
	
	public String createOrders()
	{
		String s ="INSERT INTO `a5531971_me`.`order_items` (`InstanceID` ,	`ProductID` ,`Quantity` ,`OrderID`)	VALUES";
		
		for(int i =0;i < TempData.getInstance().cart.cartStack.size(); i++)
		{
			s= new String(s+ "  (NULL , '"+TempData.getInstance().cart.cartStack.get(i).getItemID()+"', '"+TempData.getInstance().cart.cartStack.get(i).getItemQnty()+"', '[PLACEHOLDER]')" );
		if(i != TempData.getInstance().cart.cartStack.size()-1)
		{
			s = new String(s+",");
		}
		else
			s= new String(s+";");
		}
	
		//INSERT INTO `a5531971_me`.`orders` (`OrderID` ,`Account_ID` ,`Order_Amount` ,`Delivered_By` ,`Order_Date`) VALUES ( NULL , '1', '1234', '12/12/2015', NOW( ));

		return s;
	}
	
	
	
}
