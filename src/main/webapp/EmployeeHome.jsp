<%@page import="com.ty.food_app.entity.User"%>
<%@page import="com.ty.food_app.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<style type="text/css">
body{
background-image: url("https://cdn.pixabay.com/photo/2021/10/10/18/20/super-6698001_1280.png");
background-position: center;
background-size: cover;
height: 560px;
}

</style>

</head>
<body>
<%
String phone =request.getParameter("User_Phone");
long phone1= Long.parseLong(phone);
UserDao userDao= new UserDao();
User user= userDao.findUserByPhone(phone1);
%>
<h1 style="text-align: center; color:White;">Welcome <%=user.getName()%></h1>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="ViewCustomer.jsp">View Customer & Order<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AddItem.jsp">Place Order</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ViewMenu1.jsp">View Menu</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Login.jsp">Logout</a>
      </li>
    </ul>
  </div>
</nav>
<h4></h4>
</body>
</html>
