<%@page import="com.ty.food_app.dao.ItemDao"%>
<%@page import="com.ty.food_app.entity.User"%>
<%@page import="com.ty.food_app.dao.UserDao"%>
<%@page import="com.ty.food_app.entity.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.food_app.entity.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add list of items</title>
<style type="text/css">
body{
background-image: url("https://cdn.pixabay.com/photo/2018/03/02/13/38/vegetables-3193197_1280.jpg");
background-repeat:no-repeat;
background-size:cover;
width:90%;
color: #e0dae3;
}
h3 a{
text-decoration: none;
}
</style>
</head>
<body>
	<h3><a href="PlaceOrderExist.jsp">Add Items</a></h3>
	<%
	ItemDao itemDao = new ItemDao();
	List<Item> items = itemDao.displayAllItems();
	%>
	<table border="1" style="margin-top: 70px; background-color: #676469;">
		<tr>
			<th>Item Id</th>
			<th>Item Name</th>
			<th>Item Price</th>
			<th>Item Type</th>
			<th>quantity</th>
		</tr>
		<%
		if (items != null) {
			for (Item item : items) {
		%>

		<tr>

			<td><%=item.getId()%></td>
			<td><%=item.getName()%></td>
			<td><%=item.getPrice()%></td>
			<td><%=item.getType()%></td>
			<td><%=item.getQuantity()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<br><br>
	<form action="mapcustomerorder" method="get">
	
	<input type="text" name="Phone" placeholder="Enter Customer Phone"><br><br>

	<input type="text" name="Products" placeholder="Enter Item Id to place order"><br><br>
	
	<input type= "submit" value="Add">
	</form>
</body>
</html>