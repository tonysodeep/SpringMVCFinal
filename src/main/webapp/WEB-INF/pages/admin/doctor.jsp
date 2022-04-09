<%-- 
    Document   : doctor
    Created on : Apr 1, 2022, 5:19:44 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center">Doctor page</h1>
<div class="row">
    <div class="col-4">
        <ul class="pagination nav nav-pills">
            <c:forEach begin="1" end="${Math.ceil(medicineCounter/6)}" var="i">
                <c:url value="/admin/doctor" var="myAction">
                    <c:param name="page" value="${i}" />
                </c:url>
                <li class="page-item"><a class="page-link" href="${myAction}">${i}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col d-flex flex-row-reverse" >
        <ul class="nav nav-pills">
            <c:forEach items="${roles}" var="c">
                <li class="nav-item">
                    <c:url value="/admin/doctor" var="cateFilter">
                        <c:if test="${role == DOCTOR}">
                            <c:param name="id" value="${c.id}"/>
                        </c:if>
                    </c:url>
                    <a class="nav-link" href="${cateFilter}">${c.role}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class ="row">
    <c:forEach items="${doctors}" var="m">
        <div class="d-flex align-item-center justify-content-center">
            <div class="card mb-3">
              <div class="row g-0">
                <div class="col-5">
                  <img src="${m.image}" class="img-fluid" alt="${m.id}">
                </div>
                <div class="col-7 p-15">
                  <div class="card-body">
                      <h4 class="card-title"><b>Họ Tên: </b> ${m.fullname}</h4>
                      <p class="card-text"><b>Email: </b> ${m.email}</p>
                      <p class="card-text"><b>Phone number: </b> ${m.mobile}</p>
                      <p class="card-text"><b>Address: </b> ${m.address}</p>
                      <p class="card-text"><b>Password: </b> ${m.password}</p>
                      <a href="<c:url value="/admin/medicine/${m.id}"/>" class="btn btn-primary">See Detail</a>
                      <a href="#" class="btn btn-warning">Update</a>
                      <a href="#" class="btn btn-danger">Delete</a>
                  </div>
                </div>
              </div>
            </div>
        </div>
    </c:forEach>
</div>