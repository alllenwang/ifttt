<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.javalab03.*"%>
<!DOCTYPE html>

<html lang="zh-cn">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./CUSTOMED/Welcome.css">

<meta charset="utf-8;">
<title>Welcome</title>
<meta name="description" content="The best IFTTT">
<style type="text/css"></style>
</head>


<body
	class="t1 logged-out ms-windows asian zh-cn mobile-callout front-page swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading swift-loading"
	data-fouc-class-names="swift-loading" dir="ltr">

	<div id="doc" class="">
		<div class="topbar js-topbar">

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
							<div class="ifttt-image"></div>
							<div class="callout-copy">
								<h1>欢迎来到 IFTTT</h1>
								<p>null</p>
							</div>
						</div>

						<div class="front-signin js-front-signin">
							<form action="./SignIn.jsp" class="signin" method="post" onsubmit="return CheckSignIn()">
								<div class="username">
									<input type="text" id="signin[username]"
										class="text-input email-input"
										name="session[username]" autocomplete="on"
										placeholder="用户名">
								</div>

								<table class="flex-table password-signin">
									<tbody>
										<tr>
											<td class="flex-table-primary">
												<div class="password flex-table-form">
													<input type="password" id="signin[password]"
														class="text-input flex-table-input"
														name="session[password]" placeholder="密码">
												</div>
											</td>
											<td class="flex-table-secondary">
												<button type="submit"
													class="submit btn primary-btn flex-table-btn js-submit">
													登录</button>
											</td>
										</tr>
									</tbody>
								</table>

								<div class="remember-forgot">
									<label class="remember"> <input type="checkbox"
										value="isAdministrator" name="administrator"> <span>管理员？</span>
									</label> <span class="separator"> </span> <a class="forgot"
										href="./ErrorPage.jsp">忘记密码？</a>
								</div>
								<input type="hidden" name="return_to_ssl" value="true">

								<input type="hidden" name="scribe_log"> <input
									type="hidden" name="redirect_after_login" value="/"> <input
									type="hidden" value="71d98c131c0498c8b09a2e57b50a80e8037609cf"
									name="authenticity_token">
							</form>
						</div>

						<div class="front-signup js-front-signup">
							<h2>
								<strong>没有账号？</strong> 注册
							</h2>
							<form
								action="./AddUser.jsp"
								class="signup" method="post" onsubmit="return CheckSignUp()">
								<div class="field">
									<input type="text" class="text-input" autocomplete="off" id="signup[username]"
										name="user[name]" maxlength="20" placeholder="用户名">
								</div>
								<div class="field">
									<input type="text" class="text-input email-input" id="signup[mail]"
										autocomplete="off" name="user[email]" placeholder="邮箱地址">
								</div>
								<div class="field">
									<input type="password" class="text-input" id="signup[password]"
										name="user[password]" placeholder="密码">
								</div>
								<input type="hidden" value="" name="context"> <input
									type="hidden" value="71d98c131c0498c8b09a2e57b50a80e8037609cf"
									name="authenticity_token">
								<button type="submit" class="btn signup-btn"">注册 IFTTT</button>
							</form>
						</div>
					</div>

					<div class="footer inline-list">
						<ul>
							<li><a href="./AboutUs.jsp">关于</a><span
								class="dot divider"> ·</span></li>
							<li><a href="./Help.jsp">帮助</a><span
								class="dot divider"> ·</span></li>
							<li><span class="copyright">© 2013 IFTTT</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript">
function CheckSignIn() {
	var username = document.getElementById("signin[username]").value;
	var password = document.getElementById("signin[password]").value;
	if ( (new RegExp("[^(\\w|\\d)]")).test(username)
			|| (username.length <= 0) || (username.length > 15) ) {
		alert("用户名不能为空，不能超过15位，且只能包含英文字母及数字" + username);
		return false;
	}
	if ( (new RegExp("[^\\w|\\d]")).test(userpassword)
			|| (password.length < 6) || (password.length > 15) ) {
		alert("密码长度必须在6至15位，且只能包含英文字母及数字" + password);
		return false;
	}
	return true;
}

function CheckSignUp() {
	var username = document.getElementById("signup[username]").value;
	var usermail = document.getElementById("signup[mail]").value;
	var password = document.getElementById("signup[password]").value;
	alert(username + usermail + password);
	//var pat = new RegExp("[@]");
	
	if ( (new RegExp("[^(\\w|\\d)]")).test(username)
			|| (username.length <= 0) || (username.length > 15) ) {
		alert("用户名不能为空，不能超过15位，且只能包含英文字母及数字");
		return false;
	}
	if ( !(new RegExp("([\\w|\\d]+)[@]([\\w|\\d]+)\.([\\w|\\d]+)")).test(usermail)
			|| (usermail.length < 5) ) {
		alert("非法邮箱地址");
		return false;
	}
	if ( (new RegExp("[^\\w|\\d]")).test(userpassword)
			|| (password.length < 6) || (password.length > 15) ) {
		alert("密码长度必须在6至15位，且只能包含英文字母及数字");
		return false;
	}
	return true;
}
</script>
</body>
</html>