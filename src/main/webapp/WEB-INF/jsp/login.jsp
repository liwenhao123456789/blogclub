<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>登录</title>
<!-- 引入公共样式和脚本 -->
<c:import url="common.jsp"></c:import>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body>
	<!-- 引入头部 -->
	<c:import url="header.jsp"></c:import>

	<!--中间内容部分开始-->
	<div class="container widthone">
		<h1>登&nbsp;&nbsp;录</h1>
		<form class="form-horizontal" role="form" action="login.action"
			method="post">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">名&nbsp;&nbsp;&nbsp;字：</label>
				<div class="col-sm-10">
					<input type="text" name="name" class="form-control" id="firstname"
						placeholder="请输入名字">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;码：</label>
				<div class="col-sm-10">
					<input type="password" name="pass" class="form-control"
						id="password" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">验证码：</label>
				<div class="col-sm-10">
					<input type="text" style="width: 50%;float:left;display: inherit;" name="captcha" class="form-control" placeholder="请输入验证码">
					<img id="captcha" style="height: 34px;" alt="验证码" onclick="flash()" src="captcha.action">
					<span style="color:red">${requestScope.mes }</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox">请记住我</label>&nbsp;&nbsp;
					</div>
					
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">登录</button>
					<button type="submit" class="btn btn-default">退出</button>
				</div>
			</div>
		</form>
	</div>
	<!--内容部分结束-->

	<!-- 引入脚步 -->
	<c:import url="footer.jsp"></c:import>
	<!-- 脚部结束 -->
</body>

</html>