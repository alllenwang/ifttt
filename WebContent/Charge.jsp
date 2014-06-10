<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.javalab03.*"%>
    
 <%! String username = null; %>
<% username = (String)session.getAttribute("username"); %>
<% if (username == null) {
	response.sendRedirect("Welcome.jsp");
}
	%>
	   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Charge</title>
</head>
<body>
<%
	User.charge(username, (String)request.getParameter("charge[amount]"));
	response.sendRedirect("UserHome.jsp");
%>
</body>
</html>