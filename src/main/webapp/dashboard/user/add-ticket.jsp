<%--
  Created by IntelliJ IDEA.
  User: Faezeh
  Date: 11/11/2020
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="rtl" lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.rtlcss.com/bootstrap/v4.2.1/css/bootstrap.min.css"
          integrity="sha384-vus3nQHTD+5mpDiZ4rkEPlnkcyTP+49BhJ4wJeJunw06ZAp+wzzeBPUXr42fi8If" crossorigin="anonymous">

    <title>Add Ticket</title>
</head>
<body class="container-fluid bg-light">
<%
    String parameter = request.getParameter("ticket-id");
    session.setAttribute("ticket-id", parameter);
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
<div class="row justify-content-center p-4">
    <div class="col-8">
        <h2>صادر کردن بلیت</h2>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-8 border p-4 m-4">

        <form action="/add-ticket" method="post">


            <div class="form-group">
                <label for="name">نام و نام خانوادگی :</label>
                <input class="form-control" type="text" name="name" id="name">
            </div>


            <div class="form-group p-2">
                <label>جنسیت :</label>
                <div class="custom-control custom-radio custom-control-inline">
                    <input class="custom-control-input" type="radio" name="gender" id="male" value="male">
                    <label class="custom-control-label" for="male">مرد</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <input class="custom-control-input" type="radio" name="gender" id="female" value="female">
                    <label class="custom-control-label" for="female">زن</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                    <input class="custom-control-input" type="radio" name="gender" id="other" value="other">
                    <label class="custom-control-label" for="other">دیگر</label>
                </div>
            </div>
            <input class="btn btn-dark" type="submit" value="صادر کردن بلیت">

        </form>
        <div id="not-add" class="alert alert-danger alert-dismissible fade show" role="alert" style="display: none">
            <strong>متاسفیم!</strong> متاسفانه مشکلی پیش آمد دوباره تلاش کنید !
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div id="add" class="alert alert-success alert-dismissible fade show" role="alert" style="display: none">
            <strong>ایول!</strong>بلیت شما به درستی به سیستم اضافه شد سفری خوبی را برای شما آرزومندیم
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
    if (searchIndex1 > -1) {
        document.getElementById('add').style.display = 'flex';
    } else if (searchIndex2 > -1) {
        document.getElementById('not-add').style.display = 'flex';
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
