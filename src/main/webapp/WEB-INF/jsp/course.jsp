<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*, com.ustglobal.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Directory</title>
</head>
<body>

<h1> Course Directory </h1>
		<table width="800" border="2.5">
			<tr height="50">
			
				<th><b><font size="4">Course Number</font></b></th>
				<th><b><font size="4">Course Title</font></b></th>
				<th><b><font size="4">Hours</font></b></th>
				<th><b><font size="4">Department ID</font></b></th>
			</tr>
		
			<c:forEach items="${course}" var="course">
				<tr>

					<td>${course.coursenumber}</td>
					<td>${course.classtitle}</td>
					<td>${course.hours}</td>
					<td>${course.deptid}</td>

				</tr>
			</c:forEach>
		</table>
		<br><br><br>
<a href="index">Add Course</a>

</body>
</html>