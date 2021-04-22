<%--页首--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basepath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath", basepath);
%>
<!--base标签一定要放在开头位置-->
<base href="<%=basepath%>">
<%--加载css文件和jQuery集合--%>
<link type="text/css" rel="stylesheet" href="static/css/css.css"/>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>