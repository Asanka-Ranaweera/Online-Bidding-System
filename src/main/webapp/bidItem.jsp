<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css files/header.css">





</head>
<body>



	<h2 class="welcometext">WELCOME TO DREAM BID</h2>


	<!--icon bar-->

	<div class="icon-bar">
		<input type="text" class="search" placeholder="Search.."> <a
			href="../php/login.php" class="login">LOGIN</a> <a class="active"
			href="#" class="cart">CART</a>

	</div>





	<hr class="hrl">


	<ul class="menu">
		<li class="menu"><a href="#">HOME</a></li>
		<li class="menu"><a href="#">MY BID DETAILS</a></li>
		<li class="menu"><a href="WOMEN">WINNING ITEMS</a></li>
		<li class="menu"><a href="KID">FEED BACK</a></li>
		<li class="menu"><a href="ACCESSORIES"></a></li>
		<li class="menu"><a href="fabric.html"></a></li>
		<li class="menu"><a href="DESIGNER"></a></li>

	</ul>


	<c:forEach var="i1" items="${aucItems}">




		<div class="column">
			<a href="#"><img src="./image/${i1.image}" alt="item1"
				style="width: 90%"></a><br />
			<h3 style="text-align: center;">${i1.itemName}</h3>
			<h3 style="text-align: center;">${i1.minPrice}</h3>

			<center>
				<a href="getItemServlet?id=<c:out value='${i1.itemID }'/>"><button>BID
						NOW</button></a>
			</center>
		</div>




	</c:forEach>

</body>
</html>