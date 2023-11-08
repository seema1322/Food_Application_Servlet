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
		<div class="text">Add Items</div>

		<form action="placeorder" method="get">
			<div class="form-row"></div>
			<div class="form-row">
				<div class="input-data">
					<input type="text" name="productid" required>
					<div class="underline"></div>
					<label for="">Food Product Id</label>
				</div>
				<div class="input-data">
					<input type="text" name="quantity" required>
					<div class="underline"></div>
					<label for="">Quantities</label>
				</div>
			</div>
			<div class="form-row submit-btn">
				<div class="input-data">
					<div class="inner"></div>
					<input type="submit" value="Add Item">
				</div>
			</div>
		</form>
	</div>

</body>
</html>