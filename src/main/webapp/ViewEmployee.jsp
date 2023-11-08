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
		url("https://cdn.pixabay.com/photo/2018/03/06/17/40/paper-3204064_1280.jpg");
	color: #590458;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

h3 {
	margin-left: 30%;
}
</style>
</head>
<body>
	<h3>Employee Details</h3>
	<%
	UserDao userDao = new UserDao();
	//User user = (User) request.getAttribute("user");
	List<User> employees = userDao.displayAllEmployee();
	%>
	<table border="1" style="margin: 0 auto; margin-top: 70px">
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Phone</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
		<%
		if (employees != null) {
			for (User user1 : employees) {
		%>

		<tr>

			<td><%=user1.getId()%></td>
			<td><%=user1.getName()%></td>
			<td><%=user1.getPhone()%></td>
			<td><%=user1.getRole()%></td>
			<td><a href="deleteemployee?phone=<%=user1.getPhone()%>">Delete</a></td>

		</tr>
		<%
		}
		} 
		%>
	</table>
</body>
</html>