<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Regist</title>
    <%@include file="/page/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //单击验证码切换图片
            $("#code_img").click(function () {
                this.src = "${basePath}/kaptcha.jpg?d=" + new Date();
            });
            //处理注册按钮的事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为3到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{3,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("#errorMsg").text("用户名不合法！");

                    return false;
                }
                //验证密码：
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("#errorMsg").text("密码不合法！");

                    return false;
                }
                //验证两次密码是否相同
                var repwdText = $("#repwd").val();
                if (repwdText != passwordText) {
                    $("#errorMsg").text("两次密码不相同！");
                    return false;
                }
                //验证验证码是否正确
                var codeText = $("#code").val();
                // alert("去空格前：["+codeText+"]")
                codeText = $.trim(codeText);
                if (codeText == null) {
                    $("#errorMsg").text("验证码不能为空！");
                    return false;
                }
                // 去掉错误信息
                $("span.errorMsg").text("");
            });
        });
    </script>

</head>
<body background="image/background.jpg">
<br>
<h2 align="center" id="l_r_Head">学生信息管理系统</h2>
<div align="center" id="form">
    <div align="center" id="regist_form">
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="Regist">
            <h2 id="h">注册</h2>
            <table>
                    <span id="errorMsg" style="margin-right: 80px">
                        <%=request.getAttribute("msg") == null ? "请输入新的用户名和密码" : request.getAttribute("msg")%>
                    </span>
                <tr>
                    <td><label class="label_lr">用户名称：</label></td>
                    <td><input class="text_input_lr" type="text" autocomplete="off" tabindex="1"
                               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"
                               placeholder="请输入用户名" name="username" id="username"></td>
                    <td><i class="tip">由3~12位数字或字母组成</i></td>
                </tr>
                <tr>
                    <td><label class="label_lr">输入密码：</label></td>
                    <td><input class="text_input_lr" type="password" autocomplete="off" tabindex="1"
                               placeholder="请输入密码" name="password" id="password"></td>
                    <td><i class="tip">由5~12位数字或字母组成</i></td>
                </tr>
                <tr>
                    <td><label class="label_lr">再次输入密码：</label></td>
                    <td><input class="text_input_lr" type="password" autocomplete="off" tabindex="1"
                               placeholder="请再次输入密码" name="repwd" id="repwd"></td>
                    <br>
                </tr>
                <tr>
                    <td class="label_lr">选择用户权限：</td>
                    <td>
                        <input type="radio" name="type" value="0" checked>学生</input>
                        <input type="radio" name="type" value="1">老师</input>
                    </td>
                </tr>
                <tr>
                    <td class="label_lr">请输入验证码：</td>
                    <td><input type="text" name="code" id="code"></td>
                    <td><img id="code_img" alt="" src="kaptcha.jpg"></td>
                </tr>

            </table>
            <i style="font-style: normal;font-size: 13px;margin-left: 300px;color: deeppink">
                点击切换验证码
            </i>

            <br>
            <div>
                <input type="submit" value="注册" id="sub_btn"/>
            </div>
            <br>
            <a color="red" href="page/user/Login.jsp">已有账号？立即登录！</a>
        </form>
    </div>

</div>

</body>
</html>
