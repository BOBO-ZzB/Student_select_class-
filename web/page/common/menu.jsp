<%--主菜单和用户登录信息--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="head">
    <h2>欢迎来到学生信息管理系统</h2>
</div>
<div id="menu">
    <i id="control">
        <a href="studentServlet?action=page">学生信息&nbsp;&nbsp;&nbsp;&nbsp;</a>
        <a href="teacherServlet?action=page">教师信息&nbsp;&nbsp;&nbsp;&nbsp;</a>
        <a href="courseServlet?action=page">课程信息&nbsp;&nbsp;&nbsp;&nbsp;</a>
        <a href="deptServlet?action=page">学院信息&nbsp;&nbsp;&nbsp;&nbsp;</a>
        <a href="selectClassServlet?action=page">选课信息&nbsp;&nbsp;&nbsp;</a>
        <c:if test="${sessionScope.manager.type==2}">
            <a href="userServlet?action=page">用户信息</a>
        </c:if>
    </i>
    <i id="user_info">
        欢迎 <b>&nbsp;${sessionScope.manager.username}&nbsp;</b>登录选课系统&nbsp;&nbsp;丨&nbsp;&nbsp;<a
            href="userServlet?action=Logout">注销</a>
    </i>
</div>
