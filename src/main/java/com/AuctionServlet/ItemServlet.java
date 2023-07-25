package com.AuctionServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AuctionModel.auctionDBUtil;
import com.AuctionModel.item;


@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		auctionDBUtil.getItemDetails();
		
		try {
		List<item> aucItems =auctionDBUtil.getItemDetails();
		request.setAttribute("aucItems",aucItems);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("bidItem.jsp");
		dis.forward(request, response);
	}

}
