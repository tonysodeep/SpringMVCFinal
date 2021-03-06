<%-- 
    Document   : header
    Created on : Apr 1, 2022, 4:23:54 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->

    <a class="navbar-brand" href="<c:url value="/doctor/"/>">Private Clinic Management</a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->

    <div class="collapse navbar-collapse" id="collapsibleNavbar">

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/doctor/"/>">Schedule</a>
            </li>
            <c:if test="${scheduleId != null}">
                <li class="nav-item">
                    <a class="nav-link text-info" href="<c:url value="/doctor/prescription/${sheduleId}"/>">Prescription <span class="badge badge-danger presCounter">${presStats.totalQuantity}</span></a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link text-info" 
                   href="#">
                    <img src="${pageContext.session.getAttribute("currentUser").image}" 
                         class="rounded-circle" 
                         width="40"
                         alt="user_avatar"/>
                    ${pageContext.request.userPrincipal.name}
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-success" href="<c:url value="/logout"/>">Logout</a>
            </li>
        </ul>
    </div>
    <c:url value="/admin/medicine" var="homeAction"/>
    <form class="form-inline" action="${homeAction}">
        <input class="form-control mr-sm-2" 
               name="kw"
               type="text" 
               placeholder="nhap tu khoa">
        <button class="btn btn-success" type="submit">Search</button>
    </form>

</nav>

