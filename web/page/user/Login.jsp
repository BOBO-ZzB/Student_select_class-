<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="../common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#sub_btn").click(function () {
                var uname = $("#username").val();
                var passwd = $("#password").val();
                // alert(uname)
                if (uname == "") {
                    $("#errorMsg").text("用户名不能为空！");
                    return false;
                }
                if (passwd == "") {
                    $("#errorMsg").text("密码不能为空！");
                    return false;
                }
            });
        });
    </script>
</head>
<body background="image/background.jpg">
<br/>
<br/>
<br/>

<h2 align="center" id="l_r_Head">学生信息管理系统</h2>
<div align="center" id="login_form">
    <form action="userServlet" method="post">
        <input type="hidden" name="action" value="Login">
        <h3 id="h">登录</h3>
        <span id="errorMsg" style="margin-left: 50px">
                <%=request.getAttribute("msg") == null ? "请输入用户名和密码" : request.getAttribute("msg")%>
            </span>
        <br/>
        <label class="label_lr">用户名称：</label>
        <input class="text_input_lr" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" id="username"
               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>" name="username">
        <br/>
        <br/>
        <label class="label_lr">用户密码：</label>
        <input class="text_input_lr" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"
               id="password">
        <br/>
        <br/>
        <div>
            <input type="submit" value="登录" id="sub_btn" class="sub_btn"/>
        </div>
        <br/>
        <a color="red" href="page/user/Regist.jsp">没有账号？立即注册！</a>
    </form>
</div>


</body>
</html>
