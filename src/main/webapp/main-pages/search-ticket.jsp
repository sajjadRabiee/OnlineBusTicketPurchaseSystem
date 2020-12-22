<%@ page import="Service.CityService" %>
<%@ page import="Service.Entities.City" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Faezeh
  Date: 11/9/2020
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="rtl" lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.rtlcss.com/bootstrap/v4.2.1/css/bootstrap.min.css"
          integrity="sha384-vus3nQHTD+5mpDiZ4rkEPlnkcyTP+49BhJ4wJeJunw06ZAp+wzzeBPUXr42fi8If" crossorigin="anonymous">
    <title>Search Ticket</title>
</head>
<body class="container-fluid bg-light">
<%
    CityService cityService = new CityService();
    List<City> all = cityService.findAll();
%>
<div class="row position-static">
    <div class="col-12" style="padding: 0">
        <nav class="navbar navbar-light bg-primary">
            <span class="navbar-brand h1 text-white">سیستم رزرو بلیت اتوبوس</span>
        </nav>
    </div>
</div>
<div class="row justify-content-center p-4">
    <div class="col-8">
        <h2>جستجوی بلیت</h2>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-8 border border-primary p-4 m-4">
        <form action="tickets.jsp" method="post">
            <div class="form-group">
            <label for="beginning">مبدا</label>
            <select class="form-control" id="beginning" name="beginning">
                <option value="" disabled selected>لطفا مبدا سرویس را وارد نمائید ...</option>
                <%for(City c : all){%>
                <option value="<%=c.getName()%>"><%=c.getName()%></option>
                <%}%>
            </select>
            </div>
            <div class="form-group">
            <label for="destination">مقصد</label>
            <select class="form-control" id="destination" name="destination">
                <option value="" disabled selected>لطفا مقصد سرویس را وارد نمائید ...</option>
                <%for(City c : all){%>
                <option value="<%=c.getName()%>"><%=c.getName()%></option>
                <%}%>
            </select>
            </div>
            <div class="form-group">
            <label for="dateOfMovement">تاریخ</label>
            <input class="form-control" type="date" name="dateOfMovement" id="dateOfMovement">
            </div>
            <input class="btn btn-primary" type="submit" value="جستجوی آنلاین">
        </form>
    </div>
</div>
<div class="row bg-secondary justify-content-between align-items-center" style="height: 65px">
    <div class="col-4 text-center">this is a fullstack project</div>
    <div class="col-4 text-center" data-toggle="tooltip" data-placement="bottom" title="Tooltip on bottom">design and coding by : sajjad rabiee
        <br>
        rabiee.614@gmail.com
    </div>
    <div class="col-4 text-center">nov 2020</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://cdn.rtlcss.com/bootstrap/v4.2.1/js/bootstrap.min.js"
        integrity="sha384-a9xOd0rz8w0J8zqj1qJic7GPFfyMfoiuDjC9rqXlVOcGO/dmRqzMn34gZYDTel8k"
        crossorigin="anonymous"></script>
</body>
</html>
