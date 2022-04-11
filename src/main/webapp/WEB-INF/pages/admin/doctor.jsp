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

<div class ="row">
    <c:forEach items="${doctors}" var="d">
        <div class="d-flex align-item-center justify-content-center w-100">
            <div class="card mb-3 w-75 border-danger rounded-3">
              <div class="row g-0">
                <div class="col-5 ml-3">
                  <img src="${d.image}" class="img-fluid w-100" alt="${d.id}">
                </div>
                <div class="col-6 p-2 m-2">
                  <div class="card-body">
                      <h4 class="card-title"><b>Họ Tên: </b> ${d.fullname}</h4>
                      <p class="card-text"><b>Email: </b> ${d.email}</p>
                      <p class="card-text"><b>Phone number: </b> ${d.mobile}</p>
                      <p class="card-text"><b>Address: </b> ${d.address}</p>
                      <a href="#" class="btn btn-warning">Update</a>
                      <a href="#" class="btn btn-danger">Delete</a>
                  </div>
                </div>
              </div>
            </div>
        </div>
    </c:forEach>
</div>