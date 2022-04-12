<%-- 
    Document   : update-employee
    Created on : Apr 11, 2022, 6:07:54 PM
    Author     : hyngu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info">Update employee</h1>
<c:url value="/update-employee/${employeeId}" var="action"/>
<form:form method="post" action="${action}" modelAttribute="employeeUpdate" >
    <div class="form-group">
        <label>Full name</label>
        <form:input path="fullname" value="${employeeUpdate.fullname}" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Mobile</label>
        <form:input path="mobile" value="${employeeUpdate.mobile}" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Address</label>
        <form:textarea path="address" value="${employeeUpdate.address}" class="form-control"/>
    </div>
    <input type="submit" value="UPDATE" class="btn btn-danger"/>
</form:form>

