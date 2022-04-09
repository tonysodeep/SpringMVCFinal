<%-- Document : index Created on : Apr 2, 2022, 11:18:20 AM Author : hyngu --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">Schedule List </h1>

<c:forEach items="${schedules}" var="s">
    <div class="d-flex align-item-center justify-content-center">
        <div class="card mb-3 w-75 shadow-dark">
            <div class="row g-0">
                <div class="col-5 p-2 ml-3">
                    <p><br><b>Full name: </b></p>
                    <p><b>Phone number: </b></p>
                    <p><b>Booking date: </b></p>
                    <p><b>Doctor's name: </b></p>
                    <p><b>Status: </b></p>
                </div>
                <div class="col-6 p-2">
                    <p><br>${s.clientFullname}
                    <p>
                    <p>${s.clientPhone}</p>
                    <p>${s.bookingDate}</p>
                    <p>${s.employeeId.fullname}</p>
                    <c:if test="${s.prescription!=null}">
                        <div class="alert alert-danger">
                            <p class="card-text"><b>Have Prescription</b></p>
                        </div>
                        <a href="<c:url value=" /doctor/precription-detail/${s.prescription.id}" />"
                           class="btn btn-danger">Prescriptions Detail</a>
                    </c:if>
                    <c:if test="${s.prescription==null}">
                        <div class="alert alert-danger">
                            <p class="card-text"><b>Not have Prescription</b></p>
                        </div>
                        <a href="<c:url value=" /doctor/add-precription/${s.id}" />" class="btn
                           btn-danger mr-3">Create prescription</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</c:forEach>