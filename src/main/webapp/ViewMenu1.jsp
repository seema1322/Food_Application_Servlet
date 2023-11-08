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
	margin-top: 30px;
	background-image:
		url("https://cdn.pixabay.com/photo/2017/10/01/13/09/background-2805422_1280.jpg");
	color: black;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

h3{
font-weight: bolder;
text-align: center;
margin-top: 30px;
margin-left: 5%;
font-size: xx-large;
}

span {
	margin-left: 20%;
	background-color: #d6bfe3;
	background-size: cover;
	font-size: xx-large;
}
span a{
	text-decoration: none;
}
</style>
</head>
<body>
	<span>
		<a href="EmployeeHome.jsp">Home</a>
	</span>
	<h3>Menu Details</h3>
	<%
	MenuDao menuDao = new MenuDao();
	Menu menu = menuDao.getMenu();
	List<FoodProducts> list = menu.getFoodProducts();
	%>
	<table border="1" style="margin: 0 auto; margin-top: 0px; background-color: #e0dada;" cellspacing=2px, cellpadding=5px>
		<tr>
			<th>Menu Id</th>
			<th>Food Id</th>
			<th>Food Name</th>
			<th>Food Type</th>
			<th>Food Price</th>
			<th>About</th>
			<th>Available?</th>
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
		</tr>
		<%
		}
		}
		%>

	</table>
</body>
</html>