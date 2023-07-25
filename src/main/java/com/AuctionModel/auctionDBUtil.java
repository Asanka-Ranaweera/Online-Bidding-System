package com.AuctionModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.AuctionUtil.DBConnect;

//get item details
public class auctionDBUtil {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	private static boolean isSuccess;

	public static List<item> getItemDetails() {

		ArrayList<item> i1 = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from item ";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int itemID = rs.getInt(1);
				int userID = rs.getInt(2);
				String itemName = rs.getString(3);
				String description = rs.getString(4);
				float minPrice = rs.getFloat(5);
				String image = rs.getString(6);
				String status = rs.getString(7);

				item i2 = new item(itemID, userID, itemName, description, minPrice, image, status);
				i1.add(i2);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i1;
	}

	// get one item details
	
	public static List<item> getOneItem(String id) {

		int convertedID = Integer.parseInt(id);

		ArrayList<item> i3 = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from item where itemID = '" + convertedID + "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int itemID = rs.getInt(1);
				int userID = rs.getInt(2);
				String itemName = rs.getString(3);
				String description = rs.getString(4);
				float minPrice = rs.getFloat(5);
				String image = rs.getString(6);
				String status = rs.getString(7);

				item i4 = new item(itemID, userID, itemName, description, minPrice, image, status);
				i3.add(i4);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i3;

	}
	
	//get bid list 
	public static List<Bid> getBidList(String id) {
		int convertedID = Integer.parseInt(id);

		ArrayList<Bid> b1 = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from bid where itemID = '" + convertedID + "'";
			rs = stmt.executeQuery(sql + "ORDER BY bidID DESC");

			while (rs.next()) {
				int bidID = rs.getInt(1);
				int userID = rs.getInt(2);
				int itemID = rs.getInt(3);
				float amount = rs.getFloat(4);
				int date = rs.getInt(5);
				String status = rs.getString(6);

				Bid b2 = new Bid(bidID, userID, itemID, amount, date, status);
				b1.add(b2);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return b1;

	}
	
    // calculate max bid 
	
	public static float Calmax(int convertedID, float convertedFloat) {
		int id = convertedID;
		float value = convertedFloat;
		float max = 0;
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select amount from bid where itemID ='" + id + "'";
			rs = stmt.executeQuery(sql + "max(amount)");

			while (rs.next()) {

				if (max < rs.getFloat(4)) {
					max = rs.getFloat(4);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return max;
	}
   
	// insert bid amount
	public static boolean insertBid(String id, String value) {

		boolean isSuccess = false;
		int convertedID = Integer.parseInt(id);
		float convertedFloat = Float.parseFloat(value);
		float Max = 0;
		Max = Calmax(convertedID, convertedFloat);
		if (Max < convertedFloat) {

			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();

				String sql = "insert into bid(itemID,amount) values ('" + convertedID + "','" + convertedFloat + "')";
				int rs = stmt.executeUpdate(sql);

				if (rs > 0) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return isSuccess;

		} else {
			return isSuccess = false;
		}
	}

	public static List<Bid> getLastBid(String id) {

		int convertedID2 = Integer.parseInt(id);

		ArrayList<Bid> b3 = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from bid where itemID = '" + convertedID2 + "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int bidID = rs.getInt(1);
				int userID = rs.getInt(2);
				int itemID = rs.getInt(3);
				float amount = rs.getFloat(4);
				int date = rs.getInt(5);
				String status = rs.getString(6);

				Bid b4 = new Bid(bidID, userID, itemID, amount, date, status);
				b3.add(b4);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return b3;
	}
    //update amount
	public static boolean updateBidAmount(String amount)

	{

		float convertedAmount = Float.parseFloat(amount);
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update bid set amount = '" + convertedAmount + "'" + "where amount ='" + convertedAmount
					+ "'";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

}
