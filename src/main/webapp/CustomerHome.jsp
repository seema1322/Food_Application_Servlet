<%@page import="com.ty.food_app.entity.FoodOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.food_app.entity.User"%>
<%@page import="com.ty.food_app.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background-image: url("https://cdn.pixabay.com/photo/2017/09/22/21/43/table-2777180_1280.jpg");
background-size:cover;
background-repeat:no-repeat;
color: black;
}
h3{
background-color: #ccb8b8;
text-align: center;
margin-top: 30px;
}
</style>
</head>
<body>
	<%
	UserDao userDao = new UserDao();
	long phone= Long.parseLong(request.getParameter("User_Phone"));
	//User user = (User) request.getAttribute("user");
	User customer = userDao.findUserByPhone(phone);
	List<FoodOrder> orders= customer.getFoodOrders();
	%>
	<h3>WEL-COME <%=customer.getName().toUpperCase()%></h3>
	<table border="1" style="margin-left:25%; margin-top: 65px; background-color: #e0dada;" cellspacing=2px, cellpadding=5px>
		<tr>
			<th>Order Id</th>
			<th>Order Status</th>
			<th>Total Price</th>
			<th>Order Created Time</th>
			<th>Order Created Time</th>
		</tr>
		<%
		if (orders != null) {
			for (FoodOrder order : orders) {
		%>

		<tr>
			<td><%=order.getId()%></td>
			<td><%=order.getStatus()%></td>
			<td><%=order.getTotalPrice()%></td>
			<td><%=order.getOrderCreatedTime()%></td>
			<td><%=order.getOrderCreatedTime()%></td>
		</tr>
		<%
		}
		}
		%>
	</table><br>

</body>
</html>