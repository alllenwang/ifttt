<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import="com.javalab03.*"%>
  
<%! String username = null;%>
<% username = (String)session.getAttribute("username"); %>
<% if (username == null)
	response.sendRedirect("Welcome.jsp");
	%>  
    
<%! String dest = null; %>
<% dest = (String)request.getParameter("message[recipient]"); %>
<%
	if (dest.compareTo("") != 0) {
		if ( Message.sendMessage(dest, (String)request.getParameter("message[content]"), username) ) {
			response.sendRedirect("./Inbox.jsp");
		} else {
			response.sendRedirect("./Inbox.jsp");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SendMessage</title>
</head>
<body>


</body>
</html>