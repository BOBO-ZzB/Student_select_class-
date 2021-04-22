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

            $(".submit_btn").click(function () {
                var input_tno = document.form_id.tno.value;
                var form_tno = document.forms[0];
                var input_tname = document.form_name.tname.value;
                var form_tname = document.forms[1];
                if (input_tno != "") {
                    form_tno.submit();
                } else if (input_tname != "") {
                    form_tname.submit();
                } else if (input_tno == "" && input_tname == "") {
                    form_tno.submit();
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
    <b>教师管理</b>
    <input id="print" type="button" value="打印报表" onclick="doPrint()">
</div>
<div class="search">
    <%--    <div align="center" style="color: grey;font-style: italic;margin-top: 15px">--%>
    <form action="teacherServlet" method="post" style="display: inline;margin:0px" name="form_id">
        <input type="hidden" name="action" value="findByNo">
        ID：<input class="serach_input" type="text" id="tno" name="tno" value="${param.tno}">
    </form>

    <form action="teacherServlet" method="post" style="display: inline;margin:30px" name="form_name">
        <input type="hidden" name="action" value="findByName">
        <c:if test="${empty param.tname}">
            姓名：<input class="serach_input" type="text" id="tname" name="tname" value="">
        </c:if>
        <c:if test="${not empty param.tname}">
            姓名：<input class="serach_input" type="text" id="tname" name="tname" value="${param.tname}">
        </c:if>
    </form>
    <input type="button" value="查找" class="submit_btn">
</div>

<div class="form_show">
    <div align="center">
        <table>
            <tr>
                <td>教工号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>学历</td>
                <td>职称</td>
                <td style="width: 300px">主讲课程</td>
                <c:if test="${sessionScope.manager.type==2}">
                    <td><a class="add" href="page/edit_page/Teacher_edit.jsp">添加教师</a></td>
                </c:if>
            </tr>

            <c:forEach items="${requestScope.page.items}" var="teacher">
                <tr>
                    <td>${teacher.tno}</td>
                    <td>${teacher.tname}</td>
                    <td>${teacher.tsex}</td>
                    <td>${teacher.tage}</td>
                    <td>${teacher.teb}</td>
                    <td>${teacher.tpt}</td>
                    <td>${teacher.cno1}&nbsp;&nbsp;${teacher.cno2}&nbsp;&nbsp;${teacher.cno3}</td>
                    <c:if test="${sessionScope.manager.type==2}">
                        <td>
                            <a class="update"
                               href="teacherServlet?action=getTeacher&id=${teacher.tno}&pageNo=${requestScope.page.pageNo}">修改</a>&nbsp;&nbsp;&nbsp;
                            <a id="delete" class="delete"
                               href="teacherServlet?action=delete&id=${teacher.tno}&pageNo=${requestScope.page.pageNo}">删除</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>

        </table>

        <c:if test="${empty requestScope.page.items}">
            <div id="notfound_info">
                没有查询到符合信息的教师！
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
    <div class="form_show" style="height: 500px">
        <div align="center">
            <h3 align="center">教师信息</h3>
            <table>
                <tr>
                    <td>教工号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>学历</td>
                    <td>职称</td>
                    <td>主讲课程</td>
                </tr>

                <c:forEach items="${requestScope.page.items}" var="teacher">
                    <tr>
                        <td>${teacher.tno}</td>
                        <td>${teacher.tname}</td>
                        <td>${teacher.tsex}</td>
                        <td>${teacher.tage}</td>
                        <td>${teacher.teb}</td>
                        <td>${teacher.tpt}</td>
                        <td>${teacher.cno1}&nbsp;&nbsp;${teacher.cno2}&nbsp;&nbsp;${teacher.cno3}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <!--endprint-->
</div>

