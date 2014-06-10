<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.javalab03.*"%>
	
<!DOCTYPE html>

<%! String username = null;%>
<% username = (String)session.getAttribute("username"); %>
<% if (username == null)
	response.sendRedirect("Welcome.jsp");
	%>

<html lang="zh-cn">

<script type="text/javascript">
function CheckInput(){
	if (document.getElementsByName("task[type]") == null) {
		return false;
	}
	return true;
}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Task</title>
<meta name="swift-page-name" id="swift-page-name" content="settings">
<link rel="stylesheet" href="./CUSTOMED/CreateTask.css" type="text/css">

<style id="user-style">
a,a:hover,a:focus,a:active,.u-linkPseudo:hover a,.u-linkPseudo:focus a,.u-linkPseudo:active a
	{
	color: #0084B4;
}

.u-textUserColor {
	color: #0084B4 !important;
}

.u-borderUserColor,.u-borderUserColorHover:hover,.u-borderUserColorHover:focus
	{
	border-color: #0084B4 !important;
}

.u-bgUserColor,.u-bgUserColorHover:hover,.u-bgUserColorHover:focus {
	background-color: #0084B4 !important;
}

.u-boxShadowInsetUserColorHover:hover,.u-boxShadowInsetUserColorHover:focus
	{
	-webkit-box-shadow: inset 0 0 0 5px #0084B4 !important;
	box-shadow: inset 0 0 0 5px #0084B4 !important;
}

.ProfileTweet.is-actionable .ProfileTweet-divider:after {
	background-color: #0084B4 !important;
}

.u-textUserColorLight {
	color: #99CDE1 !important;
}

.u-borderUserColorLight,.u-borderUserColorLightFocus:focus {
	border-color: #99CDE1 !important;
}

.u-bgUserColorLight {
	background-color: #99CDE1 !important;
}

.u-boxShadowUserColorLighterFocus:focus {
	-webkit-box-shadow: 0 0 8px rgba(0, 0, 0, 0.05), inset 0 1px 2px
		rgba(0, 132, 180, 0.25) !important;
	box-shadow: 0 0 8px rgba(0, 0, 0, 0.05), inset 0 1px 2px
		rgba(0, 132, 180, 0.25) !important;
}

.u-textUserColorLightest {
	color: #E5F2F7 !important;
}

.u-borderUserColorLightest {
	border-color: #E5F2F7 !important;
}

.u-bgUserColorLightest {
	background-color: #E5F2F7 !important;
}

.u-bgUserColorDarkHover:hover {
	background-color: #006990 !important;
}

.u-bgUserColorDarkerActive:active {
	background-color: #004F6C !important;
}

a,.btn-link,.btn-link:focus,.pretty-link b,.pretty-link:hover s,.pretty-link:hover b,.pretty-link:focus s,.pretty-link:focus b,
	/* Account Group */ .metadata a:hover,.metadata a:focus,.account-group:hover .fullname,.account-group:focus .fullname,.account-summary:focus .fullname,.stats a:hover,.stats a:hover strong,.stats a:focus,.stats a:focus strong,.profile-modal-header .fullname a:hover,.profile-modal-header .username a:hover,.profile-modal-header .fullname a:focus,.profile-modal-header .username a:focus,.story-article:hover .metadata,.story-article .metadata a:focus,.find-friends-sources li:hover .source,.stream-item a:hover .fullname,.stream-item a:focus .fullname,.stream-item .view-all-supplements:hover,.stream-item .view-all-supplements:focus,.tweet .time a:hover,.tweet .time a:focus,.tweet-actions a,.tweet .details.with-icn b,.stream-item:hover .original-tweet .expand-action-wrapper,.stream-item .original-tweet.focus .expand-action-wrapper,.opened-tweet.original-tweet  .expand-action-wrapper,.stream-item:hover .original-tweet .details b,.stream-item .original-tweet.focus .details b,.stream-item.open .original-tweet .details b,.simple-tweet:hover .details b,.simple-tweet.focus .details b,.simple-tweet.open .details b,.simple-tweet:hover .details .expand-action-wrapper,.simple-tweet.focus .details .expand-action-wrapper,.simple-tweet.open .details .collapse-action-wrapper,.simple-tweet:hover .details .simple-details-link,.simple-tweet.focus .details .simple-details-link,.client-and-actions a:hover,.client-and-actions a:focus,.dismiss-promoted:hover b,.tweet .context .pretty-link:hover s,.tweet .context .pretty-link:hover b,.tweet .context .pretty-link:focus s,.tweet .context .pretty-link:focus b,.list .username a:hover,.list .username a:focus,.list-membership-container .create-a-list,.list-membership-container .create-a-list:hover,.story-header:hover .view-tweets,.card .list-details a:hover,.card .list-details a:focus,.card .card-body:hover .attribution,.card .card-body .attribution:focus,.events-card .card-body:hover .attribution,.events-card .card-body .attribution:focus,.new-tweets-bar,.onebox .soccer ul.ticker a:hover,.onebox .soccer ul.ticker a:focus,.discover-item-actions a,.disco-stream-item.disco_exp_actions_on_btm .more-tweet-actions .btn-link,.disco-stream-item.disco_exp_actions_on_btm_without_stats .more-tweet-actions .btn-link,.remove-background-btn,.stream-item-activity-me .latest-tweet .tweet-row a:hover,.stream-item-activity-me .latest-tweet .tweet-row a:focus,.stream-item-activity-me .latest-tweet .tweet-row a:hover b,.stream-item-activity-me .latest-tweet .tweet-row a:focus b
	{
	color: #0084B4;
}

s,.pretty-link:hover s,.pretty-link:focus s,.stream-item-activity-me .latest-tweet .tweet-row a:hover s,.stream-item-activity-me .latest-tweet .tweet-row a:focus s
	{
	color: #66B5D2;
}

.vellip,.vellip:before,.vellip:after,.conversation-module>li:after,.conversation-module>li:before
	{
	background-color: #66B5D2;
}

.tweet .sm-reply,.tweet .sm-rt,.tweet .sm-fav,.tweet .sm-image,.tweet .sm-video,.tweet .sm-audio,.tweet .sm-geo,.tweet .sm-in,.tweet .sm-trash,.tweet .sm-more,.tweet .sm-page,.tweet .sm-embed,.tweet .sm-summary,.tweet .sm-chat,.timelines-navigation .active .profile-nav-icon,.timelines-navigation .profile-nav-icon:hover,.timelines-navigation .profile-nav-link:focus .profile-nav-icon,.sm-top-tweet,.metadata a.tweet-geo-text:hover .sm-geo,.discover-item .js-action-card-search:hover .sm-search,.discover-item .js-action-card-search:focus .sm-search
	{
	background-color: #0084B4;
}

.tweet-action-icons .tweet .tweet-actions .sm-reply,.tweet-action-icons .tweet.opened-tweet .tweet-actions .sm-reply,.tweet-action-icons .tweet .tweet-actions .sm-rt,.tweet-action-icons .tweet.opened-tweet .tweet-actions .sm-rt,.tweet-action-icons .tweet .tweet-actions .sm-fav,.tweet-action-icons .tweet.opened-tweet .tweet-actions .sm-fav,.tweet-action-icons .tweet .tweet-actions .sm-trash,.tweet-action-icons .tweet.opened-tweet .tweet-actions .sm-trash,.tweet-action-icons .tweet .tweet-actions .sm-more,.tweet-action-icons .tweet.opened-tweet .tweet-actions .sm-more
	{
	background-color: #66B5D2;
}

.persistent-tweet-actions.tweet-action-icons .tweet:hover .tweet-actions .sm-reply,.persistent-tweet-actions.tweet-action-icons .tweet:hover .tweet-actions .sm-rt,.persistent-tweet-actions.tweet-action-icons .tweet:hover .tweet-actions .sm-fav,.persistent-tweet-actions.tweet-action-icons .tweet:hover .tweet-actions .sm-trash,.persistent-tweet-actions.tweet-action-icons .tweet:hover .tweet-actions .sm-more
	{
	background-color: #66B5D2;
}

.tweet-action-icons .stream .tweet .tweet-actions .sm-reply:hover,.tweet-action-icons .stream .tweet .tweet-actions a:focus .sm-reply,.tweet-action-icons .stream .tweet .tweet-actions .sm-rt:hover,.tweet-action-icons .stream .tweet .tweet-actions a:focus .sm-rt,.tweet-action-icons .stream .tweet .tweet-actions .sm-fav:hover,.tweet-action-icons .stream .tweet .tweet-actions a:focus .sm-fav,.tweet-action-icons .stream .tweet .tweet-actions .sm-trash:hover,.tweet-action-icons .stream .tweet .tweet-actions a:focus .sm-trash,.tweet-action-icons .stream .tweet .tweet-actions .sm-more:hover,.tweet-action-icons .stream .tweet .tweet-actions a:focus .sm-more
	{
	background-color: #0084B4;
}

.wrapper.black {
	background: url(./IMAGE/wash-black-30.png);
}

.wrapper.white {
	background: url(./IMAGE/wash-white-30.png);
}
</style>

<style id="user-style-bg-img" class="js-user-style-bg-img">
body.user-style-standottang {
	background-image: url(./IMAGE/bg.png);
	background-position: left 40px;
	background-attachment: fixed;
	background-repeat: repeat;
	background-repeat: no-repeat;
	background-color: #C0DEED;
}
</style>

</head>


<body
	class="t1 logged-in user-style-standottang ms-windows asian zh-cn psf supports-drag-and-drop swift-loading swift-loading swift-loading"
	data-fouc-class-names="swift-loading" dir="ltr"
	data-twttr-rendered="true">

	<div id="doc" class="">
		<div class="topbar js-topbar">
			<div class="global-nav" data-section-term="top_nav">
				<div class="global-nav-inner">
					<div class="container">
										<!-- ------------------------------------- topbar ----------------------------------------- -->
						<div role="navigation" style="display: inline-block;">
							<ul class="nav js-global-actions" id="global-actions">
								<li id="global-nav-home" class="home active"
									data-global-action="home"><a class="js-nav js-tooltip"
									href="./UserHome.jsp"
									data-component-term="home_nav" data-nav="home"
									data-original-title="主页"> <span class="new-wrapper"><i
											class="nav-home"></i><i class="nav-new"></i></span> <span
										class="text">主页</span>
								</a></li>
								<!-- <li class="people" data-global-action="connect"><a
									class="js-nav js-tooltip" href="https://twitter.com/i/connect"
									data-component-term="connect_nav" data-nav="connect"
									data-original-title="联系"> <span class="new-wrapper"><i
											class="nav-people"></i><i class="nav-new"></i></span> <span
										class="text">联系</span>
								</a></li>
								<li class="topics" data-global-action="discover"><a
									class="js-nav js-tooltip" href="https://twitter.com/i/discover"
									data-component-term="discover_nav" data-nav="discover"
									title="发现"> <span class="new-wrapper"><i
											class="nav-topics"></i><i class="nav-new"></i></span> <span
										class="text">发现</span>
								</a></li> -->
								<li class="profile" data-global-action="profile"><a
									class="js-nav js-tooltip"
									href="./SignOut.jsp"
									data-component-term="profile_nav" data-nav="profile" title="我">
										<span class="new-wrapper"><i class="nav-me"></i><i
											class="nav-new"></i></span> <span class="text">注销</span>
								</a></li>
							</ul>
						</div>
<!-- ------------------------------------- topbar ----------------------------------------- -->
					</div>
				</div>
			</div>
		</div>

		<div id="page-outer">
			<div id="page-container" class="wrapper wrapper-settings white">

				<div class="dashboard">
					<div class="module mini-profile">
						<div class="flex-module profile-summary js-profile-summary">


							<a href="./UserHome.jsp"
								class="account-summary account-summary-small js-nav"
								data-nav="profile">
								<div class="content">
									<div class="account-group js-mini-current-user"
										data-user-id="2219210888" data-screen-name="">
										<img class="avatar size32" src="./IMAGE/default_avatar.png"
											alt="" data-user-id="2219210888"> <b class="fullname">
											<%= username %>
											</b>
										<small class="metadata">创建您自己的任务</small>
									</div>
								</div>
							</a>

						</div>

					</div>

					<div role="navigation" class="module">
						<ul class="js-nav-links">
							<li class="active"><a class="list-link js-nav"
								href="./ChooseTaskType.jsp" data-nav="account">新建任务 <i
									class="chev-right"></i>
							</a></li>
							<li class=""><a class="list-link js-nav"
								href="./ManageTasks.jsp" data-nav="password">管理任务<i
									class="chev-right"></i>
							</a></li>
							<li class=""><a class="list-link js-nav" href="./Inbox.jsp"
								data-nav="notifications">站内信 <i class="chev-right"></i>
							</a></li>
							<li class=""><a class="list-link js-nav"
								href="./UserHome.jsp" data-nav="profile">个人资料 <i
									class="chev-right"></i>
							</a></li>
						</ul>
					</div>

					<div class="module site-footer ">
						<div class="flex-module">
							<div class="flex-module-inner js-items-container">
								<ul class="clearfix">
									<li class="copyright">© 2013 IFTTT</li>
									<li><a href="./AboutUs.jsp">关于</a></li>
									<li><a href="./Help.jsp">帮助</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div role="main" aria-labelledby="content-main-heading"
					class="content-main">
					<div class="content-header">
						<div class="header-inner">
							<h2 id="content-main-heading">新建一个任务</h2>
							<p class="subheader">在选定的时间发送邮件</p>
						</div>
					</div>
					<div class="content-inner no-stream-end">
						<form id="profile-form" class="form-horizontal" method="POST"
							action="./AddTask.jsp">

							<fieldset id="profile-image-controls" class="control-group">
								<label class="control-label" for="profile_image_uploaded_data">任务类型</label>
								<div class="controls">
									<div class="uploader-avatar clearfix">
										<img class="avatar size73" id="avatar_preview"
											src="./IMAGE/clock_icon.png" alt="stan"> <img
											class="avatar size64" id="avatar_preview"
											src="./IMAGE/arrow_right.png" alt="stan"> <img
											class="avatar size73" id="avatar_preview"
											src="./IMAGE/gmail_icon.png" alt="stan">
									</div>
								</div>
							</fieldset>

							<hr>
							<fieldset class="control-group">
								<label class="control-label" for="user_name">任务名称</label>
								<div class="controls">
									<input id="task[name]" maxlength="20" type="text"
										name="task[name]" placeholder="Type in a name">
									<p>任务名不能重复</p>
								</div>
							</fieldset>
							<input type="hidden" id="task[type]" name="task[type]" value="DateMail">
							<hr>
							<fieldset class="control-group">
								<label class="control-strong-label" for="user_location">选定时间</label>

							</fieldset>
							<fieldset class="control-group">
								<label class="control-label" for="user_location">日期</label>
								<div class="controls">
									<input id="this[dateday]" name="this[dateday]" type="text"
										placeholder="yyyy-MM-dd">

								</div>
							</fieldset>
							<fieldset class="control-group">
								<label class="control-label" for="user_location">时刻</label>
								<div class="controls">
									<input id="this[datetime]" name="this[datetime]" type="text"
										placeholder="hh-mm-ss">

								</div>
							</fieldset>
							<hr>
							<fieldset class="control-group">
								<label class="control-strong-label" for="user_location">发送邮件</label>

							</fieldset>

							<fieldset class="control-group">
								<label class="control-label" for="user_location">邮箱地址</label>
								<div class="controls">
									<input id="that[mailid]" name="that[mailid]" type="text"
										placeholder="ifttt@ifttt.com">
								</div>
							</fieldset>
							<fieldset class="control-group">
								<label class="control-label" for="user_location">邮箱密码</label>
								<div class="controls">
									<input id="that[mailpassword]" name="that[mailpassword]"
										type="password" >
								</div>
							</fieldset>
							<fieldset class="control-group">
								<label class="control-label" for="user_location">收件人</label>
								<div class="controls">
									<input id="that[mailrecepients]" name="that[mailrecepients]"
										type="text" placeholder="00@ifttt.com,01@ifttt.com,...">
									<p>可多选，用","隔开，至多<strong>3</strong>个收件人</p>
								</div>
							</fieldset>

							<fieldset class="control-group">
								<label class="control-label" for="user_location">主题</label>
								<div class="controls">
									<input id="that[mailsubject]" name="that[mailsubject]" type="text">
								</div>
							</fieldset>
							<fieldset class="control-group">
								<label class="control-label" for="user_description">正文</label>
								<div id="user_description_box" class="controls">
									<textarea class="input-xlarge" id="that[mailcontent]"
										name="that[mailcontent]"></textarea>
									<p class="bio-label">
										正文不得多于<strong>600</strong>个字。
									</p>
								</div>
							</fieldset>

							<hr>
							<fieldset class="control-group">
								<div class="form-actions">
									<button class="btn-submit" type="submit">确定</button>
									<button class="btn" type="button"
										onclick="location.herf'Welcome.jsp'">取消</button>
								</div>
							</fieldset>

						</form>
					</div>
				</div>

			</div>
		</div>

	</div>
</body>
</html>