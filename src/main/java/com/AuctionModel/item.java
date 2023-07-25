package com.AuctionModel;

public class item {
	private int itemID;
	private int userID;
	private String itemName;
	private String description;
	private float minPrice;
	private String image;
	private String status;

	public item(int itemID, int userID, String itemName, String description, float minPrice, String image,
			String status) {

		this.itemID = itemID;
		this.userID = userID;
		this.itemName = itemName;
		this.description = description;
		this.minPrice = minPrice;
		this.image = image;
		this.status = status;
	}

	public int getItemID() {
		return itemID;
	}

	public int getUserID() {
		return userID;
	}

	public String getItemName() {
		return itemName;
	}

	public String getDescription() {
		return description;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public String getImage() {
		return image;
	}

	public String getStatus() {
		return status;
	}

}
