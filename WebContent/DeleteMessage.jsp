<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.javalab03.*"%>

<%! String username = null; %>
<% username = (String)session.getAttribute("username"); %>
<% if (username == null)
	response.sendRedirect("Welcome.jsp");
	%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DeleteTask</title>
</head>
<body>

	<% 
	String senderName = (String)request.getParameter("message[sender]");
	if (senderName.compareTo("") != 0) {
		Message.deleteMessage(username, 
				(String)request.getParameter("message[day]"), 
				(String)request.getParameter("message[time]"), senderName);
	}
	response.sendRedirect("Inbox.jsp");
	%>

</body>
</html>