<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑学生信息</title>
    <%@include file="/page/common/head.jsp" %>

    <script type="text/javascript">
        /*提交按钮及验证是否符合格式*/
        $(function () {
            $("#submit").click(function () {
                var age = document.form.sage.value
                if (age <= 14 || age >= 24) {
                    alert("学生年龄必须在14~24之间，请重新输入！")
                    document.form.sage.value = ""
                    return false;
                }
            })
        })
    </script>

</head>
<body id="background2">

<%@include file="../common/menu.jsp" %>
<div class="manage_title" style="margin-top: 100px">
    <b>编辑学生信息</b>
</div>

<div class="form_show">
    <div align="center" style="margin-top: 50px">
        <form action="studentServlet" method="get" name="form">
            <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
            <input type="hidden" name="id" value="${requestScope.studnet.sno}">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <table>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>系别</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td><input name="sno" type="text" value="${requestScope.studnet.sno}" readonly></td>
                    <td><input name="sname" type="text" value="${requestScope.studnet.sname}"></td>
                    <td>
                        <select name="ssex">
                            <option value="男"
                                    <c:if test="${requestScope.studnet.ssex == '男'} ">selected</c:if> >男
                            </option>
                            <option value="女"
                                    <c:if test="${requestScope.studnet.ssex == '女'}">selected</c:if> >女
                            </option>
                        </select>
                        <%--<input name="ssex" type="text" value="${requestScope.studnet.ssex}">--%>
                    </td>
                    <td><input name="sage" type="text" value="${requestScope.studnet.sage}"></td>
                    <td><input name="sdept" type="text" value="${requestScope.studnet.sdept}"></td>
                    <td><input class="edit_update" type="submit" value="提交" id="submit"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../common/foot.jsp" %>
</body>
</html>
