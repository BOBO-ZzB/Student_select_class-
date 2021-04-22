<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课系统</title>
    <%@include file="../common/head.jsp" %>

    <script type="text/javascript">

        $(function () {
            $(".delete").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().children("td").eq(1).text() + "】的信息及其选课信息吗？");
            })
        })

    </script>

</head>
<body id="background">
<%@include file="../common/menu.jsp" %>
<div class="manage_title">
    <b>用户管理</b>
</div>

<div class="form_show">
    <div align="center">
        <table>
            <tr>
                <td>ID</td>
                <td>用户名</td>
                <td>密码</td>
                <td>权限等级</td>
                <td><a class="add" href="page/edit_page/User_edit.jsp"> 添加用户 </a></td>
            </tr>
            <%--展示学生信息--%>
            <c:forEach items="${requestScope.page.items}" var="manager">
                <tr>
                    <td>${manager.id}</td>
                    <td>${manager.username}</td>
                    <td>${manager.password}</td>
                    <td>
                        <c:if test="${manager.type==0}">学生</c:if>
                        <c:if test="${manager.type==1}">教师</c:if>
                        <c:if test="${manager.type==2}">管理者</c:if>
                    </td>
                    <td><a class="update"
                           href="userServlet?action=getManager&id=${manager.id}&pageNo=${requestScope.page.pageNo}">修改</a>&nbsp;&nbsp;&nbsp;
                        <a class="delete"
                           href="userServlet?action=delete&id=${manager.id}&pageNo=${requestScope.page.pageNo}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="../common/page_isolate.jsp" %>
<%@include file="../common/foot.jsp" %>

</body>
</html>
