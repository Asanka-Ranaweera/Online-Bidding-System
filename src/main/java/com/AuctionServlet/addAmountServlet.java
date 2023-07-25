package com.AuctionServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AuctionModel.auctionDBUtil;


@WebServlet("/addAmountServlet")
public class addAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id    = request.getParameter("id");
		String value = request.getParameter("amount");
		
		boolean isTrue;
		isTrue =auctionDBUtil.insertBid(id,value);

		
		if (isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("selectItem.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	
	}
		
		
	}


