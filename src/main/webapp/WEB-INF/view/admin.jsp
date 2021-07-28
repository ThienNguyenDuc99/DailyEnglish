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
        <button class="sub_header">QUẢN LÝ TỪ</button>
        <button class="sub_header"><a href="${pageContext.request.contextPath}/topic">QUẢN LÝ CHỦ ĐỀ</a></button>
        <button class="sub_header">QUẢN LÝ TÀI KHOẢN</button>
    </div>
</div>

<button class="btn add">Thêm từ vụng</button>

<div style="height: 500px !important; overflow: auto;">
    <table class="table table-striped">
        <thead>
        <tr>
            <th style="width: 60%; text-align: center; font-size: 22px">Từ vựng</th>
            <th style="width: 40%; text-align: center; font-size: 22px">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="voca" items="${vocabularies}">
            <tr>
                <td style="text-align: center; line-height: 35px">${voca.vocaValue}</td>
                <td class="td_edit">
                    <button class="btn delete">Xóa</button>
                    <input type="hidden" property="${voca.vocaId}">
                    <button class="btn edit">Sửa</button>
                    <input type="hidden" property="${voca.vocaId}">
                    <button class="btn view_context">Ngữ cảnh</button>
                    <button class="btn add1">Thêm ngữ cảnh</button>
                    <input type="hidden" property="${voca.vocaId}">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="dialog add" title="Thêm từ" style="display:none">
    <div class="form-group">
        <label for="en">Từ vựng:</label>
        <input type="text" class="form-control en" name="vo" id="vo">
    </div>
    <div class="form-group">
        <label for="vn">Nghĩa tiếng Việt:</label>
        <input type="text" class="form-control vn" name="vn" id="vn">
    </div>
    <div class="form-group">
        <label for="vn">Nghĩa tiếng Anh:</label>
        <input type="text" class="form-control en" name="en" id="en">
    </div>
    <div class="form-group">
        <label for="vn">Phiên âm:</label>
        <input type="text" class="form-control sp" name="sp" id="sp">
    </div>
    <div class="form-group">
        <label for="vn">Hình ảnh:</label>
        <input type="file" class="form-control im" name="im" id="im">
    </div>
    <select class="pos">
        <option value="noun">noun</option>
        <option value="verb">verb</option>
        <option value="adjective ">adjective</option>
        <option value="adverb ">adverb</option>
    </select>
    <input type="submit" class="btn btn-success">
</div>


<div class="dialog edit" title="Chỉnh sửa từ" style="display:none">
    <div class="form-group">
        <label for="en">Từ vựng:</label>
        <input type="text" class="form-control en" name="vo" id="vo1">
    </div>
    <div class="form-group">
        <label for="vn">Nghĩa tiếng Việt:</label>
        <input type="text" class="form-control vn" name="vn" id="vn1">
    </div>
    <div class="form-group">
        <label for="vn">Nghĩa tiếng Anh:</label>
        <input type="text" class="form-control en" name="en" id="en1">
    </div>
    <div class="form-group">
        <label for="vn">Phiên âm:</label>
        <input type="text" class="form-control sp" name="sp" id="sp1">
    </div>
    <div class="form-group">
        <label for="vn">Hình ảnh:</label>
        <input type="text" class="form-control im" name="im">
    </div>
    <div class="form-group">
        <label for="vn">Từ loại:</label>
        <input type="text" class="form-control im" name="im">
    </div>
    <input type="submit" class="btn btn-success">
</div>

<div class="dialog add1" title="Thêm ngữ cảnh" style="display:none">
    <div class="form-group">
        <label for="en">Ngữ cảnh:</label>
        <input type="text" class="form-control co">
    </div>
    <input type="submit" class="btn btn-success">
</div>

<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/bootstrap-5.0.0-beta1-dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/libraries/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/admin.js"></script>
</body>
</html>
