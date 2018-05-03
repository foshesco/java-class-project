<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Create Course
<form action="createCourse">
Enter course number: <input type="text" name="coursenumber"><br>
Enter course title: <input type="text" name="classtitle"><br>
Enter hours: <input type="text" name="hours"><br>
Enter dept id(varchar 6): <input type="text" name="deptid"><br>
<input type="submit" value="Go">
</form>

Course Directory
<form action="courseDirectory">
<input type="submit">
</form>

<br><br><br>

Add Instructor
<form action="addInstructor">
Enter last name: <input type="text" name="lastname"><br>
Enter first name: <input type="text" name="firstname"><br>
Enter dept id(varchar 6): <input type="text" name="deptid"><br>
Enter office number(int 11): <input type="text" name="office"><br>
Enter phone number(varchar 15): <input type="text" name="phonenumber"><br>
Enter email(varchar 20): <input type="text" name="email"><br>
<input type="submit" value="Go">
</form>
<br><br>
<a href="index.jsp">Main Menu</a>
</body>
</html>