<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>博客详情</title>
<!-- 引入公共样式和脚本 -->
<c:import url="common.jsp"></c:import>
<script type="text/javascript" src="js/bloginfo.js"></script>
</head>

<body>
	<!-- 引入头部 -->
	<c:import url="header.jsp"></c:import>

	<!--中间内容部分开始-->
	<div class="container allwidth">
		<div class="templatemo-container bloginfo">
			<h3 class="title">${blog.title }</h3>
			<div id="content" class="content">
				<!-- content start -->
				${blog.content }
				<!-- end -->
			</div>
			<!-- 评论开始 -->
			<div class="commentboth">
				<h5 class="comment_title">文章评论</h5>
				<!-- 需要循环的评论内容 -->
				<div id="comment" class="comment">
					<div class="comment_author">
						<span>1楼</span><span>詹姆斯*高林思</span><span>2016/12/23</span>
					</div>
					<div class="comment_text">好文章，值得收藏！</div>
				</div>
				<!-- 循环结束 -->
			</div>
			<!-- 评论结束 -->

			<div class="tocomment">
				<input id="bid" type="hidden" value="${blog.id }"> <input
					id="current_user_id" type="hidden" value="${current_user.id }">
				<c:if test="${current_user!=null }">
					<!-- 登录后评论区域 -->
					<span>发表评论</span>
					<textarea id="comment_content"></textarea>
					<button onclick="comment_submit()" class="btn btn-success">submit</button>
				</c:if>
				<c:if test="${current_user==null }">
					<p>
						您尚未登录，回到<a href="login.jsp">登录页面</a>
					</p>
				</c:if>
			</div>
		</div>

	</div>
	<!--内容部分结束-->

	<!-- 引入脚步 -->
	<c:import url="footer.jsp"></c:import>
</body>

</html>