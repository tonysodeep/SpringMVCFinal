<%-- 
    Document   : add-medicine
    Created on : Apr 1, 2022, 5:35:00 PM
    Author     : hyngu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h1 class="text-center text-danger">Medicine Management</h1>
    <c:if test="${errMsg!=null}">
        <div class="alert alert-danger">
            ${errMsg}
        </div>
    </c:if>

    <c:url value="" var="action"/>
    <form:form method="post" action="" modelAttribute="medicine" enctype="multipart/form-data">
        <div class="form-group">
            <label>Product name</label>
            <form:input path="name" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Product price</label>
            <form:input path="price" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Product image</label>
            <form:input type="file" path="file" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Product category</label>
            <form:select path="category" class="form-control">
                <c:forEach items="${categories}" var="c">
                    <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <input type="submit" value="add product" class="btn btn-danger"/>
    </form:form>
</div>

<br><br>
