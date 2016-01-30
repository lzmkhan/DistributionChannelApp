package com.example.arihantdistributors;

import java.util.ArrayList;
import java.util.List;

public class CartOperation {
	
	private static List<Item> cartStack = new ArrayList<Item>();


public void addToCart(Item i)
{
	cartStack.add(i);
	
}

public void removeFromCart(Item i)
{
	int index =0;
	int itemID = i.getItemID();
	
	for(int j =0; j < cartStack.size();j++)
	{
		if(itemID == cartStack.get(j).getItemID())
		{
			index =j;
		}
	}
	cartStack.remove(index);
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
	
	int itemId = i.getItemID();
	
	for(int j =0 ; j < cartStack.size(); j++)
	{
		if(itemId == cartStack.get(j).getItemID())
		{
			return j;
		}
	}
	return -1;
	
}

public void updateCartItem(int index, int qnty)
{
	Item i = cartStack.get(index);
	i = new Item(i.getItemID(), i.getItemName(), i.getItemPrice(), i.getItemImageURL(),i.getItemDesc(), i.getItemQnty());
    cartStack.set(index, i);
}

}
