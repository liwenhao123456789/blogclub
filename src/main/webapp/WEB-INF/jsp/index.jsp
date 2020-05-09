<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>JavaShare首页</title>
<!-- 引入公共样式和脚本 -->
<c:import url="common.jsp"></c:import>
</head>

<body>
	<!-- 引入头部 -->
	<c:import url="header.jsp"></c:import>

	<!-- 内容模块1 -->
	<div class="d2 allwidth">
		<h1>热门博客</h1>
		<table class="table table-hover">
			<caption>基本的表格布局</caption>
			<tr>
				<th>作者</th>
				<th>标题</th>
				<th>类型</th>
				<th>发表时间</th>
				<th>浏览量</th>
			</tr>
			<c:forEach items="${hotList }" var="blogVO">
				<tr>
					<td><a href="personbloglist.action?uid=${blogVO.uid }">作者：${blogVO.authorName }</a></td>
					<td><a href="showbloginfo.action?id=${blogVO.id }">标题：${blogVO.title }</a></td>
					<td><a href="#">${blogVO.kindName }</a></td>
					<td><fmt:formatDate value="${blogVO.dateTime }" pattern="yyyy/MM/dd"/></td>
					<td>${blogVO.clicks }</td>
				</tr>
			</c:forEach>
		</table>

		<h1>博客列表</h1>
		<table class="table table-hover">
			<caption>基本的表格布局</caption>
			<tr>
				<th>作者</th>
				<th>标题</th>
				<th>类型</th>
				<th>发表时间</th>
				<th>浏览量</th>
			</tr>
			<c:forEach items="${indexList }" var="blogVO">
				<tr>
					<td><a href="personbloglist.action?uid=${blogVO.uid }">作者：${blogVO.authorName }</a></td>
					<td><a href="showbloginfo.action?id=${blogVO.id }">标题：${blogVO.title }</a></td>
					<td><a href="#">${blogVO.kindName }</a></td>
					<td><fmt:formatDate value="${blogVO.dateTime }" pattern="yyyy/MM/dd"/></td>
					<td>${blogVO.clicks }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- 引入脚步 -->
	<c:import url="footer.jsp"></c:import>

</body>

</html>