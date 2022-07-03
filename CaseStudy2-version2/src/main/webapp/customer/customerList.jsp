<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/1/22
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Customer List</h1>

<form action="/customer">
    <input type="text" name="nameSearch">
    <input type="submit" name="action" value="search">
</form>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>IdCard</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td> ${customer.id}</td>
            <td> ${customer.name} </td>
            <td> ${customer.birthday} </td>
            <td> ${customer.gender} </td>
            <td> ${customer.idCard} </td>
            <td> ${customer.phoneNumber} </td>
            <td> ${customer.email} </td>
            <td> ${customer.address} </td>
<%--            <c:if test="${customer.gender == 0}">--%>
<%--                <td>Male</td>--%>
<%--            </c:if>--%>
<%--            <c:if test="${customer.gender == 1}">--%>
<%--                <td>Female</td>--%>
<%--            </c:if>--%>
            <td><a href="/customer?action=edit&id=${customer.id}" class="btn btn-primary">Edit</a></td>
        </tr>
    </c:forEach>

</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
