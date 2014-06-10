<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.javalab03.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DeleteUser</title>
</head>
<body>

	<% 
	String userName = (String)request.getParameter("user-name");
	
	if (userName.compareTo("") != 0) {
		User.deleteUser(userName);
	}
	response.sendRedirect("./ServerUserInfo.jsp");
	%>

</body>
</html>