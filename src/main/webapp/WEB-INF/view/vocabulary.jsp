<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/21/2021
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ vựng</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/jquery-ui-1.12.1.custom/jquery-ui.min.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vocabulary.css">
</head>
<body>
<div class="vocabulary">
    <c:forEach var="vocabulary" items="${vocabularies}">
        <div class="vocabulary1">
            <div class="image" style="background-image: url('/resources/images/${vocabulary[5]}')"></div>
            <div class="vocabulary_element">
                <div class="vocabulary2">Từ vựng: ${vocabulary[1]}</div>
                <div class="vocabulary2">Nghĩa: ${vocabulary[2]}</div>
                <div class="vocabulary2">Từ loại: ${vocabulary[3]}</div>
                <div class="vocabulary2">Tiếng Anh: ${vocabulary[4]}</div>
                <div class="vocabulary2">Phiên âm: ${vocabulary[6]}</div>
                <button class="btn re">Từ liên quan</button>
                <input type="hidden" property="${vocabulary[1]}">
            </div>
        </div>
    </c:forEach>
    <div>Ngữ cảnh:</div>
    <c:forEach var="context" items="${contexts}">
        <div>- ${context}</div>
    </c:forEach>
</div>

<c:forEach var="rela" items="${relations}">
    <tr class="">
        <c:url var="link" value="/vocabulary">
            <c:param name="value" value="${rela}"/>
        </c:url>
        <td><a href="${link}">${rela}</a></td>
    </tr>
</c:forEach>

<div class="dialog re" title="Từ liên quan: " style="display:none">
    <label>Từ liên quan:</label>
    <input type="text" class="form-control to">
    <button style="text-align: center; font-size: 18px" class="btn btn-success">LƯU</button>
</div>


<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/javascript/vocabulary.js"></script>
</body>
</html>
