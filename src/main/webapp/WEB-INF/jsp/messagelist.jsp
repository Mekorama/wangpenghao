<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>

<!DOCTYPE HTML>
<html>
<head>
<title>MessageList</title>
</head>
<body>
<h1>消息列表</h1>
	<div class="col-md-12">
		<table class="table table-hover">
			<tr>
				<th class="width150">标题</th>
				<th class="width250">时间</th>
			</tr>
			<c:forEach items="${messageList}" var="message">
			
					<tr>
						<td>${message.title}</td>
						<td><fmt:formatDate value="${message.date}"
									pattern="yyyy-MM-dd" /></td>
						<td>
							<input type="submit" value="修改" class="btn_modify" onclick="location.href='${path}/messagelist/queryByTitle?title=${message.title}';" />
							<input type="button" value="删除" class="btn_delete" onclick="if (!confirm('您确定要删除选中的记录吗？')) {return;} location.href='${path}/messagelist/delete?title=${message.title}';" />
						</td>
					</tr>
		
			</c:forEach>
		</table>
	</div>
</body>
</html>
