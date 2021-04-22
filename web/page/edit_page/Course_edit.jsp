<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑课程信息</title>
    <%@include file="/page/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                var name = document.form.cname.value;
                var pno = document.form.cpno.value;
                var rule = /^\+?[1-9][0-9]*$/
                if (name == "") {
                    alert("课程名不能为空！")
                    return false;
                }
                if (pno == "") {
                    alert("先行课编号不能为空！")
                    return false;
                }
                if (!rule.test(pno)) {
                    alert("输入的先行号必须为正整数！")
                    document.form.cpno.value = "";
                    return false;
                }
            })
        })
    </script>

</head>
<body id="background2">

<%@include file="../common/menu.jsp" %>
<div class="manage_title" style="margin-top: 100px">
    <b>编辑课程信息</b>
</div>

<div class="form_show">
    <div align="center" style="margin-top: 50px">
        <form action="courseServlet" method="get" name="form">
            <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
            <input type="hidden" name="id" value="${requestScope.course.cno}">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <table>
                <tr>
                    <td>课程号</td>
                    <td>课程名</td>
                    <td>先行课编号</td>
                    <td>学分</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td><input name="cno" type="text" value="${requestScope.course.cno}" readonly></td>
                    <td><input name="cname" type="text" value="${requestScope.course.cname}"></td>
                    <td><input name="cpno" type="text" value="${requestScope.course.cpno}"></td>
                    <%--            <td><input name="ccredit" type="text" value="${requestScope.course.ccredit}"></td>--%>
                    <td>
                        <select name="ccredit">
                            <option value="1"
                                    <c:if test="${requestScope.course.ccredit == '1'} ">selected</c:if> >1
                            </option>
                            <option value="2"
                                    <c:if test="${requestScope.course.ccredit == '2'}">selected</c:if> >2
                            </option>
                            <option value="3"
                                    <c:if test="${requestScope.course.ccredit== '3'}">selected</c:if> >3
                            </option>
                            <option value="4"
                                    <c:if test="${requestScope.course.ccredit == '4'}">selected</c:if> >4
                            </option>
                        </select>
                    </td>
                    <td><input class="edit_update" id="submit" type="submit" value="提交"></td>
                </tr>

            </table>
        </form>
    </div>
</div>
<%@include file="../common/foot.jsp" %>
</body>
</html>
