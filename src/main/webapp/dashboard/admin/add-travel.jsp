<%@ page import="Service.CityService" %>
<%@ page import="Service.Entities.City" %>
<%@ page import="java.util.List" %>
<%@ page import="Service.BusService" %>
<%@ page import="Service.Entities.Bus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="rtl" lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Ticket</title>
</head>
<body>
<%
    CityService cityService = new CityService();
    List<City> allCities = cityService.findAll();
    BusService busService = new BusService();
    List<Bus> allBuses = busService.findAll();
%>
<form action="/add-travel">
    <label for="beginning">مبدا</label>
    <select id="beginning" name="beginning">
        <option value="" disabled selected>لطفا مبدا سرویس را وارد نمائید ...</option>
        <%for(City c : allCities){%>
        <option value="<%=c.getName()%>"><%=c.getName()%></option>
        <%}%>
    </select>
    <label for="destination">مقصد</label>
    <select id="destination" name="destination">
        <option value="" disabled selected>لطفا مقصد سرویس را وارد نمائید ...</option>
        <%for(City c : allCities){%>
        <option value="<%=c.getName()%>"><%=c.getName()%></option>
        <%}%>
    </select>
    <label for="buses">اتوبوس ها</label>
    <select id="buses" name="buses" multiple="multiple">
        <%for(Bus c : allBuses){%>
        <option value="<%=c.getId()%>"><%=c.getBusNumber()%></option>
        <%}%>
    </select>
    <label for="timeOfMovement">تاریخ</label>
    <input type="date" name="timeOfMovement" id="timeOfMovement">
    <input type="submit" value="افزودن سفر">
    <p id="add" style="text-align: center; margin-bottom: 0; margin-top: 10px; padding: 10px; border-style: dashed; border-color:red; display:none">سفر جدیدی به سیستم اضافه شد</p>
    <p id="not-add" style="text-align: center; margin-bottom: 0; margin-top: 10px; padding: 10px; border-style: dashed; border-color:red; display:none">متاسفانه مشکلی پیش آمد دوباره تلاش کنید !</p>
    <script>
        var searchIndex1 = window.location.href.indexOf("true");
        var searchIndex2 = window.location.href.indexOf("false");
        if(searchIndex1 > -1){
            document.getElementById('add').style.display='block';
        }else if(searchIndex2 > -1){
            document.getElementById('not-add').style.display='block';
        }
    </script>
</form>
</body>
</html>
