<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑课程信息</title>
    <%@include file="/page/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                var sname = document.form.sno.value;
                var tname = document.form.tno.value;
                var cname = document.form.cno.value;
                var grade = document.form.grade.value;
                var rule = /^\+?[1-9][0-9]*$/;
                if (sname == "") {
                    alert("学生名字不能为空！");
                    return false;
                }
                if (cname == "") {
                    alert("课程名不能为空！");
                    return false;
                }
                if (tname == "") {
                    alert("教师名字不能为空！");
                    return false;
                }
                if (grade == "") {
                    alert("成绩不能为空！");
                    return false;
                }
                if (!rule.test(grade)) {
                    alert("请输入有效的成绩分数（正整数）");
                    return false;
                }
                if (grade > 100) {
                    alert("成绩必须在100分以内！");
                    return false;
                }


            })
        })
    </script>

</head>
<body id="background2">
<%@include file="../common/menu.jsp" %>
<div class="manage_title" style="margin-top: 100px">
    <b>编辑选课信息</b>
</div>

<div class="form_show">
    <div align="center" style="margin-top: 50px">
        <form action="selectClassServlet" method="get" name="form">
            <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
            <input type="hidden" name="sct_no" value="${requestScope.sct.sct_no}">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <table>
                <tr>
                    <td>学生名</td>
                    <td>课程名</td>
                    <td>教师名</td>
                    <td>成绩</td>
                    <td>操作</td>
                </tr>

                <tr>
                    <%--            <input name="sno" type="text" value="${requestScope.sct.sno}" >--%>
                    <c:if test="${sessionScope.manager.type==2}">
                        <td>
                            <c:if test="${not empty requestScope.sct.sno}">
                                <input hidden type="text" name="sno" value="${requestScope.sct.sno}" readonly>
                                <input
                                <c:forEach items="${sessionScope.page_s}" var="student">
                                <c:if test="${student.sno == requestScope.sct.sno}"> value="${student.sname} </c:if> "
                                </c:forEach> readonly>

                            </c:if>

                            <c:if test="${empty requestScope.sct.sno}">
                                <select name="sno">
                                    <option></option>
                                    <c:forEach items="${sessionScope.page_s}" var="student">
                                        <option name="sno" value="${student.sno}"
                                                <c:if test="${student.sno == requestScope.sct.sno}">selected</c:if>>
                                                ${student.sname}
                                        </option>
                                    </c:forEach>
                                </select>
                            </c:if>
                        </td>

                        <td>
                            <select name="cno">
                                <c:if test="${not empty requestScope.sct.cno}">
                                    <option name="cno" value="${course.cno}">${course.cname}</option>
                                </c:if>
                                <c:if test="${empty requestScope.sct.cno}">
                                    <option></option>
                                </c:if>

                                <c:forEach items="${sessionScope.page_c}" var="course">
                                    <option name="cno" value="${course.cno}"
                                            <c:if test="${course.cno == requestScope.sct.cno}">selected</c:if> >
                                            ${course.cname}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>

                        <td>
                            <select name="tno">
                                <c:if test="${not empty requestScope.sct.tno}">
                                    <option name="tno" value="${teacher.tno}">${teacher.tname}</option>
                                </c:if>
                                <c:if test="${empty requestScope.sct.tno}">
                                    <option></option>
                                </c:if>

                                <c:forEach items="${sessionScope.page_t}" var="teacher">
                                    <option value="${teacher.tno}"
                                            <c:if test="${teacher.tno == requestScope.sct.tno}">selected</c:if> >
                                            ${teacher.tname}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </c:if>

                    <c:if test="${sessionScope.manager.type==1}">
                        <td>
                            <input hidden name="sno" value="${requestScope.sct.sno}">
                            <input
                            <c:forEach items="${sessionScope.page_s}" var="student">
                            <c:if test="${student.sno == requestScope.sct.sno}"> value="${student.sname} </c:if> "
                            </c:forEach> readonly>
                        </td>
                        <td>
                            <input hidden name="cno" value="${requestScope.sct.cno}">
                            <input
                            <c:forEach items="${sessionScope.page_c}" var="course">
                            <c:if test="${course.cno == requestScope.sct.cno}"> value="${course.cname} </c:if> "
                            </c:forEach> readonly>
                        </td>
                        <td>
                            <input hidden name="tno" value="${requestScope.sct.tno}">
                            <input
                            <c:forEach items="${sessionScope.page_t}" var="teacher">
                            <c:if test="${teacher.tno == requestScope.sct.tno}"> value="${teacher.tname} </c:if> "
                            </c:forEach> readonly>
                        </td>
                    </c:if>

                    <td>
                        <input name="grade" type="text" value="${requestScope.sct.grade}">
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
