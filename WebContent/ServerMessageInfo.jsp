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
<title>ServerMessageInfo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="./BOOTSTRAP/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
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
					<h1>Message Information</h1>
				</div>
				<div class="row-fluid">


					<% ServerMessageList.setMessageList(); %>
					<% for (int i = 0; i < ServerMessageList.list.size(); i++) { %>
					<div class="row-fluid">
						<div class="span12 well">

							<form action="./ServerDeleteMessage.jsp" method="post">

								<h2 class="message-sender">
									<%= "Message:" + i %>
									<span class="separator"> </span> <small class="time">
										<p>
											Receive user :
											<%=ServerMessageList.list.get(i).userName %></p>
										<p>
											Date :
											<%=ServerMessageList.list.get(i).date%></p>
										<p>
											Time :
											<%=ServerMessageList.list.get(i).time%></p>
										<p>
											Message :
											<%=ServerMessageList.list.get(i).message%></p>
										<p>
											Send user :
											<%=ServerMessageList.list.get(i).sendUserName%></p>
									</small>
									
										<span> <input type="hidden" id="delete-username"
											name="delete-username"
											value="<%=ServerMessageList.list.get(i).userName%>">
											<input type="hidden" id="delete-time" name="delete-time"
											value="<%=ServerMessageList.list.get(i).time%>"> <input
											type="hidden" id="delete-day" name="delete-day"
											value="<%=ServerMessageList.list.get(i).date%>"> <input
											type="hidden" id="delete-sender" name="delete-sender"
											value="<%=ServerMessageList.list.get(i).sendUserName%>">
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