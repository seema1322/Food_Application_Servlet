<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Create Account</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="nunito-font.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="style1.css"/>
</head>
<body class="form-v9">
	<div class="page-content">
		<div class="form-v9-content" style="background-image: url('images/form-v9.jpg')">
			<form class="form-detail" action="signup">
				<h2>Registration Form</h2>
				<div class="form-row-total">
					<div class="form-row">
						<input type="text" name="User_Name" id="full-name" class="input-text" placeholder="Your Name" required>
					</div>
					<div class="form-row">
						<input type="text" name="User_Phone" id="your-email" class="input-text" placeholder="Your Phone Number" required>
					</div>
				</div>
				<div class="form-row-total">
					<div class="form-row">
						<input type="password" name="Password" id="password" class="input-text" placeholder="Your Password" required>
					</div>
					<div class="form-row">
						<input type="text" name="User_Role" id="comfirm-password" class="input-text" placeholder="Manager" disabled="disabled">
					</div>
				</div>
				<div class="form-row-total">
					<div class="form-row">
						<input type="text" name="Branch_name" id="password" class="input-text" placeholder="Your Branch Name" required>
					</div>
					<div class="form-row">
						<input type="text" name="Branch_Address" id="comfirm-password" class="input-text" placeholder="Your Branch Address" required="required">
					</div>
				</div>
				<div class="form-row-total">
					<div class="form-row">
						<input type="text" name="Branch_Phone" id="password" class="input-text" placeholder="Your Branch Phone Number" required>
					</div>
					<div class="form-row">
						<input type="text" name="Branch_Email" id="comfirm-password" class="input-text" placeholder="Your Branch Email" required="required">
					</div>
				</div>
				
				<div class="form-row-last">
					<input type="submit" name="register" class="register" value="Register">
				</div>
			</form>
		</div>
	</div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>