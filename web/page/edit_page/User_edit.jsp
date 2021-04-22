<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑用户信息</title>
    <%@include file="/page/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                var username = document.form.username.value;
                var password = document.form.password.value;

                var passwordPatt = /^\w{5,12}$/;
                var usernamePatt = /^\w{3,12}$/;

                if (username == "") {
                    alert("用户名不能为空")
                    return false;
                }
                if (password == "") {
                    alert("密码不能为空")
                    return false;
                }
                if (!usernamePatt.test(username)) {
                    alert("用户名必须要3~12位字母或数字组成！");
                    return false;
                }
                if (!passwordPatt.test(password)) {
                    alert("密码必须要5~12位字母或数字组成！")
                    return false;
                }


            })


        })
    </script>
</head>
<body id="background2">
<%@include file="../common/menu.jsp" %>
<div class="manage_title" style="margin-top: 100px">
    <b>编辑用户信息</b>
</div>

<div class="form_show">
    <div align="center" style="margin-top: 50px">
        <form action="userServlet" method="get" name="form">
            <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
            <input type="hidden" name="id" value="${requestScope.manager.id}">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <table>
                <tr>
                    <td>ID</td>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>权限等级</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td><input name="id" type="text" value="${requestScope.manager.id}" readonly></td>
                    <td><input name="username" type="text" value="${requestScope.manager.username}"></td>
                    <td><input name="password" type="text" value="${requestScope.manager.password}"></td>
                    <%--            <td><input name="type" type="text" value="${requestScope.manager.type}"></td>--%>
                    <td>
                        <select name="type">
                            <option value="0" <c:if test="${requestScope.manager.type== '0'}">selected</c:if>>学生
                            </option>
                            <option value="1"
                                    <c:if test="${requestScope.manager.type== '1'}">selected</c:if> >教师
                            </option>
                            <option value="2"
                                    <c:if test="${requestScope.manager.type== '2'}">selected</c:if> >超级管理员
                            </option>
                        </select>
                    </td>
                    <td><input class="edit_update" type="submit" value="提交" id="submit"></td>
                </tr>

            </table>
        </form>
    </div>
</div>
<%@include file="../common/foot.jsp" %>
</body>
</html>
