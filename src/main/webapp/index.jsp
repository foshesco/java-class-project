<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css"/>
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!--
<form action="studentMenu" method="post">
Enter Student ID:
<br>
<input type="text" name="sid">
<br>
<input type="submit" value="Go to Student Menu">
</form>
-->
</head>

<body>
<div class="form-wrap">
		<div class="tabs">
			<h3 class="student-tab"><a class="active" href="#student-tab-content">Student Login</a></h3>
			<h3 class="admin-tab"><a href="#admin-tab-content">Admin Login</a></h3>
		</div><!--.tabs-->

		<div class="tabs-content">
			<div id="student-tab-content" class="active">
				<form class="student-login-form" action="studentMenuController" method="post">
					<input type="text" class="input" id="user_login" autocomplete="off" placeholder="Student ID">
					<input type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
					<input type="checkbox" class="checkbox" id="remember_me">
					<label for="remember_me">Remember me</label>
					<input type="submit" class="button" value="Login">
				</form><!--.login-form-->
				<div class="help-text">
					<p><a href="#">Forget your password?</a></p>
				</div><!--.help-text-->
			</div><!--.signup-tab-content-->

			<div id="admin-tab-content">
				<form class="admin-login-form" action="adminMenu.jsp" method="post">
					<input type="text" class="input" id="user_login" autocomplete="off" placeholder="Admin ID">
					<input type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
					<input type="checkbox" class="checkbox" id="remember_me">
					<label for="remember_me">Remember me</label>
					<input type="submit" class="button" value="Login">
				</form><!--.login-form-->
				<div class="help-text">
					<p><a href="#">Forget your password?</a></p>
				</div><!--.help-text-->
			</div><!--.login-tab-content-->
		</div><!--.tabs-content-->
	</div><!--.form-wrap-->
</body>

</html>
