<%-- 
    Document   : index
    Created on : Apr 2, 2022, 11:18:20 AM
    Author     : hyngu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info" >Schedule List </h1>

<div class ="row">
    <c:forEach items="${schedules}" var="s">
        <div class="col-md-4 col-sm-12" style="padding: 10px">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">${s.clientFullname}</h4>
                    <p class="card-text">${s.clientPhone}</p>
                    <a href="<c:url value="/doctor/add-precription/${s.id}"/>" class="btn btn-danger">create Prescriptions</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

