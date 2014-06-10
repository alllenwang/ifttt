<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%	session.setAttribute("username", null);
	session.setAttribute("isadmin", false);
	response.sendRedirect("Welcome.jsp");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignOut</title>
</head>
<body>

</body>
</html>