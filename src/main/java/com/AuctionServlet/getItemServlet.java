package com.AuctionServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AuctionModel.Bid;
import com.AuctionModel.auctionDBUtil;
import com.AuctionModel.item;

@WebServlet("/getItemServlet")
public class getItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		
		
		auctionDBUtil.getOneItem(id);
		auctionDBUtil.getBidList(id);
		
		
		try {
		List<item> aucItems =auctionDBUtil.getOneItem(id);
		request.setAttribute("aucItems",aucItems);
		
		List<Bid> bidItems =auctionDBUtil.getBidList(id);
		request.setAttribute("bidItems",bidItems);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("selectItem.jsp");
		dis.forward(request, response);
	}

	

}
