<%-- 
    Document   : cates-stats
    Created on : Apr 9, 2022, 10:59:46 PM
    Author     : hyngu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">CATEGORY STATS</h1>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Number of medicines</th>
    </tr>
    <c:foreach item="${stats}" var="s">
        <tr>
            <td>${s[0]}</td>
            <td>${s[1]}</td>
            <td>${s[2]}</td>
        </tr>
    </c:foreach>

</table>
