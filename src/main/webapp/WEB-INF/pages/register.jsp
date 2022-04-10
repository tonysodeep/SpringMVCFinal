<%-- 
    Document   : signup
    Created on : Mar 31, 2022, 2:31:28 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    </head>
    <body>
        <div class="container">
            <div class="bos shadow-dark">

                <h1>SIGN UP</h1>
                <c:if test="${errMsg}!=null">
                    <div class="alert alert-danger">
                        ${errMsg}
                    </div>
                </c:if>
                <c:url value="/register" var="action"/>
                <form:form method="post" action="${action}" modelAttribute="employee" enctype="multipart/form-data">
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <div class="mb-3 padd-15 form-group">
                        <label for="inputFname" class="form-label">Fullname</label>
                        <form:input type="text" path="fullname" class="form-control"  placeholder="Your Fullname" />
                        <form:errors path="fullname" cssClass="text-danger"/>
                    </div>
                    <div class="mb-3 padd-15 form-group">
                        <label for="inputEmail" class="form-label">Email</label>
                        <form:input type="email" class="form-control" path="email" placeholder="Your Email" />
                        <form:errors path="email" cssClass="text-danger"/>
                    </div>
                    <div class="mb-3 padd-15 form-group">
                        <label for="inputPhone" class="form-label">Phone</label>
                        <form:input type="tel" class="form-control" path="mobile" placeholder="Your Phone number" />
                        <form:errors path="mobile" cssClass="text-danger"/>
                    </div>
                    <div class="mb-3 padd-15 form-group">
                        <label for="inputPassword" class="form-label">Password</label>
                        <form:password class="form-control" path="password" placeholder="Your Password" />
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>
                    <div class="mb-3 padd-15 form-group">
                        <label for="inputConfirmPass" class="form-label">Confirm Password</label>
                        <form:password class="form-control" path="confirmPassword" placeholder="Confirm your Password" />
                    </div>
                    <div class="mb-3 padd-15 form-group">
                        <label class="form-label">User Role</label>
                        <form:select path="role" class="form-control">
                            <option value="ADMIN">ADMIN</option>
                            <option value="DOCTOR">DOCTOR</option>
                        </form:select>
                    </div>
                    <div class="mb-3 padd-15 form-group">
                        <label for="inputAddress" class="form-label">Address</label>
                        <form:textarea class="form-control" path="address" placeholder="Your Address ..."/>
                    </div>
                    <div class="mb-3 padd-15 form-group">
                        <label class="form-label">Select image</label>
                        <form:input type="file" path="file" class="form-control"/>
                    </div>
                    <div class="button padd-15 form-group">
                        <input type="submit" value="Register" class="button"/>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
