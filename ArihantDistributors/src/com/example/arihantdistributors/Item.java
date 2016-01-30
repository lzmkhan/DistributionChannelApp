package com.example.arihantdistributors;

public class Item {

	private int ItemID;
	private String ItemName;
	private int ItemPrice;
	private String ItemImageURL;
	private String ItemDesc;
	private int itemQnty;
	
	public int getItemQnty() {
		return itemQnty;
	}
	public void setItemQnty(int itemQnty) {
		this.itemQnty = itemQnty;
	}
	public Item(int itemID, String itemName, int itemPrice, String itemImageURL, String itemDesc) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		ItemPrice = itemPrice;
		ItemImageURL = itemImageURL;
		ItemDesc = itemDesc;
	}
	public int getItemID() {
		return ItemID;
	}
	public void setItemID(int itemID) {
		ItemID = itemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getItemPrice() {
		return ItemPrice;
	}
	public void setItemPrice(int itemPrice) {
		ItemPrice = itemPrice;
	}
	public String getItemImageURL() {
		return ItemImageURL;
	}
	public void setItemImageURL(String itemImageURL) {
		ItemImageURL = itemImageURL;
	}
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	public Item(int itemID, String itemName, int itemPrice, String itemImageURL, String itemDesc, int itemQnty) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		ItemPrice = itemPrice;
		ItemImageURL = itemImageURL;
		ItemDesc = itemDesc;
		this.itemQnty = itemQnty;
	}
	
	
}
