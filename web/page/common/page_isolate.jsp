<%--页面的分页处理--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        /*搜索页码按钮*/
        $("#searchBtn").click(function () {
            var p = $("#pn_input").val();
            location.href = "${pageScope.basePath}${ requestScope.page.url }&pageNo=" + p;
        })
    })
</script>
<br>

<div id="page_nav" align="center">
    <%--大于首页才显示上一页和首页--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${ requestScope.page.url }&pageNo=1">首页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo-1}">
                ${requestScope.page.pageNo-1}</a>
    </c:if>
    <%--当前的页面显示--%>
    &nbsp;&nbsp;${requestScope.page.pageNo}&nbsp;&nbsp;
    <%--如果大于总页数，不显示下一页和末页--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo+1}">
                ${requestScope.page.pageNo+1}</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input type="text" value="${param.pageNo}" name="pn" id="pn_input"/>页

    <input id="searchBtn" type="button" value="确定">

</div>
<br/>
