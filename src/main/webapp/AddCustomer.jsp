<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style2.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h3>
			<a href="EmployeeHome.jsp">Home</a>
		</h3>
		<div class="text">Add Customer Details</div>
		<form action="addcustomer" method="post">
			<div class="form-row"></div>
			<div class="form-row">
				<div class="input-data">
					<input type="text" name="Name" required>
					<div class="underline"></div>
					<label for="">Customer Name</label>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data">
					<input type="text" name="phone" required>
					<div class="underline"></div>
					<label for="">Customer Phone</label>
				</div>
				<div class="input-data">
					<input type="password" name="Password" required>
					<div class="underline"></div>
					<label for="">Password</label>
				</div>
			</div>

			<div class="form-row submit-btn">
				<div class="input-data">
					<div class="inner"></div>
					<input type="submit" value="submit">
				</div>
			</div>
		</form>
	</div>

</body>
</html>