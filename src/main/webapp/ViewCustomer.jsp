<%@page import="com.ty.food_app.entity.FoodOrder"%>
<%@page import="com.ty.food_app.dao.FoodOrderDao"%>
<%@page import="com.ty.food_app.dao.UserDao"%>
<%@page import="com.ty.food_app.entity.User"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin-top: 30px;
	background-image:
		url("https://cdn.pixabay.com/photo/2017/06/27/08/12/coffee-2446640_1280.jpg");
	color: #590458;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

h3 {
	margin-left: 30%;
	text-align: center;
}
button {
	margin-left: 70%;
	height: 60px;
	background-color: #e0dada;
	color: #590458;
	border-radius: 25%;
}
button a{
	text-decoration: none;
}
</style>
</head>
<body>
	<button><a href="AddCustomer.jsp">Add Customer</a></button>
	<h3>Customer Details</h3>
	<%
	UserDao userDao = new UserDao();
	//User user = (User) request.getAttribute("user");
	List<User> customers = userDao.displayAllCustomer();
	%>
	<table border="1" style="margin-left:52%; margin-top: 35px; background-color: #e0dada;" cellspacing=2px, cellpadding=5px>
		<tr>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Customer Phone</th>
		</tr>
		<%
		if (customers != null) {
			for (User user1 : customers) {
		%>

		<tr>
			<td><%=user1.getId()%></td>
			<td><%=user1.getName()%></td>
			<td><%=user1.getPhone()%></td>
		</tr>
		<%
		}
		}
		%>
	</table><br>
	
	<%
	FoodOrderDao fDao= new FoodOrderDao();
	//User user = (User) request.getAttribute("user");
	List<FoodOrder> orders = fDao.displayAllOrders();
	%>
	<h3>Order Details</h3>
	<table border="1" style="margin-left:36%; margin-top: 35px; background-color: #e0dada;" cellspacing=2px, cellpadding=5px>
		<tr>
			<th>Order Id</th>
			<th>Order Status</th>
			<th>Customer Phone</th>
			<th>Customer Name</th>
			<th>Order Created Time</th>
			<th>Delivered?</th>
		</tr>
		<%
		if (orders != null) {
			for (FoodOrder order : orders) {
		%>

		<tr>
			<td><%=order.getId()%></td>
			<td><%=order.getStatus()%></td>
			<td><%=order.getContactNumber()%></td>
			<td><%=order.getCustomerName()%></td>
			<td><%=order.getOrderCreatedTime()%></td>
			<td><a href="changestatus?id=<%=order.getId()%>">Yes</a></td>
		</tr>
		<%
		}
		}
		%>
	</table><br>
	
</body>
</html>