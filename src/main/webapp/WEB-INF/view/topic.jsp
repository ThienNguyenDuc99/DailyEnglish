<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/10/2021
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/jquery-ui-1.12.1.custom/jquery-ui.min.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/jquery-ui-1.12.1.custom/jquery-ui.theme.min.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
</head>
<body>
<div class="header">
    <div class="header_content">
        <button class="sub_header"><a href="${pageContext.request.contextPath}/admin">QUẢN LÝ TỪ</a></button>
        <button class="sub_header">QUẢN LÝ CHỦ ĐỀ</button>
        <button class="sub_header">QUẢN LÝ TÀI KHOẢN</button>
    </div>
</div>

<button class="btn add">Thêm chủ đề</button>

<div style="height: 500px !important; overflow: auto;">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60%; text-align: center; font-size: 22px">Chủ đề</th>
            <th style="width: 40%; text-align: center; font-size: 22px">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="topic" items="${topics}">
            <tr>
                <td style="text-align: center; font-size: 18px">${topic.topicValue}</td>
                <td>
                    <button class="btn delete">Xóa</button>
                    <input type="hidden" property="${topic.topicId}">
                    <button class="btn edit">Sửa</button>
                    <input type="hidden" property="${topic.topicId}">
                    <button class="btn voca">Từ vựng</button>
                    <input type="hidden" property="${topic.topicId}">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="dialog add" title="Thêm chủ đề" style="display:none">
    <label>Chủ đề:</label>
    <input type="text" class="form-control to">
    <button style="text-align: center; font-size: 18px" class="btn btn-success">LƯU</button>
</div>

<div class="dialog edit" title="Sửa chủ đề" style="display:none">
    <label>Chủ đề:</label>
    <input type="text" class="form-control to1">
    <button style="text-align: center; font-size: 18px" class="btn btn-success">LƯU</button>
</div>

<div class="dialog voca" title="Từ vựng" style="display:none">
    <div class="form-group">
        <label class="show_voca">Từ vựng:</label>
        <div class="voca_admin">
            <c:forEach var="voca" items="${vocabularies}">
                <div class="voca_admin1">
                    <input type="checkbox" class="check_voca">
                    <input type="hidden" property="${voca.vocaId}">
                    <div class="sub_voca_admin" style="text-align: center; font-size: 18px">${voca.vocaValue}</div>
                </div>
            </c:forEach>
        </div>
        <input class="choose_voca" type="text" value="Chọn chủ đề">
    </div>
    <button style="text-align: center; font-size: 18px" class="btn btn-success">LƯU</button>
</div>

<%--<div class="dialog del" title="Cảnh báo" style="display:none">--%>
<%--    <button style="text-align: center; font-size: 18px" class="btn del">Có</button>--%>
<%--</div>--%>

<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/topic.js"></script>
</body>
</html>
