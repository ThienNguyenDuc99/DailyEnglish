<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>

<head>
    <title>English Daily</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>

<body>
<div class="header">
    <div class="header_content">
        <button class="sub_header">CHỦ ĐỀ</button>
        <button class="sub_header">HỌC TỪ MỚI</button>
        <button class="sub_header">ÔN TỪ CŨ</button>
    </div>
    <div class="sub_header user">NGƯỜI DÙNG
        <button type="button" class="user_icon"></button>
        <div class="dropdown-content">
            <a class="dropdown-item" href="#">Thông tin cá nhân</a>
            <a class="dropdown-item" href="#">Lịch sử</a>
            <security:authorize access="hasRole('ADMIN')">
                <a href="${pageContext.request.contextPath}/admin">Quản trị viên</a>
            </security:authorize>
            <form:form action="${pageContext.request.contextPath}/logout"
                       method="POST">
                <input type="submit" value="Đăng xuất"/>
            </form:form>
        </div>
    </div>
</div>
<div>
    <c:forEach var="topic" items="${topics}">
        <c:url var="link" value="/show-topic">
            <c:param name="value" value="${topic.topicValue}"/>
        </c:url>
       <a href="${link}">${topic.topicValue}</a>
    </c:forEach>
</div>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/jquery-3.5.1.min.js"></script>

</body>

</html>









