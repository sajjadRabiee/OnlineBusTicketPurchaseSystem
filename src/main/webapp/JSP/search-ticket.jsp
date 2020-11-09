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
    <title>Search Ticket</title>
</head>
<body>
<%
    CityService cityService = new CityService();
    List<City> all = cityService.findAll();
%>
<form action="">
    <label for="beginning">مبدا</label>
    <select id="beginning" name="beginning">
        <option value="" disabled selected>لطفا مبدا سرویس را وارد نمائید ...</option>
        <%for(City c : all){%>
        <option value="<%=c.getName()%>"><%=c.getName()%></option>
        <%}%>
    </select>
    <label for="destination">مقصد</label>
    <select id="destination" name="destination">
        <option value="" disabled selected>لطفا مقصد سرویس را وارد نمائید ...</option>
        <%for(City c : all){%>
        <option value="<%=c.getName()%>"><%=c.getName()%></option>
        <%}%>
    </select>
    <label for="timeOfMovement">تاریخ</label>
    <input type="date" name="timeOfMovement" id="timeOfMovement">
    <input type="submit" value="جستجوی آنلاین">
</form>
</body>
</html>
