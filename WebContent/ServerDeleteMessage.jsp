<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.javalab03.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DeleteMessage</title>
</head>
<body>

	<% 
	String userName = (String)request.getParameter("delete-username");
	
	System.out.println(userName + (String)request.getParameter("delete-day") +
			(String)request.getParameter("delete-time") +
			(String)request.getParameter("delete-sender"));
	if (userName.compareTo("") != 0) {
		Message.deleteMessage(userName, 
				(String)request.getParameter("delete-day"), 
				(String)request.getParameter("delete-time"), 
				(String)request.getParameter("delete-sender"));
	}
	response.sendRedirect("./ServerMessageInfo.jsp");
	%>

</body>
</html>