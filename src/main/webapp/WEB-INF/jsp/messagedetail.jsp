<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MessageDetail</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function diag() {
		alert("删除成功")
	}
	
	function save(){
		var mesTitle=$('.mesTitle').val();
		var mesDate=$('.mesDate').val();
		var mesCont=$('.mesCont').val();
		var aaa={
				"title":mesTitle,
				"date":mesDate,
				"content":mesCont
			};
		$.ajax({
			url:"/messagelist/modifyByTitle",
			type:"post",
			datatype:"json",
			data:aaa,
		
			success:function(data){
				if(data == 'success'){
					alert("已保存");
					window.location.href="${path}/messagelist/queryAll";
				}else{
					alert("fail");
				}
				
			},
			error:function(){
				alert("error");
			}
		})
	}
</script>
</head>
<body>
	<h1>消息详情</h1>
	<div>
		<table>
			<tr>
				<td>
					<input type="text" class="mesTitle" name="title"  value="${message.title}" />
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" class="mesDate" name="date"  value="<fmt:formatDate value="${message.date}" pattern="yyyy-MM-dd" />"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" class="mesCont" name="content"  value="${message.content}" />
				</td>
			</tr>
		</table>
	</div>
	<!--操作按钮-->
	<div class="button_info clearfix">
		<input type="button" value="保存" class="btn_save"
			onclick="save()" /> 
		<input type="button" value="删除"
			class="delete" onclick="diag(); location.href='${path}/messagelist/delete?title=${message.title}'"/>
	</div>
</body>
</html>