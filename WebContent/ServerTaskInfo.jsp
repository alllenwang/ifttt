<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.javalab03.*"%>
	<%! String username = null; %>
<% username = (String)session.getAttribute("username"); %>
<% if (username.compareTo("admin") != 0)
	response.sendRedirect("Welcome.jsp");
	%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>TaskInfo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="./BOOTSTRAP/bootstrap.css" rel="stylesheet">
<style type="text/css">
.wrapper.black {
	background: url(./IMAGE/wash-black-30.png);
}

.wrapper.white {
	background: url(./IMAGE/wash-white-30.png);
}

body {
	background-image: url(./IMAGE/bg.png);
	background-position: left 40px;
	background-attachment: fixed;
	background-repeat: repeat;
	background-repeat: no-repeat;
	background-color: #C0DEED;
}
.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link href="./BOOTSTRAP/bootstrap-responsive.css" rel="stylesheet">
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="./ServerHome.jsp">Home</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">Logged in as Server.</p>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="hero-unit">
					<h1>Task Information</h1>
				</div>
				<div class="row-fluid">


					<% ServerTaskNameList.setList(); %>
					<% for (int i = 0; i < ServerTaskNameList.list.size(); i++) { %>
					<div class="row-fluid">
						<div class="span12 well">

							<form action="./ServerDeleteTask.jsp" method="post">
								<h2 class="message-sender">
									<%= ServerTaskNameList.list.get(i).TaskName + " " + ServerTaskNameList.list.get(i).TaskType%>
									<span class="separator"> </span> <small class="time"> <% if(ServerTaskNameList.list.get(i).TaskType == "DateMail"){ %>
										<p>
											Created Date :
											<%= TableTaskDateMail.createDay(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Created Time :
											<%= TableTaskDateMail.createTime(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Date :
											<%= TableTaskDateMail.date(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Time :
											<%= TableTaskDateMail.time(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Send MailID :
											<%= TableTaskDateMail.sendMailID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Send MailPassword :
											<%= TableTaskDateMail.sendMailPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Receive MailID :
											<%= TableTaskDateMail.receiveMailID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Subject :
											<%= TableTaskDateMail.subject(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Text :
											<%= TableTaskDateMail.text(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											User Name :
											<%= TableTaskDateMail.userName(ServerTaskNameList.list.get(i).TaskName) %></p>
										<%if(TableTaskDateMail.state(ServerTaskNameList.list.get(i).TaskName) == 1){ %>
										<p>State : This task is running.</p> <%} else if(TableTaskDateMail.state(ServerTaskNameList.list.get(i).TaskName) == 2) {%>
										<p>State : This task is paused.</p> <%} else if(TableTaskDateMail.state(ServerTaskNameList.list.get(i).TaskName) == 3) { %>
										<p>State : This task has been finished.</p> <%} %> <% } else if(ServerTaskNameList.list.get(i).TaskType == "DateWeibo"){%>
										<p>
											Created Date :
											<%= TableTaskDateWeibo.createDay(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Created Time :
											<%= TableTaskDateWeibo.createTime(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Date :
											<%= TableTaskDateWeibo.date(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Time :
											<%= TableTaskDateWeibo.time(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											WeiboID :
											<%= TableTaskDateWeibo.weiboID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											WeiboPassword :
											<%= TableTaskDateWeibo.weiboPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Text :
											<%= TableTaskDateWeibo.text(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											User Name :
											<%= TableTaskDateWeibo.userName(ServerTaskNameList.list.get(i).TaskName) %></p>
										<%if(TableTaskDateWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 1){ %>
										<p>State : This task is running.</p> <%} else if(TableTaskDateWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 2) {%>
										<p>State : This task is paused.</p> <%} else if(TableTaskDateWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 3) { %>
										<p>State : This task has been finished.</p> <%} %> <%} else if(ServerTaskNameList.list.get(i).TaskType == "DateRenren"){ %>
										<p>
											Created Date :
											<%= TableTaskDateRenren.createDay(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Created Time :
											<%= TableTaskDateRenren.createTime(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Date :
											<%= TableTaskDateRenren.date(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Time :
											<%= TableTaskDateRenren.time(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											RenrenID :
											<%= TableTaskDateRenren.RenrenID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											RenrenPassword :
											<%= TableTaskDateRenren.RenrenPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Text :
											<%= TableTaskDateRenren.text(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											User Name :
											<%= TableTaskDateRenren.userName(ServerTaskNameList.list.get(i).TaskName) %></p>
										<%if(TableTaskDateRenren.state(ServerTaskNameList.list.get(i).TaskName) == 1){ %>
										<p>State : This task is running.</p> <%} else if(TableTaskDateRenren.state(ServerTaskNameList.list.get(i).TaskName) == 2) {%>
										<p>State : This task is paused.</p> <%} else if(TableTaskDateRenren.state(ServerTaskNameList.list.get(i).TaskName) == 3) { %>
										<p>State : This task has been finished.</p> <%} %> <%} else if(ServerTaskNameList.list.get(i).TaskType == "MailMail"){  %>
										<p>
											Created Date :
											<%= TableTaskMailMail.createDay(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Created Time :
											<%= TableTaskMailMail.createTime(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen MailID :
											<%= TableTaskMailMail.listenMailID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen Mail Password :
											<%= TableTaskMailMail.listenMailPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Send MailID :
											<%= TableTaskMailMail.sendMailID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Send MailPassword :
											<%= TableTaskMailMail.sendMailPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Receive MailID :
											<%= TableTaskMailMail.receiveMailID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Subject :
											<%= TableTaskMailMail.subject(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Text :
											<%= TableTaskMailMail.text(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											User Name :
											<%= TableTaskMailMail.userName(ServerTaskNameList.list.get(i).TaskName) %></p>
										<%if(TableTaskMailMail.state(ServerTaskNameList.list.get(i).TaskName) == 1){ %>
										<p>State : This task is running.</p> <%} else if(TableTaskMailMail.state(ServerTaskNameList.list.get(i).TaskName) == 2) {%>
										<p>State : This task is paused.</p> <%} else if(TableTaskMailMail.state(ServerTaskNameList.list.get(i).TaskName) == 3) { %>
										<p>State : This task has been finished.</p> <%} %> <%} else if(ServerTaskNameList.list.get(i).TaskType == "MailWeibo"){ %>
										<p>
											Created Date :
											<%= TableTaskMailWeibo.createDay(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Created Time :
											<%= TableTaskMailWeibo.createTime(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen MailID :
											<%= TableTaskMailWeibo.listenMailID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen Mail Password :
											<%= TableTaskMailWeibo.listenMailPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											WeiboID :
											<%= TableTaskMailWeibo.weiboID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											WeiboPassword :
											<%= TableTaskMailWeibo.weiboPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Text :
											<%= TableTaskMailWeibo.text(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											User Name :
											<%= TableTaskMailWeibo.userName(ServerTaskNameList.list.get(i).TaskName) %></p>
										<%if(TableTaskMailWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 1){ %>
										<p>State : This task is running.</p> <%} else if(TableTaskMailWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 2) {%>
										<p>State : This task is paused.</p> <%} else if(TableTaskMailWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 3) { %>
										<p>State : This task has been finished.</p> <%} %> <% } else if(ServerTaskNameList.list.get(i).TaskType == "WeiboMail"){ %>
										<p>
											Created Date :
											<%= TableTaskWeiboMail.createDay(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Created Time :
											<%= TableTaskWeiboMail.createTime(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen WeiboID :
											<%= TableTaskWeiboMail.listenWeiboID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen Weibo Password :
											<%= TableTaskWeiboMail.listenWeiboPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen Weibo Containing Information :
											<%= TableTaskWeiboMail.containInfo(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Send MailID :
											<%= TableTaskWeiboMail.sendMailID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Send MailPassword :
											<%= TableTaskWeiboMail.sendMailPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Receive MailID :
											<%= TableTaskWeiboMail.receiveMailID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Subject :
											<%= TableTaskWeiboMail.subject(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Text :
											<%= TableTaskWeiboMail.text(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											User Name :
											<%= TableTaskWeiboMail.userName(ServerTaskNameList.list.get(i).TaskName) %></p>
										<%if(TableTaskWeiboMail.state(ServerTaskNameList.list.get(i).TaskName) == 1){ %>
										<p>State : This task is running.</p> <%} else if(TableTaskWeiboMail.state(ServerTaskNameList.list.get(i).TaskName) == 2) {%>
										<p>State : This task is paused.</p> <%} else if(TableTaskWeiboMail.state(ServerTaskNameList.list.get(i).TaskName) == 3) { %>
										<p>State : This task has been finished.</p> <%} %> <% } else if(ServerTaskNameList.list.get(i).TaskType == "WeiboWeibo"){  %>
										<p>
											Created Date :
											<%= TableTaskWeiboWeibo.createDay(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Created Time :
											<%= TableTaskWeiboWeibo.createTime(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen WeiboID :
											<%= TableTaskWeiboWeibo.listenWeiboID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen Weibo Password :
											<%= TableTaskWeiboWeibo.listenWeiboPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Listen Weibo Containing Information :
											<%= TableTaskWeiboWeibo.containInfo(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											WeiboID :
											<%= TableTaskWeiboWeibo.weiboID(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											WeiboPassword :
											<%= TableTaskWeiboWeibo.weiboPassword(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											Text :
											<%= TableTaskWeiboWeibo.text(ServerTaskNameList.list.get(i).TaskName) %></p>
										<p>
											User Name :
											<%= TableTaskWeiboWeibo.userName(ServerTaskNameList.list.get(i).TaskName) %></p>
										<%if(TableTaskWeiboWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 1){ %>
										<p>State : This task is running.</p> <%} else if(TableTaskWeiboWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 2) {%>
										<p>State : This task is paused.</p> <%} else if(TableTaskWeiboWeibo.state(ServerTaskNameList.list.get(i).TaskName) == 3) { %>
										<p>State : This task has been finished.</p> <%} %> <%} %>
									</small> <span> <input type="hidden" id="task-name"
										name="task-name"
										value="<%=ServerTaskNameList.list.get(i).TaskName%>">
										<button class="delete-btn message-button" type="submit">delete</button>
									</span>
								</h2>
							</form>

						</div>
						<!--/span-->
					</div>
					<% } %>


				</div>
				<!--/row-->

			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>

	</div>
	<!--/.fluid-container-->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="./BOOTSTRAP/jquery.js"></script>
	<script src="./BOOTSTRAP/bootstrap-transition.js"></script>
	<script src="./BOOTSTRAP/bootstrap-alert.js"></script>
	<script src="./BOOTSTRAP/bootstrap-modal.js"></script>
	<script src="./BOOTSTRAP/bootstrap-dropdown.js"></script>
	<script src="./BOOTSTRAP/bootstrap-scrollspy.js"></script>
	<script src="./BOOTSTRAP/bootstrap-tab.js"></script>
	<script src="./BOOTSTRAP/bootstrap-tooltip.js"></script>
	<script src="./BOOTSTRAP/bootstrap-popover.js"></script>
	<script src="./BOOTSTRAP/bootstrap-button.js"></script>
	<script src="./BOOTSTRAP/bootstrap-collapse.js"></script>
	<script src="./BOOTSTRAP/bootstrap-carousel.js"></script>
	<script src="./BOOTSTRAP/bootstrap-typeahead.js"></script>


</body>
</html>