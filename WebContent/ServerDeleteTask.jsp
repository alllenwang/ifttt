<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.javalab03.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DeleteTask</title>
</head>
<body>

	<% 
	String taskName = (String)request.getParameter("task-name");
	
	if (taskName.compareTo("") != 0) {
		Task.delete(taskName);
	}
	response.sendRedirect("./ServerTaskInfo.jsp");
	%>

</body>
</html>