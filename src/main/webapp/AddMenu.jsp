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
			<a href="ManagerHome.jsp">Home</a>
		</h3>
		<div class="text">Add Menu Details</div>
		<form action="addmenu" method="post">
			<div class="form-row"></div>
			<div class="form-row">
				<div class="input-data">
					<input type="text" name="Name" required>
					<div class="underline"></div>
					<label for="">Food Product Name</label>
				</div>
				<div class="input-data">
					<input type="text" name="Type" required>
					<div class="underline"></div>
					<label for="">Type of food</label>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data">
					<input type="text" name="Price" required>
					<div class="underline"></div>
					<label for="">Price</label>
				</div>
				<div class="input-data">
					<input type="text" name="Avail" required>
					<div class="underline"></div>
					<label for="">Availability</label>
				</div>
			</div>
			<div class="form-row">
				<div class="input-data textarea">
					<textarea rows="8" cols="80" name="About" required></textarea>
					<br />
					<div class="underline"></div>
					<label for="">About Food</label>

					<div class="form-row submit-btn">
						<div class="input-data">
							<div class="inner"></div>
							<input type="submit" value="submit">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
</html>