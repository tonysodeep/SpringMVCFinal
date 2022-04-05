<%-- 
    Document   : index
    Created on : Mar 31, 2022, 2:19:46 PM
    Author     : hyngu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/css/style.css"/>"/>
    </head>
    <body>
        <h1>Private Clinit managment system</h1>
        <a href="<c:url value="/login"/>" class="btn btn-danger">login</a>
        <a href="<c:url value="/admin-signup"/>" class="btn btn-danger">sign up</a>
    </body>
</html>
