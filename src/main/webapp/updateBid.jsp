<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



		<%
			String bidID = request.getParameter("bidID");
			String amount = request.getParameter("amount");
		%>



		<form action="updateBidServlet" method="post">
		Your Bid
			
			<input type="text" name="amount" value="<%= amount%>"><br>
			
			<input type="submit" name="submit" value="Update Amount" class="btn">
	
		</form>



</body>
</html>