<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Student ID: ${sid}
<br>
Add Course Number
<form action="addCourse">
<input type="text" name="cno">
<input type="submit">
</form>

<br><br>

Drop Course Number
<form action="dropCourse">
<input type="text" name="cno">
<input type="submit">
</form>

<br><br>

Pay School Fees
<form action="payFee">
Enter SID: <input type="text" name="sid">
<input type="submit">
</form>

<br><br>

<form action="quit">
<input type="submit" value="Log Off">
</form>
<br><br>
<a href="index.jsp"><button>Main Menu</button></a>
</body>
</html>