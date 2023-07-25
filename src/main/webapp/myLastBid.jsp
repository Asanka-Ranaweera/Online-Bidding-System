<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Bid list</title>
</head>
<body>


	<center><a href=" "><button>Y O U R     B I D     V A L U E</button></a></center>
	
	
		
	<form action="myBid" method="get">
	
	

	<input type="submit" name ="submit" value="ubdt"><br><br><br>
	Your Bid Value  :  <input type="text" name="amount" value = " ">
	
	</form>
	

	
		
		
	<c:forEach var ="b3" items ="${lastBid}">
	
	${b3.amount}
	
	${b3.bidID}
	
	</c:forEach>
	
</body>
</html>