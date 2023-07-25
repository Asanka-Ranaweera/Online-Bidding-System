package com.AuctionModel;

public class Bid {

	private int bidID;
	private int userID;
	private int itemID;
	private float amount;
	private int date;
	private String status;
	
	public Bid(int bidID, int userID, int itemID, float amount, int date, String status) {
		
		this.bidID = bidID;
		this.userID = userID;
		this.itemID = itemID;
		this.amount = amount;
		this.date = date;
		this.status = status;
	}
	public int getBidID() {
		return bidID;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public int getDate() {
		return date;
	}
	
	public String getStatus() {
		return status;
	}
		
	
}
