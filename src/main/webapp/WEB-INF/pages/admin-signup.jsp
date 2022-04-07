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
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    </head>
    <body>
        <div class="container">
            <div class="bos shadow-dark">
                <h1>SIGN UP</h1>
                <div class="mb-3 padd-15">
                    <label for="inputFname" class="form-label">Fullname</label>
                    <input type="text" class="form-control" id="fullname" placeholder="Your Fullname" required>
                </div>
                <div class="mb-3 padd-15">
                    <label for="inputEmail" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" placeholder="Your Email" required>
                </div>
                <div class="mb-3 padd-15">
                    <label for="inputPhone" class="form-label">Phone</label>
                    <input type="tel" class="form-control" id="telephone" placeholder="Your Phone number" required>
                </div>
                <div class="mb-3 padd-15">
                    <label for="inputPassword" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Your Password" required>
                </div>
                <div class="mb-3 padd-15">
                  <label for="inputConfirmPass" class="form-label">Confirm Password</label>
                  <input type="password" class="form-control" id="confirmPass" placeholder="Confirm your Password" required>
                </div>
                <select class="form-select">
                    <option selected>Select role</option>
                    <option value="1">Admin</option>
                    <option value="2">Doctor</option>
                </select>
                <div class="mb-3 padd-15">
                    <label for="inputAddress" class="form-label">Address</label>
                    <textarea class="form-control" id="address" rows="3" placeholder="Your Address ..."></textarea>
                </div>
                <div class="mb-3 padd-15">
                  <label for="" class="form-label">Select image</label>
                  <input type="file" class="form-control" path="file" id="">
                </div>
                <div class="button padd-15">
                    <a role="button" name="Sign Up" href="" class="btn btn-primary">Sign Up</a>
                    <a role="button" name="Switch to Login" href="<c:url value="/login"/>" class="btn btn-danger">Switch to Log In</a>
                </div>
            </div>
        </div>
    </body>
</html>
