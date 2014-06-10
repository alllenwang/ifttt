<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>ServerHome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="./BOOTSTRAP/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 60px;
        background-image: url("./IMAGE/bg.png");
		background-attachment: fixed;
		background-repeat: no-repeat;
		background-color: #C0DEED;
      }

      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 80px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 100px;
        line-height: 1;
      }
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
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
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
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
    <link href="./BOOTSTRAP/bootstrap-responsive.css" rel="stylesheet">


  <body>

    <div class="container">

      <div class="masthead">
        <h3 class="muted">IFTTT</h3>
      </div>

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Server</h1>
        <p class="lead"></p>
        <a class="btn btn-large btn-success" href="./SignOut.jsp">exit</a>
      </div>

      <hr>

      <!-- Example row of columns -->
      <div class="row-fluid">
        <div class="span4">
          <h2>User</h2>
          <p>You can check or delete the users' information</p>
          <p><a class="btn" href="./ServerUserInfo.jsp">View details »</a></p>
        </div>
        <div class="span4">
          <h2>Task</h2>
          <p>You can check or delete the tasks' information</p>
          <p><a class="btn" href="./ServerTaskInfo.jsp">View details »</a></p>
       </div>
        <div class="span4">
          <h2>Message</h2>
          <p>You can check or delete the messages' information</p>
          <p><a class="btn" href="./ServerMessageInfo.jsp">View details »</a></p>
        </div>
      </div>

      <hr>

    </div> <!-- /container -->

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