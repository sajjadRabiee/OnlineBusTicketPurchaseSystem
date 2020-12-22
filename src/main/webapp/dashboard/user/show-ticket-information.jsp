<%@ page import="Service.TicketService" %>
<%@ page import="Service.Entities.Ticket" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: Faezeh
  Date: 11/15/2020
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="rtl" lang="fa">
<head>
    <link rel="stylesheet" href="https://cdn.rtlcss.com/bootstrap/v4.2.1/css/bootstrap.min.css"
          integrity="sha384-vus3nQHTD+5mpDiZ4rkEPlnkcyTP+49BhJ4wJeJunw06ZAp+wzzeBPUXr42fi8If" crossorigin="anonymous">
    <title>Show Ticket Information</title>
</head>
<body class="container-fluid bg-light">
<%
    TicketService ticketService = new TicketService();
    long ticketId = Long.parseLong(request.getParameter("ticket-id"));
    Optional<Ticket> byId = ticketService.findById(ticketId);
    Ticket ticket = byId.get();
%>
<div class="row position-static">
    <div class="col-12" style="padding: 0">
        <nav class="navbar navbar-expand-lg navbar-light bg-primary">
            <a class="navbar-brand h1 text-white" href="../../main-pages/index.html">سیستم رزرو بلیت اتوبوس</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link text-white" href="user-page.html">منوی کاربری</a>

                    <a class="nav-item nav-link text-white" href="user-tickets.jsp">مشاهده بلیط های من</a>
                    <a class="nav-item nav-link text-white" href="../../main-pages/search-ticket.jsp">رزرو بلیت</a>
                </div>
            </div>
            <form class="form-inline" action="/logout" method="get">
                <input class="btn btn-outline-warning my-2 my-sm-0" type="submit" value="خارج شدن">
            </form>
        </nav>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-12 p-4 d-4">
        <table class="table table-striped">
            <tr>
                <td colspan="2">اطلاعات بلیت</td>
            </tr>
            <tr>
                <td>
                    شناسه بلیط
                </td>
                <td><%=ticket.getTicketNumber()%>
                </td>
            </tr>
            <tr>
                <td>
                    نام
                </td>
                <td><%=ticket.getName()%>
                </td>
            </tr>
            <tr>
                <td>
                    جنسیت
                </td>
                <td><%=ticket.getGender()%>
                </td>
            </tr>
            <tr>
                <td>
                    مبدا
                </td>
                <td><%=ticket.getTravel().getBeginning()%>
                </td>
            </tr>
            <tr>
                <td>
                    مقصد
                </td>
                <td><%=ticket.getTravel().getDestination()%>
                </td>
            </tr>
            <tr>
                <td>
                    تاریخ حرکت
                </td>
                <td><%=ticket.getTravel().getDateOfMovement()%>
                </td>
            </tr>
            <tr>
                <td>
                    ساعت حرکت
                </td>
                <td><%=ticket.getTravel().getTimeOfMovement()%>
                </td>
            </tr>
            <tr>
                <td>
                    شناسه سفر
                </td>
                <td><%=ticket.getTravel().getTravelNumber()%>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <form action="/delete-ticket" method="post">
                        <input type="hidden" name="ticket-id" value="<%=ticket.getId()%>">
                        <input class="btn btn-outline-danger" type="submit" value="لغو بلیط">
                    </form>
                </td>
            </tr>
        </table>
    </div>
</div>

<div class="row bg-secondary justify-content-between align-items-center" style="height: 65px">
    <div class="col-4 text-center">this is a fullstack project</div>
    <div class="col-4 text-center" data-toggle="tooltip" data-placement="bottom" title="Tooltip on bottom">design
        and coding by : sajjad rabiee
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
