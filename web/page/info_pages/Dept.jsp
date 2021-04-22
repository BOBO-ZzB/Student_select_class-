<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课系统</title>

    <%@include file="../common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $("a.delete").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().children("td").eq(1).text() + "】学院吗？");
            })

            $(".submit_btn").click(function () {
                var input_dno = document.form_id.dno.value;
                var form_dno = document.forms[0];
                var input_dname = document.form_name.dname.value;
                var form_dname = document.forms[1];
                if (input_dno != "") {
                    form_dno.submit();
                } else if (input_dname != "") {
                    form_dname.submit();
                } else if (input_dno == "" && input_dname == "") {
                    form_dno.submit();
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
    <b>学院管理</b>
    <input id="print" type="button" value="打印报表" onclick="doPrint()">
</div>

<div class="search">
    <%--    <div align="center" style="color: grey;font-style: italic;margin-top: 15px">--%>
    <form action="deptServlet" method="post" style="display: inline;margin:0px" name="form_id">
        <input type="hidden" name="action" value="findByNo"/>
        ID：<input class="serach_input" type="text" name="dno" id="dno" value="${param.dno}">
    </form>

    <form action="deptServlet" method="post" style="display: inline;margin:30px" name="form_name">
        <input type="hidden" name="action" value="findByName">
        <c:if test="${empty param.dname}">
            学院名：<input class="serach_input" type="text" name="dname" id="dname" value="">
        </c:if>
        <c:if test="${not empty param.dname}">
            学院名：<input class="serach_input" type="text" name="dname" id="dname" value="${param.dname}">
        </c:if>
    </form>
    <input type="button" value="查找" class="submit_btn">
</div>

<div class="form_show">
    <div align="center">
        <table>
            <tr>
                <td>系编号</td>
                <td>系名</td>
                <td>系主任</td>
                <c:if test="${sessionScope.manager.type==2}">
                    <td><a class="add" href="page/edit_page/Dept_edit.jsp">添加学院</a></td>
                </c:if>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="dept">
                <tr>
                    <td>${dept.dno}</td>
                    <td>${dept.dname}</td>
                    <td>${dept.dmanagerno}</td>
                    <c:if test="${sessionScope.manager.type==2}">
                        <td>
                            <a class="update"
                               href="deptServlet?action=getDept&id=${dept.dno}&pageNo=${requestScope.page.pageNo}">修改</a>&nbsp;&nbsp;&nbsp;
                            <a id="delete" class="delete"
                               href="deptServlet?action=delete&id=${dept.dno}&pageNo=${requestScope.page.pageNo}">删除</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>

        </table>

        <c:if test="${empty requestScope.page.items}">
            <div id="notfound_info">
                没有查询到符合信息的学院！
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
            <h3 align="center">学院信息</h3>
            <table>
                <tr>
                    <td>系编号</td>
                    <td>系名</td>
                    <td>系主任</td>
                </tr>
                <c:forEach items="${requestScope.page.items}" var="dept">
                    <tr>
                        <td>${dept.dno}</td>
                        <td>${dept.dname}</td>
                        <td>${dept.dmanagerno}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
    <!--endprint-->
</div>

