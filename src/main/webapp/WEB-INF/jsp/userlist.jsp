<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>用户列表</title>
<!-- 引入公共样式和脚本 -->
<c:import url="common.jsp"></c:import>
<script type="text/javascript">
		function delete_user(param){
			var del = confirm("delete user id:"+param+", are you sure?");
			console.log(param);
			console.log(del);
			if(del){
				window.location = "deleteuser.action?uid="+param;
			}
		}
</script>
</head>

<body>
	<!-- 引入头部 -->
	<c:import url="header.jsp"></c:import>

	<!-- 内容模块1 -->
	<div class="d2 allwidth">
		<h1>用户列表</h1>
		<table class="table table-hover">
			<caption>基本的表格布局</caption>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>电话号码</th>
				<th>地址</th>
				<th>注册时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${userList}" var="user">
			<tr>
				<td><a href="personbloglist.action?uid=${user.id}">${user.id }</a></td>
				<td><a href="personbloglist.action?uid=${user.id}">作者：${user.name }</a></td>
				<td>
					<c:if test="${user.sex=='m' }">男</c:if>
					<c:if test="${user.sex=='f' }">女</c:if>
				</td>
				<td>${user.age }</td>
				<td>${user.tel }</td>
				<td>${user.province }-${user.city }-${user.area }</td>
				<td>${user.inputDate }</td>
				<td><a onClick="delete_user(${user.id})" style="cursor: pointer;">删除</a></td>
			</tr>
			</c:forEach>

		</table>

	</div>

	<!-- 引入脚步 -->
	<c:import url="footer.jsp"></c:import>
</body>

</html>