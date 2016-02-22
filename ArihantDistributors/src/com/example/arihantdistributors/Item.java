package com.example.arihantdistributors;

public class Item {

	private String ItemID;
	private String ItemName;
	private String ItemPrice;
	private String ItemRetPrice;
	private String Usage;
	private String Capacity;
	public String getItemRetPrice() {
		return ItemRetPrice;
	}
	public void setItemRetPrice(String itemRetPrice) {
		ItemRetPrice = itemRetPrice;
	}
	public String getUsage() {
		return Usage;
	}
	public void setUsage(String usage) {
		Usage = usage;
	}
	public String getCapacity() {
		return Capacity;
	}
	public void setCapacity(String capacity) {
		Capacity = capacity;
	}
	public String getBrandID() {
		return BrandID;
	}
	public void setBrandID(String brandID) {
		BrandID = brandID;
	}
	public String getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}
	private String BrandID;
	private String CategoryID;
	public Item(String itemID, String itemName, String itemPrice, String itemRetPrice, String usage, String capacity, String brandID,
			String categoryID, String itemImageURL, String itemDesc) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		ItemPrice = itemPrice;
		ItemRetPrice = itemRetPrice;
		Usage = usage;
		Capacity = capacity;
		BrandID = brandID;
		CategoryID = categoryID;
		ItemImageURL = itemImageURL;
		ItemDesc = itemDesc;
	}
	private String ItemImageURL;
	private String ItemDesc;
	private int itemQnty;
	
	public int getItemQnty() {
		return itemQnty;
	}
	public void setItemQnty(int itemQnty) {
		this.itemQnty = itemQnty;
	}
	public Item(String itemID, String itemName, String itemPrice, String itemImageURL, String itemDesc) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		ItemPrice = itemPrice;
		ItemImageURL = itemImageURL;
		ItemDesc = itemDesc;
	}
	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemPrice() {
		return ItemPrice;
	}
	public void setItemPrice(String itemPrice) {
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
	public Item(String itemID, String itemName, String itemPrice, String itemImageURL, String itemDesc, int itemQnty) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		ItemPrice = itemPrice;
		ItemImageURL = itemImageURL;
		ItemDesc = itemDesc;
		this.itemQnty = itemQnty;
	}
	
	
}
