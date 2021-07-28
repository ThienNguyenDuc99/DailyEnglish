<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/21/2021
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chủ đề</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/show_topic.css">
</head>
<body>

<table class="table">
    <thead>
    <tr class="tr_topic">
        <th style="width: 20%; text-align: center; font-size: 22px">Hình minh họa</th>
        <th style="width: 20%; text-align: center; font-size: 22px">Từ vựng</th>
        <th style="width: 60%; text-align: center; font-size: 22px">Nghĩa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="vocabulary" items="${vocabularies}">
        <tr class="tr_topic1">
            <td>
                <div class="image" style="background-image: url('/resources/images/${vocabulary[5]}')"></div>
            </td>
            <c:url var="link" value="/vocabulary">
                <c:param name="value" value="${vocabulary[1]}"/>
            </c:url>
            <td><a href="${link}">${vocabulary[1]}</a></td>
            <td><a href="#">${vocabulary[4]}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
