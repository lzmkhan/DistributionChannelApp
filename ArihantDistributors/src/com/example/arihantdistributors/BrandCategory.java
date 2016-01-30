package com.example.arihantdistributors;

public class BrandCategory {

	private int brandID;
	private String brandImageURL;
	private String brandCatName;
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public String getBrandCatName() {
		return brandCatName;
	}
	public void setBrandID(String brandCatName) {
		this.brandCatName = brandCatName;
	}
	public String getBrandImageURL() {
		return brandImageURL;
	}
	public void setBrandImageURL(String brandImageURL) {
		this.brandImageURL = brandImageURL;
	}
	public BrandCategory(int brandID, String brandImageURL, String brandCatName) {
		super();
		this.brandID = brandID;
		this.brandImageURL = brandImageURL;
		this.brandCatName = brandCatName;
	}
	
}
