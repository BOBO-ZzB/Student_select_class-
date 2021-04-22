<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<head>
    <title>学生选课系统</title>
    <%@include file="../common/head.jsp" %>
    <script type="text/javascript">
        <%--运用单击事件来判断是否真的删除该学生，防止手滑--%>
        $(function () {
            $("a.delete").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().children("td").eq(1).text() + "】的信息及其选课信息吗？");
            });

            $(".submit_btn").click(function () {
                var input_sno = document.form_id.sno.value;
                var form_sno = document.forms[0];
                var input_sname = document.form_name.sname.value;
                var form_sname = document.forms[1];
                if (input_sno != "") {
                    form_sno.submit();
                } else if (input_sname != "") {
                    form_sname.submit();
                } else if (input_sno == "" && input_sname == "") {
                    form_sno.submit();
                }
            })
        })

        function doPrint() {
            bdhtml = window.document.body.innerHTML;
            sprnstr = "<!--startprint-->"; //开始打印标识字符串有17个字符
            eprnstr = "<!--endprint-->"; //结束打印标识字符串
            prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17); //从开始打印标识之后的内容(17为"<!--startprint-->"的长度)
            prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //截取开始标识和结束标识之间的内容
            window.document.body.innerHTML = prnhtml; //把需要打印的指定内容赋给body.innerHTML
            window.print(); //调用浏览器的打印功能打印指定区域
            window.document.body.innerHTML = bdhtml;//重新给页面内容赋值；
            return false;
        }

    </script>

</head>
<body id="background">

<%@include file="../common/menu.jsp" %>
<div class="manage_title">
    <b>学生管理</b>
    <input id="print" type="button" value="打印报表" onclick="doPrint()">
</div>
<div class="search">
    <%--    <b id="search_title">搜索条件</b>--%>

    <form action="studentServlet" method="post" style="display: inline;margin:0px" name="form_id">
        <input type="hidden" name="action" value="findByNo">
        ID：<input class="serach_input" type="text" id="sno" name="sno" value="${param.sno}">
    </form>

    <form action="studentServlet" method="post" style="display: inline;margin:30px" name="form_name">
        <input type="hidden" name="action" value="findByName">
        <c:if test="${empty param.sname}">
            姓名：<input class="serach_input" type="text" id="sname" name="sname" value="">
        </c:if>
        <c:if test="${not empty param.sname}">
            姓名：<input type="text" class="serach_input" id="sname" name="sname" value="${param.sname}">
        </c:if>
        <%--    </c:if><%=new String(request.getParameter("sname").getBytes("ISO-8859-1"),"UTF-8")%>--%>
    </form>

    <input type="button" value="查找" class="submit_btn">
</div>

<div class="form_show">
    <div align="center">
        <table>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>系别</td>
                <c:if test="${sessionScope.manager.type==2}">
                    <td><a class="add" href="page/edit_page/Student_edit.jsp"> 添加学生 </a></td>
                </c:if>
            </tr>
            <%--展示学生信息--%>
            <c:forEach items="${requestScope.page.items}" var="student">
                <tr bgcolor="">
                    <td>${student.sno}</td>
                    <td>${student.sname}</td>
                    <td>${student.ssex}</td>
                    <td>${student.sage}</td>
                    <td>${student.sdept}</td>
                    <c:if test="${sessionScope.manager.type==2}">
                        <td><a class="update"
                               href="studentServlet?action=getStudent&id=${student.sno}&pageNo=${requestScope.page.pageNo}">修改</a>&nbsp;&nbsp;&nbsp;
                            <a class="delete"
                               href="studentServlet?action=delete&id=${student.sno}&pageNo=${requestScope.page.pageNo}">删除</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${empty requestScope.page.items}">
            <div id="notfound_info">
                没有查询到符合信息的学生！
            </div>
        </c:if>

    </div>
</div>
<%@include file="../common/page_isolate.jsp" %>


<%@include file="../common/foot.jsp" %>
</body>
</html>

<div hidden>
    <!--startprint-->
    <div class="form_show">
        <div align="center">
            <h3 align="center">学生信息</h3>
            <table>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>系别</td>
                </tr>
                <%--展示学生信息--%>
                <c:forEach items="${requestScope.page.items}" var="student">
                    <tr bgcolor="">
                        <td>${student.sno}</td>
                        <td>${student.sname}</td>
                        <td>${student.ssex}</td>
                        <td>${student.sage}</td>
                        <td>${student.sdept}</td>
                    </tr>
                </c:forEach>
            </table>
            <!--endprint-->
        </div>
    </div>
</div>
