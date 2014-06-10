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

<title>AddTask</title>
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
	if (taskType.compareTo("DateMail") == 0) {
		Task.addTaskDateMail(
				taskName, (String)request.getParameter("this[dateday]"),
				(String)request.getParameter("this[datetime]"),
				(String)request.getParameter("that[mailid]"),
				(String)request.getParameter("that[mailpassword]"),
				(String)request.getParameter("that[mailrecepients]"),
				(String)request.getParameter("that[mailsubject]"),
				(String)request.getParameter("that[mailcontent]"),
				username
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("DateWeibo") == 0) {
		Task.addTaskDateWeibo(
				taskName, (String)request.getParameter("this[dateday]"),
				(String)request.getParameter("this[datetime]"),
				(String)request.getParameter("that[weiboid]"),
				(String)request.getParameter("that[weibopassword]"),
				(String)request.getParameter("that[weibocontent]"),
				username
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("MailMail") == 0) {
		Task.addTaskMailMail(
				taskName, (String)request.getParameter("this[mailid]"),
				(String)request.getParameter("this[mailpassword]"),
				(String)request.getParameter("that[mailid]"),
				(String)request.getParameter("that[mailpassword]"),
				(String)request.getParameter("that[mailrecepients]"),
				(String)request.getParameter("that[mailsubject]"),
				(String)request.getParameter("that[mailcontent]"),
				username
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("MailWeibo") == 0) {
		System.out.println(taskType + taskName+
				(String)request.getParameter("this[mailid]")+
				(String)request.getParameter("this[mailpassword]")+
				(String)request.getParameter("that[weiboid]")+
				(String)request.getParameter("that[weibopassword]")+
				(String)request.getParameter("that[weibocontent]")+
				username
				);
		System.out.print(Task.addTaskMailWeibo(
				taskName, (String)request.getParameter("this[mailid]"),
				(String)request.getParameter("this[mailpassword]"),
				(String)request.getParameter("that[weiboid]"),
				(String)request.getParameter("that[weibopassword]"),
				(String)request.getParameter("that[weibocontent]"),
				username)
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("WeiboMail") == 0) {
		System.out.println(taskType + taskName+ (String)request.getParameter("this[weiboid]")+
				(String)request.getParameter("this[weibopassword]")+ 
				(String)request.getParameter("this[weibocontain]")+
				(String)request.getParameter("that[mailid]")+
				(String)request.getParameter("that[mailpassword]")+
				(String)request.getParameter("that[mailrecepients]")+
				(String)request.getParameter("that[mailsubject]")+
				(String)request.getParameter("that[mailcontent]")+
				username);
		Task.addTaskWeiboMail(
				taskName, (String)request.getParameter("this[weiboid]"),
				(String)request.getParameter("this[weibopassword]"),
				(String)request.getParameter("this[weibocontain]"),		
				(String)request.getParameter("that[mailid]"),
				(String)request.getParameter("that[mailpassword]"),
				(String)request.getParameter("that[mailrecepients]"),
				(String)request.getParameter("that[mailsubject]"),
				(String)request.getParameter("that[mailcontent]"),
				username
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("WeiboWeibo") == 0) {
		Task.addTaskWeiboWeibo(
					taskName, (String)request.getParameter("this[weiboid]"),
					(String)request.getParameter("this[weibopassword]"),
					(String)request.getParameter("this[weibocontain]"),	
					(String)request.getParameter("that[weiboid]"),
					(String)request.getParameter("that[weibopassword]"),
					(String)request.getParameter("that[weibocontent]"),
				username
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	} else if (taskType.compareTo("DateRenren") == 0) {
		Task.addTaskDateRenren(
					taskName, (String)request.getParameter("this[dateday]"),
					(String)request.getParameter("this[datetime]"),
					(String)request.getParameter("that[renrenid]"),
					(String)request.getParameter("that[renrenpassword]"),
					(String)request.getParameter("that[renrencontent]"),
				username
			);
			response.setHeader("refresh", "3; url=./ManageTasks.jsp");
	}
	Task a = new Task(taskName, taskType);
	a.start();
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