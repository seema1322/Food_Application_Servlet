<%@page import="com.ty.food_app.entity.FoodProducts"%>
<%@page import="com.ty.food_app.entity.Menu"%>
<%@page import="com.ty.food_app.dao.MenuDao"%>
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
	margin-top: 100px;
	background-image:
		url("https://cdn.pixabay.com/photo/2018/03/06/17/40/paper-3204064_1280.jpg");
	color: #590458;
	background-repeat: no-repeat;
	background-size: cover;
}

span {
	margin-left: 30%;
	margin-left: 45%;
	font-size: xx-large;
	font-weight: 100;
}
h2 {
	margin-left: 65%;
	font-size: x-large;
	font-weight: 70;
}
h2 a{
	text-decoration: none;
}
</style>
</head>
<body>
	<h2>
		<a href="ManagerHome.jsp">Home</a>
	</h2>
	<span>Menu Details</span>
	<%
	MenuDao menuDao = new MenuDao();
	Menu menu = menuDao.getMenu();
	List<FoodProducts> list = menu.getFoodProducts();
	%>
	<table border="1" style="margin: 0 auto; margin-top: 0px; margin-top: 20px; background-color: #f4f2f5;">
		<tr>
			<th>Menu Id</th>
			<th>Food Id</th>
			<th>Food Name</th>
			<th>Food Type</th>
			<th>Food Price</th>
			<th>About</th>
			<th>Available?</th>
			<th>Action</th>
		</tr>
		<%
		if (list != null) {
			for (FoodProducts list1 : list) {
		%>

		<tr>
			<td><%=menu.getId()%></td>
			<td><%=list1.getId()%></td>
			<td><%=list1.getName()%></td>
			<td><%=list1.getType()%></td>
			<td><%=list1.getPrice()%></td>
			<td><%=list1.getAbout()%></td>
			<td><%=list1.getAvailability()%></td>
			<td><a href="deletefood?id=<%=list1.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		}
		%>

	</table>
</body>
</html>