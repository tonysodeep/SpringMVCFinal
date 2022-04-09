<%-- 
    Document   : medicine-detail
    Created on : Apr 1, 2022, 9:54:04 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info mb-3">Medicine detail</h1>

<div class="row">
    <div class ="col-md-5 col-sm-12">
        <img src="${medicine.image}" 
             class="img-fluid"
             alt="${medicine.name}"/>
    </div>
    <div class="col-md-7 col-sm-12">
        <h1>${medicine.name}</h1>
        <h4>${medicine.price} VND</h4>
        <h6>Description: ${medicine.description}</h6>        
        <h6>Quanity: ${medicine.quanity}</h6>
    </div>
</div>
