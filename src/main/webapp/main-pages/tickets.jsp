<%@ page import="Service.TravelService" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="Service.Entities.Travel" %>
<%@ page import="java.util.List" %>
<%@ page import="Controller.WrapFarsi" %><%--
  Created by IntelliJ IDEA.
  User: Faezeh
  Date: 11/10/2020
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="rtl" lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.rtlcss.com/bootstrap/v4.2.1/css/bootstrap.min.css"
          integrity="sha384-vus3nQHTD+5mpDiZ4rkEPlnkcyTP+49BhJ4wJeJunw06ZAp+wzzeBPUXr42fi8If" crossorigin="anonymous">
    <title>Tickets</title>
</head>
<body class="container-fluid">
<%
    WrapFarsi wrapFarsi = new WrapFarsi();
    TravelService travelService = new TravelService();
    String beginning = wrapFarsi.getFarsiString(request, "beginning");
    String destination = wrapFarsi.getFarsiString(request, "destination");
    Date dateOfMovement = null;
    try {
        dateOfMovement = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfMovement"));
    } catch (ParseException e) {
        e.printStackTrace();
    }

    List<Travel> travels = travelService.findTravels(beginning, destination, dateOfMovement);
%>
<div class="row position-static">
    <div class="col-12" style="padding: 0">
        <nav class="navbar navbar-light bg-primary">
            <span class="navbar-brand h1 text-white">سیستم رزرو بلیت اتوبوس</span>
        </nav>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-12 p-4 m-4">
        <table class="table">
            <tr class="table-success" >
                <th> مسیر :  <%=beginning%> - <%=destination%></th>
                <th colspan="2">تاریخ حرکت : <%=dateOfMovement%></th>
            </tr>
            <tr class="table-primary">
                <td >انتخاب</td>
                <td >ساعت حرکت</td>
                <td >شناسه سفر</td>
            </tr>
            <%
                for(Travel t : travels){
            %>
            <tr>
                <td >
                    <form action="../dashboard/user/add-ticket.jsp" method="post">
                        <input type="hidden" name="ticket-id" value="<%=t.getId()%>">
                        <input class="btn btn-info" type="submit" value="انتخاب">
                    </form>
                </td>
                <td class="justify-content-center"><%=t.getTimeOfMovement()%></td>
                <td class="justify-content-center"><%=t.getTravelNumber()%></td>
            </tr>
            <%}%>
        </table>
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
