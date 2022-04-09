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

<c:forEach items="${schedules}" var="s">
    <div class="d-flex align-item-center justify-content-center">
        <div class="card mb-3 w-75 shadow-dark">
            <div class="row g-0">
                <div class="col-5">
                    <label>Full name: </label></br>
                    <label>Phone number: </label></br>
                    <label>Booking date: </label></br>
                    <label>Doctor's name: </label></br>
                    <label>Status: </label>
                </div>
                <div class="col-7 padd-15">
                    <div class="card-body">
                        <h5 class="card-title">${s.clientFullname}</h5>
                        <p class="card-text"><b>${s.clientPhone}</b></p>
                        <p class="card-text"><b>${s.bookingDate}</b></p>
                        <p class="card-text"><b>${s.employeeId.fullname}</b></p>

                        <c:if test="${s.prescription!=null}">
                            <div class="alert alert-danger">
                                <p class="card-text"><b>Have Prescription</b></p>
                            </div>
                             <a href="<c:url value="/doctor/precription-detail/${s.prescription.id}"/>" class="btn btn-danger">Prescriptions Detail</a>
                        </c:if>
                        <c:if test="${s.prescription==null}">
                            <div class="alert alert-danger">
                                <p class="card-text"><b>Not have Prescription</b></p>
                            </div>
                            <a href="<c:url value="/doctor/add-precription/${s.id}"/>" class="btn btn-danger">create Prescriptions</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

