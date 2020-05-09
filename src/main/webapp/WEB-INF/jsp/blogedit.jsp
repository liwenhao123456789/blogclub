<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>博客编辑</title>
<!-- 引入公共样式和脚本 -->
<c:import url="common.jsp"></c:import>

<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
<script charset="utf-8" src="kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="c1"]', {
			allowFileManager : true
		});
	});

	function check() {
		var title = $("#title").val();
		var schema = $("#schema").val();
		var content = editor.html();
		if (title.trim() == "") {
			alert("title must be not null");
			return;
		}
		if (schema.trim() == "") {
			alert("schema must be not null");
			return;
		}
		if (content.trim() == "") {
			alert("content must be not null");
			return;
		}
		$("#c2").val(content);
		if (confirm("save this blog, are you sure?")) {
			$("#form1").submit();
		}
	}
</script>
</head>

<body>
	<!-- 引入头部 -->
	<c:import url="header.jsp"></c:import>

	<!--中间内容部分开始-->
	<div class="container allwidth">
		<div class="create">
			<h1>创建博客</h1>
			<form id="form1" action="editblog.action" method="post">
				<input type="hidden" name="id" value="${blog.id }" />
				<table class="templatemo-container">
					<tr>
						<td>title:<input id="title" type="text" class="form-control"
							name="title" value="${blog.title }"/>
						</td>
					</tr>
					<tr>
						<td>kind:<br /> <select class="form-control" id="kind"
							name="kind">
								<c:forEach items="${blogKindList }" var="kind">
									<!-- 如果博客的类型和你博客类型列表的id相同时候，则被选中 -->
									<c:if test="${kind.id==blog.kid }">
										<option selected="selected" value="${kind.id }">${kind.name }</option>
									</c:if>
									<c:if test="${kind.id!=blog.kid }">
										<option value="${kind.id }">${kind.name }</option>
									</c:if>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td>schema:<br /> <textarea class="form-control" id="schema"
								name="schema" style="width: 1024px; resize: none;">${blog.schema }</textarea>
						</td>
					</tr>
					<tr>
						<td>content:<br /> <textarea class="form-control" id="c1"
								name="c1" style="width: 1024px; resize: none;" rows="30">${blog.content }</textarea><br />
							<input name="content" id="c2" type="hidden" />
						</td>
					</tr>
					<tr>
						<td align="center"><button type="button" onclick="check()"
								class="btn btn-success">提交</button>
								<button type="reset" class="btn btn-info">重置</button>
								</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!--内容部分结束-->

	<!-- 引入脚步 -->
	<c:import url="footer.jsp"></c:import>
</body>

</html>