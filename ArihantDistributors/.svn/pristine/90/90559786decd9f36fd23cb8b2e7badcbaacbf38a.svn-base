package com.example.arihantdistributors;

import java.util.ArrayList;
import java.util.List;

public class CartOperation {
	
	public 
	List<Item> cartStack = new ArrayList<Item>();


public void addToCart(Item i)
{
	cartStack.add(i);
	
}

public void removeFromCart(Item i)
{
	int index =0;
	String itemID = i.getItemID();
	
	for(int j =0; j < cartStack.size();j++)
	{
		if(itemID.equals(cartStack.get(j).getItemID()))
		{
			index =j;
		}
	}
	cartStack.remove(index);
}

public int getTotal()
{
	int sum=0;
	for(int i =0;  i< cartStack.size();i++)
	{
		int price = Integer.parseInt(cartStack.get(i).getItemPrice());
		int qnty = cartStack.get(i).getItemQnty();
		sum = sum + (price *qnty);
		
	}
	
	
	
	
	return sum;
	
}

public List<Item> copyCartContents()
{	
	return cartStack;
}

public void setCart(List<Item> i)
{
	cartStack.clear();
	cartStack.addAll(i);
}

public int chkifalrdyextsinlst(Item i)
{
	
	String itemId = i.getItemID();
	
	for(int j =0 ; j < cartStack.size(); j++)
	{
		if(itemId.equals(cartStack.get(j).getItemID()))
		{
			return j;
		}
	}
	return -1;
	
}

public void updateCartItem(int index, int qnty)
{
	Item i = cartStack.get(index);
	i = new Item(i.getItemID(), i.getItemName(), i.getItemPrice(), i.getItemImageURL(),i.getItemDesc(), qnty);
    cartStack.set(index, i);
}

}
