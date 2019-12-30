<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>酒店管理系统登录</title>

<link href="<%=basePath%>css/bootstrap.min.css" title=""
	rel="stylesheet" />
<link title="orange" href="<%=basePath%>css/login.css" rel="stylesheet"
	type="text/css">

</head>
<body>
	<div style="height: 1px;"></div>
	<div class="login">
		<header>
		<h1>登录</h1>
		</header>
		<div class="sr">
			<form action="${pageContext.request.contextPath }/user/login.action"
				method="post">
				<div class="name">
					<label> <i class="sublist-icon glyphicon glyphicon-user"></i>
					</label> <input type="text" placeholder="输入帐号" class="name_inp"
						name="username">
				</div>
				<div class="name">
					<label> <i class="sublist-icon glyphicon glyphicon-pencil"></i>
					</label> <input type="password" placeholder="输入密码" class="name_inp"
						name="password">
				</div>
				<button class="dl" type="submit">点击登录</button>

			</form>
		</div>
	</div>
	<div
		style="text-align: center; margin: -160px 0; font: normal 14px/24px 'MicroSoft YaHei'; color: #000000">
		<label> 提示：帐号 admin,密码 admin</label>
		<p>适用浏览器：360、FireFox、Chrome、Opera、傲游、搜狗、世界之窗. 不支持Safari、IE8及以下浏览器。</p>
	</div>




</body>
</html>

