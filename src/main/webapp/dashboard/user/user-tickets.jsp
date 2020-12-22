<%@ page import="Service.TicketService" %>
<%@ page import="Service.Entities.User" %>
<%@ page import="Service.Entities.Ticket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Faezeh
  Date: 11/11/2020
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="rtl" lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.rtlcss.com/bootstrap/v4.2.1/css/bootstrap.min.css"
          integrity="sha384-vus3nQHTD+5mpDiZ4rkEPlnkcyTP+49BhJ4wJeJunw06ZAp+wzzeBPUXr42fi8If" crossorigin="anonymous">
    <title>User Tickets</title>
</head>
<body class="container-fluid bg-light">
<%
    User online_user = (User) session.getAttribute("online_user");
    TicketService ticketService = new TicketService();
    List<Ticket> ticketsOfUser = ticketService.findTicketsOfUser(online_user);
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
    <div class="col-12 p-4 m-4">
        <table class="table">
            <thead>
            <td colspan="3">لیست بلیت های خریداری شده</td>
            </thead>
            <tr class="table-primary">
                <td>انتخاب</td>
                <td>شناسه بلیط</td>
                <td>تاریخ</td>
            </tr>
            <%for(Ticket t : ticketsOfUser){%>
            <tr>
                <td>
                    <form action="show-ticket-information.jsp" method="post">
                        <input type="hidden" name="ticket-id" value="<%=t.getId()%>">
                        <input class="btn btn-primary" type="submit" value="مشاهده بلیط">
                    </form>
                </td>
                <td><%=t.getTicketNumber()%></td>
                <td><%=t.getTravel().getDateOfMovement()%></td>

            </tr>
            <%}%>
        </table>
        <div id="not-add" class="alert alert-danger alert-dismissible fade show" role="alert" style="display: none">
            <strong>متاسفیم!</strong>  مشکلی پیش آمد دوباره تلاش کنید !
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div id="add" class="alert alert-success alert-dismissible fade show" role="alert" style="display: none">
            <strong>ایول!</strong>به درستی بلیت مورد نظر حذف شد
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
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
<script>
    var searchIndex1 = window.location.href.indexOf("true");
    var searchIndex2 = window.location.href.indexOf("false");
    if(searchIndex1 > -1){
        document.getElementById('add').style.display='block';
    }else if(searchIndex2 > -1){
        document.getElementById('not-add').style.display='block';
    }
</script>
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
