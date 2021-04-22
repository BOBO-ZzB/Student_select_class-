<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑学院信息</title>
    <%@include file="/page/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                var name = document.form.dname.value;
                var man = document.form.dmanagerno.value;

                if (name == "") {
                    alert("学院名字不能为空！");
                    return false;
                }
                if (man == "") {
                    alert("系主任名字不能为空！");
                    return false;
                }

            })
        })
    </script>
</head>
<body id="background2">
<%@include file="../common/menu.jsp" %>
<div class="manage_title" style="margin-top: 100px">
    <b>编辑学院信息</b>
</div>

<div class="form_show">
    <div align="center" style="margin-top: 50px">
        <form action="deptServlet" method="get" name="form">
            <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
            <input type="hidden" name="id" value="${requestScope.dept.dno}">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <table>
                <tr>
                    <td>系编号</td>
                    <td>系名</td>
                    <td>系主任</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td><input name="dno" type="text" value="${requestScope.dept.dno}" readonly></td>
                    <td><input name="dname" type="text" value="${requestScope.dept.dname}"></td>
                    <td><input name="dmanagerno" type="text" value="${requestScope.dept.dmanagerno}"></td>
                    <td><input class="edit_update" type="submit" value="提交" id="submit"></td>
                </tr>

            </table>
        </form>
    </div>
</div>
<%@include file="../common/foot.jsp" %>
</body>
</html>
