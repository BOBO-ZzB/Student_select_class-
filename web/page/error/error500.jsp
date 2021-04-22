<%--
  Created by IntelliJ IDEA.
  User: BOBO
  Date: 2020/11/24
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%--错误页面500显示的内容--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
    <%@include file="../common/head.jsp" %>
</head>
<body background="image/bgg.jpg">

<div class="error_bg">500</div>
<div class="error_bg">
    <img src="image/error.png"/>
    <%@include file="../common/poem.jsp" %>
</div>
<div class="error_bg" style="font-size: 20px">好像哪里出现了什么问题......</div>
<div class="error_bg"><a href="page/user/Login_success.jsp">返回首页</a></div>

</body>
</html>
