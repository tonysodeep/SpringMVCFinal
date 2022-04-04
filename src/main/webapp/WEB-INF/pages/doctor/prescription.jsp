<%-- 
    Document   : prescriptipn
    Created on : Apr 2, 2022, 12:15:54 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info"> Pres DETAIL</h1>
<c:if test="${pres ==null}">
    <p><em>No items</em></p>
</c:if>

<c:if test="${pres !=null}">
    <table class="table">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th></th>
        </tr>
        <c:forEach items="${pres.values()}" var="p"> 
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price} VND</td>
                <td>
                    <input type="number"
                           class="form-control"
                           value="${p.quantity}"/>
                </td>
                <td>
                    <input type="button" value="Delete" class="btn btn-danger"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="Pay" class="btn btn-primary "/>
</c:if>