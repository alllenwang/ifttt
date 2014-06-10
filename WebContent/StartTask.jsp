<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.javalab03.*"%>
<!DOCTYPE html>
<%!
String username = null;
String taskName = null;
String taskState = null;
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

<title>StartTask</title>
</head>

<body
	class="t1 logged-out ms-windows asian zh-cn mobile-callout front-page swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading"
	data-fouc-class-names="swift-loading" dir="ltr">

	<%
	taskName = (String)request.getParameter("start[taskname]");
	taskState = (String)request.getParameter("state");
%>
	<%
if (taskName.compareTo("") != 0) {
	if (taskState.compareTo("paused") == 0)
		Task.setState(taskName, 1);
	else if (taskState.compareTo("running") == 0)
		Task.setState(taskName, 2);
}
			response.sendRedirect("ManageTasks.jsp");

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
									<!-- ---------------------------------- output ------------------------------------------ -->
								</h1>



							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>