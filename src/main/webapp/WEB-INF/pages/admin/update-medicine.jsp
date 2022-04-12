<%-- 
    Document   : update-medicine
    Created on : Apr 11, 2022, 7:56:50 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info">Update medicine</h1>
<c:url value="/admin/update-medicine/${medicineUpdate.id}" var="action"/>
<form:form method="patch" action="${action}" modelAttribute="medicineUpdate" >
    <div class="form-group">
        <label>Name</label>
        <form:input path="name" value="${medicineUpdate.name}" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Description</label>
        <form:textarea path="description" value="${medicineUpdate.description}" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Price</label>
        <form:input path="price" value="${medicineUpdate.price}" class="form-control"/>
    </div>
    <input type="submit" value="UPDATE" class="btn btn-danger"/>
</form:form>
