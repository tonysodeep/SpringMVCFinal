<%-- 
    Document   : cates-stats
    Created on : Apr 9, 2022, 10:59:46 PM
    Author     : hyngu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">CATEGORY STATS</h1>

<div class="row">
    <div class="col-md-5">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Number of medicines</th>
            </tr>
            <c:forEach items="${stats}" var="s">
                <tr>
                    <td>${s[0]}</td>
                    <td>${s[1]}</td>
                    <td>${s[2]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-7">
        <canvas id="myChart"></canvas>
    </div>
</div>

<script>
    let labels = [], data = []
    <c:forEach items="${stats}" var="s">
        labels.push('${s[1]}')
        data.push(${s[0]})
    </c:forEach>
    window.onload = () => {
        let ctx = document.getElementById("myChart").getContext("2d")
        drawPieChart(ctx, labels, data)
    };
</script>
