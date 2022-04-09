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
                <div class="col-5 p-15">
                    <label><b>Full name: </b></label></br>
                    <label><b>Phone number: </b></label></br>
                    <label><b>Booking date: </b></label></br>
                    <label><b>Doctor's name: </b></label></br>
                    <label><b>Status: </b></label>
                </div>
                <div class="col-7 p-15">
                    <div class="card-body">
                        <p class="card-title">${s.clientFullname}<p>
                        <p class="card-text">${s.clientPhone}</p>
                        <p class="card-text">${s.bookingDate}</p>
                        <p class="card-text">${s.employeeId.fullname}</p>

                        <c:if test="${s.prescription!=null}">
                            <div class="alert alert-danger">
                                <p class="card-text"><b>Have Prescription</b></p>
                            </div>
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

