<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.javalab03.*"%>
<!DOCTYPE html>

<%! String username = null; 
boolean isAdmin = false;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./CUSTOMED/AddUser.css">

<title>AddUser</title>
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
							
							<% username = (String)request.getParameter("user[name]"); %>
								<% if ( User.signUp(username, (String)request.getParameter("user[password]"), (String)request.getParameter("user[email]"), isAdmin) ) {
									session.setAttribute("username", username);
									session.setAttribute("isadmin", isAdmin);
									response.setHeader("refresh", "3; url=./UserHome.jsp");
								%>

								<h1>注册成功</h1>
								<p id="timer">2秒后即将跳转...</p>
								<% } else { 
									response.setHeader("refresh", "3; url=./Welcome.jsp");
								%>
								<h1>注册失败</h1>
								<p><span id="timer"></span>秒后即将跳转...</p>

								<%} %>

							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var count = 3;
		setInterval(timer, 1000); //1000 will  run it every 1 second
		function timer() {
			count = count - 1;
			if (count <= 0) {
				clearInterval(counter);
				return;
			}
			document.getElementById("timer").innerHTML = (count-1) + "秒后即将跳转...";
		}
	</script>

</body>
</html>