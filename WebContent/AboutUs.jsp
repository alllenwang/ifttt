<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AboutUs</title>

<link rel="stylesheet" href="./BOOTSTRAP/bootstrap.css" type="text/css">

<style type="text/css">
body {
	padding-top: 20px;
	padding-bottom: 60px;
	background-image: url("./IMAGE/bg.png");
	background-attachment: fixed;
	background-repeat: no-repeat;
	background-color: #C0DEED;
}

.wrapper.black {
	background: url(./IMAGE/wash-black-30.png);
}

.wrapper.white {
	background: url(./IMAGE/wash-white-30.png);
}

/* Custom container */
.container {
	margin: 50px auto;
	max-width: 1000px;
}

.container>hr {
	margin: 60px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
	margin: 80px 0;
	text-align: center;
}

.jumbotron h1 {
	font-size: 72px;
	line-height: 1;
}

.jumbotron .lead {
	font-size: 24px;
	line-height: 1.25;
}

.jumbotron .normal {
	font-size: 18px;
	line-height: 1.25;
}

.jumbotron .btn {
	font-size: 20px;
	padding: 9px 21px;
}

/* Customize the navbar links to be fill the entire space of the .navbar */
.navbar .navbar-inner {
	padding: 0;
}

.navbar .nav {
	margin: 0;
	display: table;
	width: 100%;
}

.navbar .nav li {
	display: table-cell;
	width: 1%;
	float: none;
}

.navbar .nav li a {
	font-weight: bold;
	text-align: center;
	border-left: 1px solid rgba(255, 255, 255, .75);
	border-right: 1px solid rgba(0, 0, 0, .1);
}

.navbar .nav li:first-child a {
	border-left: 0;
	border-radius: 3px 0 0 3px;
}

.navbar .nav li:last-child a {
	border-right: 0;
	border-radius: 0 3px 3px 0;
}
</style>

</head>


<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid"></div>
		</div>
	</div>

	<div class="container wrapper white">
		<div class="jumbotron">
			<h1>关于我们</h1>
			<hr>
			<p class="lead">王琦 汤顺雷 孙旻</p>
			<p class="normal">2011级计算机科学与技术系</p>
			<a class="btn" href="./UserHome.jsp">返回</a>

		</div>
	</div>
	</div>




</body>
</html>