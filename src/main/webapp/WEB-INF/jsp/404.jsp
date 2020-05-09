<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>404</title>
<!-- 引入公共样式和脚本 -->
<c:import url="common.jsp"></c:import>
<script type="text/javascript">
	var num = 3;
	$(function() {
		console.log(1);
		myFun();
	});

	function myFun() {
		if (num > 0) {
			$("#num").html(num);
			setTimeout("myFun()", 1000);
			num--;
		} else {
			//3秒后跳转到首页
			window.location.href = "index.html";
		}
	}
</script>
</head>

<body>
	<!-- 引入头部 -->
	<c:import url="header.jsp"></c:import>

	<!--中间内容部分开始-->
	<div class="container fourzerofour">
		<p>
			倒数<span id="num"></span>秒后：跳转到<a href="index.html">首页</a>
		</p>
		<img src="img/404.jpg" />
	</div>
	<!--内容部分结束-->

	<!-- 引入脚步 -->
	<c:import url="footer.jsp"></c:import>
</body>

</html>