<%-- 
    Document   : admin
    Created on : Mar 28, 2022, 7:21:23 PM
    Author     : hyngu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info" >Dashboard  </h1>
<div class="row">
    <div class="col">
        <a href="<c:url value="/admin/cates-stats"/>">
            <input type="submit" value="CATEGORY STATS" class="button w-100 p-5 btn-warning"/>
        </a>
    </div>
    <div class="col">
        <a href="<c:url value="/admin/revenue-stats"/>">
            <input type="submit" value="PRODUCT STATS" class="button w-100 p-5 btn-primary"/>
        </a>
    </div>
</div>

