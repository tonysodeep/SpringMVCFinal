<%-- 
    Document   : add-pres
    Created on : Apr 3, 2022, 3:20:11 PM
    Author     : hyngu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info" >Medicine List </h1>

<div class="row">
    <div class="col-3">
        <ul class="pagination nav nav-pills">
            <c:forEach begin="1" end="${Math.ceil(medicineCounter/6)}" var="i">
                <c:url value="/admin/medicine" var="myAction">
                    <c:param name="page" value="${i}" />
                </c:url>
                <li class="page-item"><a class="page-link" href="${myAction}">${i}</a></li>
                </c:forEach>
        </ul>
    </div>
    <div class="col d-flex flex-row-reverse" >
        <ul class="nav nav-pills">
            <c:forEach items="${categories}" var="c">
                <li class="nav-item">
                    <a class="nav-link" href="#">${c.name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>



<div class ="row">
    <c:forEach items="${medicines}" var="m">
        <div class="col-md-4 col-sm-12" style="padding: 10px">
            <div class="card">
                <img class="card-img-top" src="${m.image}" alt="${m.name}">
                <div class="card-body">
                    <h4 class="card-title">${m.name}</h4>
                    <p class="card-text">${m.price} VND</p>
                    <a href="<c:url value="/admin/medicine/${m.id}"/>" class="btn btn-primary">See Detail</a>
                    <a href="#" 
                       onclick="addToPres(${m.id}, '${m.name}',${m.price})"
                       class="btn btn-danger">add to Prescriptions</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
