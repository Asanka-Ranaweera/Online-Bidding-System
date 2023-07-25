<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="./css files/selectItem.css">
</head>
<body>




	<c:forEach var="i1" items="${aucItems}">

		<c:set var="itemID" value="${i1.itemID}" />
		<c:set var="userID" value="${i1.userID}" />
		<c:set var="itemName" value="${i1.itemName}" />
		<c:set var="description" value="${i1.description}" />
		<c:set var="minPrice" value="${i1.minPrice}" />
		<c:set var="image" value="${i1.image}" />
		<c:set var="status" value="${i1.status}" />




		<div class="small-container single-product">
			<div class="row">
				<div class="col-2">
					<img src="./image/${i1.image}" width="100%">

				</div>





				<div class="col-2">
					<p>Item-Mobile</p>
					<h1>${i1.itemName}</h1>
					<h4>${i1.minPrice}</h4>

					<form action="bidInsertServlet" method="get">
						<input type="text" name="amount" required
							placeholder="Enter your bid"> <input type="hidden"
							name=id value='${i1.itemID}'> <input type="submit"
							name="submit" value="Add Amount" class="btn">

					</form>


					<h3>
						Product Details<i class="fa fa-indent"></i>
					</h3>
					<br>
					<p>${i1.description}</p>
				</div>

			</div>
		</div>

	</c:forEach>



	<hr>
	<center>
		<h2>S H O W    B I D    L I S T</h2>
		</ceter>
		<hr>



		<table>

			<center>
				<tr>
					<th>ID</th>
					<th>------------</th>
					<th>Amount</th>
				</tr>

			</center>
			<c:forEach var="b1" items="${bidItems}">


				<c:set var="bidID" value="${b1.bidID}" />
				<c:set var="amount" value="${b1.amount}" />

				<center>

					<tr>
						<td>${b1.bidID}</td>
						<td>-------------</td>
						<td>${b1.amount}</td>
					</tr>
				</center>
			</c:forEach>

		</table>

		<c:url value="updateBid.jsp" var="updateBid">
			<c:param name="bidID" value="${bidID}" />
			<c:param name="amount" value="${amount}" />
		</c:url>

		<a href="${updateBid}"> <input type="button" name="update"
			value="Update My Amount">
		</a>
</body>
</html>