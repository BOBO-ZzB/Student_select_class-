<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑教师信息</title>
    <%@include file="/page/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                var age = document.form.tage.value;
                var cno1 = document.form.cno1.value;
                var name = document.form.tname.value;
                if (age <= 24 || age >= 70) {
                    alert("学生年龄必须在24~70之间，请重新输入！")
                    document.form.tage.value = ""
                    return false;
                }
                if (cno1 == "") {
                    alert("教师必须要有主讲课程(1)！");
                    return false;
                }
                if (name == "") {
                    alert("教师必须拥有名字！");
                    return false;
                }

            })
        })
    </script>

</head>
<body id="background2">
<%@include file="../common/menu.jsp" %>
<div class="manage_title" style="margin-top: 100px">
    <b>编辑教师信息</b>
</div>

<div class="form_show">
    <div align="center" style="margin-top: 50px">
        <form action="teacherServlet" method="get" name="form">
            <input type="hidden" name="action" value="${empty param.id?"add":"update"}">
            <input type="hidden" name="id" value="${requestScope.teacher.tno}">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <table class="t_tr">
                <tr>
                    <td>教工号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>学历</td>
                    <td>职称</td>
                </tr>
                <tr>
                    <td>
                        <input name="tno" type="text" value="${requestScope.teacher.tno}" readonly>
                    </td>

                    <td>
                        <input name="tname" type="text" value="${requestScope.teacher.tname}">
                    </td>

                    <td>
                        <select name="tsex">
                            <option value="男"
                                    <c:if test="${requestScope.teacher.tsex == '男'} ">selected</c:if> >男
                            </option>
                            <option value="女"
                                    <c:if test="${requestScope.teacher.tsex == '女'}">selected</c:if> >女
                            </option>
                        </select>
                    </td>

                    <td>
                        <input name="tage" type="text" value="${requestScope.teacher.tage}">
                    </td>

                    <td>
                        <select name="teb">
                            <option value="博士"
                                    <c:if test="${requestScope.teacher.teb == '博士'}">selected</c:if> >博士
                            </option>
                            <option value="学士"
                                    <c:if test="${requestScope.teacher.teb == '学士'}">selected</c:if> >硕士
                            </option>
                            <option value="硕士"
                                    <c:if test="${requestScope.teacher.teb == '硕士'}">selected</c:if> >学士
                            </option>
                        </select>
                    </td>

                    <td>
                        <select name="tpt">
                            <option value="助教"
                                    <c:if test="${requestScope.teacher.tpt == '助教'}">selected</c:if> >助教
                            </option>
                            <option value="讲师"
                                    <c:if test="${requestScope.teacher.tpt == '讲师'}">selected</c:if> >讲师
                            </option>
                            <option value="副教授"
                                    <c:if test="${requestScope.teacher.tpt == '副教授'}">selected</c:if> >副教授
                            </option>
                            <option value="教授"
                                    <c:if test="${requestScope.teacher.tpt == '教授'}">selected</c:if> >教授
                            </option>
                        </select>
                    </td>
                </tr>
                <tr style="margin-left: 50px">
                    <td colspan="3">主讲课程</td>
                    <td>操作</td>
                </tr>
                <tr>

                    <td>
                        主讲1：
                        <select name="cno1">
                            <c:forEach items="${sessionScope.page_c}" var="course">
                                <option name="cno1" value="${course.cname}"
                                        <c:if test="${ course.cname == requestScope.teacher.cno1}">selected</c:if> >
                                        ${course.cname}
                                </option>
                            </c:forEach>
                        </select>
                    </td>

                    <td>主讲2：
                        <select name="cno2">
                            <option></option>
                            <c:forEach items="${sessionScope.page_c}" var="course">
                                <option name="cno2" value="${course.cname}"
                                        <c:if test="${course.cname == requestScope.teacher.cno2}">selected</c:if> >
                                        ${course.cname}
                                </option>
                            </c:forEach>
                        </select>
                    </td>

                    <td>主讲3：
                        <select name="cno3">
                            <option></option>
                            <c:forEach items="${sessionScope.page_c}" var="course">
                                <option name="cno3" value="${course.cname}"
                                        <c:if test="${course.cname == requestScope.teacher.cno3}">selected</c:if> >
                                        ${course.cname}
                                </option>
                            </c:forEach>
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
