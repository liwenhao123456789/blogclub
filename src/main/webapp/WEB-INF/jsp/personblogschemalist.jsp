<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>个人博客列表</title>
<!-- 引入公共样式和脚本 -->
<c:import url="common.jsp"></c:import>
<script type="text/javascript">
		function delete_blog(param){
			var del = confirm("delete blog id:"+param+", are you sure?");
			if(del){
				window.location = "deleteblog.action?id="+param;
			}
		}
</script>
</head>

<body>
	<!-- 引入头部 -->
	<c:import url="header.jsp"></c:import>

	<!-- 内容模块1 -->
	<div class="d2 allwidth">
		<!--用户信息-->
		<div id="userinfo" class="templatemo-container userinfo">
			<ul>
				<li><span class="glyphicon glyphicon-user">：${user.name }</span></li>
				<li><span class="glyphicon glyphicon-tree-conifer">：</span> <c:if
						test="${user.sex=='m'}">♂</c:if>&nbsp;<c:if
						test="${user.sex=='f'}">♀</c:if></li>
				<li><span class="glyphicon glyphicon-circle-arrow-right">：</span>${user.age }</li>
				<li><span class="glyphicon glyphicon-earphone">：${user.tel }</span></li>
				<c:if test="${current_user != null }">
					<li><a href="personbloglist.action?uid=${current_user.id }">click
							me into my blog</a></li>
					<li><a href="tocreateblog.action">create blog</a></li>
				</c:if>
			</ul>
		</div>
		<!--用户博客概要列表-->
		<div class="schemalist">
			<table class="table table-hover bloglist">
				<tr class="personbloginfo_tr">
					<th style="width: 10%;">作者</th>
					<th>标题</th>
					<th>时间</th>
				</tr>
				<c:forEach items="${voList }" var="blogVO">
					<!--要循环的博客概要-->
					<tr class="personbloginfo_tr">
						<td class="line"><a
							href="showbloglist.action?type=1&uid=${blogVO.uid }">${blogVO.authorName }</a></td>
						<td class="line"><span class="schema_title">${blogVO.title }</span>
						</td>
						<td class="line"><span class="schema_time">时间：<fmt:formatDate
									pattern="yyyy/MM/dd" value="${blogVO.dateTime }" />
						</span> <span class="blogedit"> <a
								onclick="delete_blog(${blogVO.id })" style="cursor: pointer;">删除</a>&nbsp;|&nbsp;
								<a href="toeditblog.action?id=${blogVO.id }">编辑</a>
						</span></td>
					</tr>
					<tr class="personbloginfo_tr">
						<td class="layout" colspan="3"><a
							href="showbloginfo.action?id=${blogVO.id }"> ${blogVO.schema }
						</a></td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>

	<!-- 引入脚步 -->
	<c:import url="footer.jsp"></c:import>
</body>

</html>