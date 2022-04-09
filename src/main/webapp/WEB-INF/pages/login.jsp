<%-- 
    Document   : login
    Created on : Mar 28, 2022, 7:13:56 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    </head>
    <body>
        <div class="container">
            <div class="box shadow-dark">
                <h1>LOG IN</h1>
                <c:url value="/login" var="action"/>
                <form method="post" action="${action}">
                    <div class="mb-3 padd-15 form-group">
                        <label for="inputEmail" class="form-label">Email address</label>
                        <input type="email" class="form-control" name="email" placeholder="Enter your Email" required>
                    </div>
                    <div class="mb-3 padd-15 form-group">
                        <label for="inputPassword" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" placeholder="Enter your Password" required>
                    </div> 
                    <div class="button padd-15">
                        <input type="submit" value="Login" class="btn padd-15 btn-danger"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
