<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
 </style>

	<script>
		<%--
			定义规则：
				用户名：8-20位的单词字符 [a-zA-Z0-9] (w)

		--%>

        /**
		 * 校验用户名
         * @returns {boolean}
         */
		function checkUserName() {
		    //获取id为username的输入框对象
		    var username = $("#username");

		    //获取输入的用户名
		    var usernameValue = username.val();

		    //校验输入内容的正则表达式
		    var reg_username = /^\w{8,20}$/;

		    //校验的结果
			var flag = reg_username.test(usernameValue);

			//根据校验的结果执行相应的操作
			if(flag) {
                username.css("border","2px solid green");
            }else {
			    username.css("border","2px solid red");
            }
            return flag;
		}


		function checkPassword() {
		    //获取密码输入框对象
		    var password = $("#inputPassword1");

		    //获取输入框的内容
		    var passwordValue = password.val();

		    //用于校验的正则表达式
            var reg_password = /^\w{8,20}$/;

            //校验的结果
            var flag = reg_password.test(passwordValue);

            if(flag) {
                password.css("border","2px solid green");
			}else {
                password.css("border","2px solid red");
			}
			return flag;

		}

		function confirmPassword() {

		    var confirmPassword = $("#confirmPassword");
		    var password = $("#password");

		    var confirmPasswordValue = confirmPassword.val();
		    var passwordValue = password.val();

            //用于校验的正则表达式
            var reg_confirmPassword = /^\w{8,20}$/;

            var flag = reg_confirmPassword.test(confirmPasswordValue) && checkPassword();

            if(flag) {
                confirmPassword.css("border","2px solid green");
			}else{
                confirmPassword.css("border","2px solid red");
			}

            return flag;
		}

		function checkEmail() {
		    var email = $("#email");

		    var emailValue = email.val();

		    var reg_email = /^\w+@\w+\.\w+$/

			var flag = reg_email.test(emailValue);

		    if(flag) {
                email.css("border","2px solid green");
			}else {
                email.css("border","2px solid red");
			}
			return flag;
		}

		function checkName() {

		    var user = $("#user");

		    var userValue = user.val();

		    //一个非空字符，不为空
		    var reg_userValue = /\S/;

			var flag = reg_userValue.test(userValue);

            if(flag) {
                user.css("border","2px solid green");
            }else {
                user.css("border","2px solid red");
            }

            return flag;
		}

		//页面载入事件
		$(document).ready(
		    function(){
                $("#register").submit(function () {

                    //如果当前表单中所有的表单项都校验成功,才能注册6y
                    return checkUserName() && checkPassword() && confirmPassword() && checkEmail() && checkName() ;
                }) ;

                $("#username").blur(checkUserName);
		        $("#inputPassword1").blur(checkPassword);
                $("#confirmPassword").blur(confirmPassword);
                $("#email").blur(checkEmail);
                $("#user").blur(checkName);

			}
		);
	</script>
</head>
<body>
<%--
	动态加载顶部
--%>
<jsp:include page="/jsp/head.jsp" />

<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<span>会员注册</span>USER REGISTER
		<form class="form-horizontal" style="margin-top:5px;" action="${pageContext.request.contextPath}/user?method=register" method="post">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputPassword1" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" name="password" id="inputPassword1" placeholder="请输入密码">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="confirmPassword" placeholder="请输入确认密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="email" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			      <input type="email" class="form-control" name="email" id="email" placeholder="Email">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="user" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="user" name="name" placeholder="请输入姓名">
			    </div>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio"  id="inlineRadio1" name="sex" value="男"> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" id="inlineRadio2" name="sex" value="女"> 女
			</label>
			</div>
			  </div>		
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			      <input type="date" class="form-control" id="date" name="birthday">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" name="check" >
			      
			    </div>
			    <div class="col-sm-2">
			    <%--<img src="${pageContext.request.contextPath}/image/captcha.jhtml"/>--%>
					<img src="/checkCode" onclick="changeCodeImg(this)" >
					<script type="text/javascript">
						function changeCodeImg(img) {
                            // var img = $("#msg");
                            img.src="/checkCode?"+new Date().getTime();
						}
					</script>
			    </div>
			    
			  </div>
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="注册" name="submit" border="0" id="register"
				    style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	  
	
	<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2009-202 品优商城 版权所有
		</div>

</body></html>




