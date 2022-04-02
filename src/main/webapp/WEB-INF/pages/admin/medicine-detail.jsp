<%-- 
    Document   : medicine-detail
    Created on : Apr 1, 2022, 9:54:04 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">Medicine detail</h1>

<div class="row">
    <div class ="col-md-5 col-sm-12">
        <img src="${medicine.image}" 
             class="img-fluid"
             alt="${medicine.name}"/>
    </div>
    <div class="col-md-7 col-sm-12">
        <h1>${medicine.name}</h1>
        <p>${medicine.description}</p>
        <h4>${medicine.price} VND</h4>
    </div>
</div>
