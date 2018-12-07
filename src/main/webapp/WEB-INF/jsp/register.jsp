<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta charset="utf-8">
<title>register</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	
	<!--用户注册手册验证 -->
	<script type="text/javascript">
	<!--用户注册手册验证 -->
		function disable() {
			document.getElementById("btnRegister").disabled = true
			$(".info_inner button").attr("style", "background:#c0c0c0");
		}
		function enable() {
			document.getElementById("btnRegister").disabled = false
			$(".info_inner button").attr("style", "background:#2abba3");
		}
		
	<!--注册验证是否已注册 -->
		function check(){
			var user_phone=$('.user_phone').val();
			var user_pwd=$('.user_pwd').val();
			var phone_No={
					"phone":user_phone,
					"password":user_pwd
				};
			$.ajax({
				url:"/user/checkReg",
				type:"post",
				datatype:"json",
				data:phone_No,
				success:function(data){
					if(data == 'success'){
						alert("注册成功！");
						window.location.href="${path}/user/register";
					}else{
						alert("该手机号已注册，请直接登录！");
						window.location.href="${path}/user/login";
					}
				},
				error:function(){
					alert("error");
					window.location.href="${path}/user/login";
				}
			})
		}
		
		
	</script>

</head>
<body>
	<input id="basePath" type="hidden" value="<%=basePath%>" />
	<div>
		<h1>注册</h1>
		<table>
			<tr>
				<td>
					<input type="text" id="phone" name="phone" class="user_phone" placeholder="请输入手机号" pattern="^1(3|4|5|7|8)\d{9}$" required/> 
				</td>
			</tr>
			
			<tr>
				<td>
					<input name="random" type="text" placeholder="请输入验证码"/> 
					<img src="checkCode" alt="" width="100" height="32" class="passcode" onclick="this.src=this.src+'?'">
					
 					<!-- <input type="button" class="obtain generate_code" value=" 获取验证码" onclick="settime(this);"> -->
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="password" id="password" name="password" class="user_pwd" pattern="[A-Za-z0-9]{4,20}" required placeholder="请输入密码"> <label class="left"></label>
				</td>
			</tr>
			 
			<tr>
				<td>
					<input type="checkbox" onclick="if (this.checked) {enable()} else {disable()}" class="left mt4" style="margin-right: 20px;" />我已阅读同意
					<a href="#" class="left">《用户注册协议》</a>
				</td>
			</tr>
			
			<tr>
				<td>
					<button id="btnRegister"type="submit" disabled="disabled" onclick="check()">注册</button>
				</td>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">  
  
//倒计时  
var countdown=60;  
function settime(val) {  
    if (countdown == 0) {  
        val.removeAttribute("disabled");  
        val.value="获取验证码";  
        countdown = 60;  
        return false;  
    } else {  
        val.setAttribute("disabled", true);  
        val.value="重新发送(" + countdown + ")";  
        countdown--;  
    }  
    setTimeout(function() {  
        settime(val);  
    },1000);  
}  
</script> 
</html>


