<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.javalab03.*"%>
<!DOCTYPE html>
<%!
String username = null;
String taskName = null;
String taskType = null;
%>

<% username = (String)session.getAttribute("username"); %>
<% if (username == null) {
	response.sendRedirect("Welcome.jsp");
}
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./CUSTOMED/AddTask.css">

<title>UpdateTask</title>
</head>

<body
	class="t1 logged-out ms-windows asian zh-cn mobile-callout front-page swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading"
	data-fouc-class-names="swift-loading" dir="ltr">

	<%
	taskName = (String)request.getParameter("task[name]");
	taskType = (String)request.getParameter("task[type]");
%>
	<%
if (taskName.compareTo("") != 0) {
	System.out.println("0--0--0-0-0--0---------------------------------");
	if (taskType.compareTo("DateMail") == 0) {
		Task.updateTaskDateMail( 
				taskName, (String)request.getParameter("this[dateday]"),
				(String)request.getParameter("this[datetime]"),
				(String)request.getParameter("that[mailid]"),
				(String)request.getParameter("that[mailpassword]"),
				(String)request.getParameter("that[mailrecepients]"),
				(String)request.getParameter("that[mailsubject]"),
				(String)request.getParameter("that[mailcontent]")
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("DateWeibo") == 0) {
		Task.updateTaskDateWeibo(
				taskName, (String)request.getParameter("this[dateday]"),
				(String)request.getParameter("this[datetime]"),
				(String)request.getParameter("that[weiboid]"),
				(String)request.getParameter("that[weibopassword]"),
				(String)request.getParameter("that[weibocontent]")
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("MailMail") == 0) {
		Task.updateTaskMailMail(
				taskName, (String)request.getParameter("this[mailid]"),
				(String)request.getParameter("this[mailpassword]"),
				(String)request.getParameter("that[mailid]"),
				(String)request.getParameter("that[mailpassword]"),
				(String)request.getParameter("that[mailrecepients]"),
				(String)request.getParameter("that[mailsubject]"),
				(String)request.getParameter("that[mailcontent]")
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("MailWeibo") == 0) {
		System.out.println(
				taskName+ (String)request.getParameter("this[mailid]")+
				(String)request.getParameter("this[mailpassword]")+
				(String)request.getParameter("that[weiboid]")+
				(String)request.getParameter("that[weibopassword]")+
				(String)request.getParameter("that[weibocontent]")
				+ "---------------------------------------------------------");
		Task.updateTaskMailWeibo(
				taskName, (String)request.getParameter("this[mailid]"),
				(String)request.getParameter("this[mailpassword]"),
				(String)request.getParameter("that[weiboid]"),
				(String)request.getParameter("that[weibopassword]"),
				(String)request.getParameter("that[weibocontent]")
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("WeiboMail") == 0) {
		Task.updateTaskWeiboMail(
				taskName, (String)request.getParameter("this[weiboid]"),
				(String)request.getParameter("this[weibopassword]"),
				(String)request.getParameter("this[weibocontain]"),
				(String)request.getParameter("that[mailid]"),
				(String)request.getParameter("that[mailpassword]"),
				(String)request.getParameter("that[mailrecepients]"),
				(String)request.getParameter("that[mailsubject]"),
				(String)request.getParameter("that[mailcontent]")
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("WeiboWeibo") == 0) {
		Task.updateTaskWeiboWeibo(
					taskName, (String)request.getParameter("this[weiboid]"),
					(String)request.getParameter("this[weibopassword]"), 
					(String)request.getParameter("this[weibocontain]"),
					(String)request.getParameter("that[weiboid]"),
					(String)request.getParameter("that[weibopassword]"),
					(String)request.getParameter("that[weibocontent]")
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("DateRenren") == 0) {
		Task.updateTaskDateRenren(
					taskName, (String)request.getParameter("this[dateday]"),
					(String)request.getParameter("this[datetime]"),
					(String)request.getParameter("that[renrenid]"),
					(String)request.getParameter("that[renrenpassword]"),
					(String)request.getParameter("that[renrencontent]")
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	}
}
%>

	<div id="doc" class="">
		<div class="topbar js-topbar">
			<div id="banners" class="js-banners"></div>


			<div class="global-nav" data-section-term="top_nav">
				<div class="global-nav-inner">
					<div class="container"></div>
				</div>
			</div>


		</div>
		<div id="page-outer">
			<div id="page-container" class=" wrapper-front white">

				<div class="front-container " id="front-container">

					<div class="front-card">
						<div class="front-welcome">
							<div class="callout-copy">
								<h1>
									<%= taskType %></h1>

								<p><%= (String)request.getParameter("task[name]") %></p>
								<p><%= (String)request.getParameter("this[dateday]") %>
									<%= (String)request.getParameter("this[datetime]") %></p>
								<p><%= (String)request.getParameter("that[mailid]") %>
									<%= (String)request.getParameter("that[mailrecepients]") %>
									<%= (String)request.getParameter("that[mailsubject]") %>
									<%= (String)request.getParameter("that[mailcontent]") %></p>


							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>