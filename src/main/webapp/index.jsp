<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href=adminMenu.jsp><button>Admin Menu</button></a>
<br><br>
<form action="studentMenu" method="post">
Enter Student ID:
<br>
<input type="text" name="sid">
<br>
<input type="submit" value="Go to Student Menu">
</form>
</body>
</html>
<!-- <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">

		<div class="login-container">

			<div class="login-box">
				LOGIN
				<div id="login-form">
					<ul>
						<li id="tab-login" class="tab-bot-border">Student Login</li>
						<li id="tab-register">Admin Login</li>
					</ul>

					<input type="text" id="login-username" name="username"
						value="username"> <input type="password"
						id="login-password" name="password" value="password"> <a
						href="#">Forgot your password?</a>

					<button type="button">login</button>

				</div>

				REGISTER
				<div id="register-form">

					<ul>
						<li id="tab-login">Student Login</li>
						<li id="tab-register" class="tab-bot-border">Admin Login</li>
					</ul>
					
					<div class="tip-message" id="message-email">
						<span>We recommend a valid work email</span>
					</div>

					FIRST NAME
					<input type="text" id="register-firstname" name="firstname"
						onblur="if (this.value == '') {this.value = 'firstname';}"
						onfocus="if (this.value == 'firstname') {this.value = '';}"
						value="firstname" />

					LAST NAME
					<input type="text" id="register-lastname" name="lastname"
						onblur="if (this.value == '') {this.value = 'lastname';}"
						onfocus="if (this.value == 'lastname') {this.value = '';}"
						value="lastname" />

					PASSWORD
					<input type="password" id="register-password" name="password"
						value="password">

					<div class="password-tip-icon">
						<img
							src="http://leongaban.com/_projects/whoat/_HTML/img/question-icon.png"
							alt="?" />
					</div>
					<div class="tip-message" id="message-password">
						<span>Minimum 6 Characters</span>
					</div>

					<button type="button">login</button>

				</div>
				register-form

				<div class="form-background"></div>

			</div>
			login-form

		</div>
		login-container

	</div>
	container
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>
 -->
<!-- </body>

</html> -->
