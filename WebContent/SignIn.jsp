<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.javalab03.*"%>
<!DOCTYPE html>

<%!	boolean isAdmin = false;
	String username = null;%>
<%
	username = request.getParameter("session[username]");
	if (username == null) {
		response.sendRedirect("Welcome.jsp");
	}
	if ( request.getParameterValues("administrator") != null) {
		System.out.println("is admin");
		isAdmin = true;
	} else {
		System.out.println("is user");
		isAdmin = false;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./CUSTOMED/Basic.css">

<title>SignIn</title>
</head>

<body
	class="t1 logged-out ms-windows asian zh-cn mobile-callout front-page swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading"
	data-fouc-class-names="swift-loading" dir="ltr">

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

								<%
									//isAdmin = request.getParameterValues("administrator");
									String userpassword = request.getParameter("session[password]");
									if (isAdmin == true) { //admin
										System.out.println("get admin" + username + userpassword);
										if (TableUser.signInAdmin(username, userpassword)) {
											session.setAttribute("username", username);
											session.setAttribute("isadmin", true);
											response.setHeader("refresh", "2; url=./ServerHome.jsp");
								%>
								<h1>管理员登录成功...</h1>

								<%
									} else {
											response.setHeader("refresh", "2; url=./Welcome.jsp");
								%>
								<h1>管理员登录失败...</h1>
								<%
									}
									} else {
										if (User.signIn(username, userpassword, isAdmin)) {
											session.setAttribute("username", username);
											session.setAttribute("isadmin", false);
											response.setHeader("refresh", "2; url=./UserHome.jsp");
								%>
								<h1>用户登录成功...</h1>

								<%
									} else {
											response.setHeader("refresh", "2; url=./Welcome.jsp");
								%>
								<h1>用户登录失败...</h1>
								<%
									}
								}
								%>
								<p id="timer">1秒后即将自动跳转...</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var count = 2;
		setInterval(timer, 1000); //1000 will  run it every 1 second
		function timer() {
			count = count - 1;
			if (count <= 0) {
				clearInterval(counter);
				return;
			}
			document.getElementById("timer").innerHTML = (count - 1)
					+ "秒后即将自动跳转...";
		}
	</script>

</body>
</html>