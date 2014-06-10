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
	String taskName = (String)request.getParameter("delete[taskname]");
	if (taskName.compareTo("") != 0) {
		Task.delete(taskName);
	}
	response.sendRedirect("ManageTasks.jsp");
	%>

</body>
</html>