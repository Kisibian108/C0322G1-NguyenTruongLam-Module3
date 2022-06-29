<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 6/28/22
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Management</title>
</head>
<body>
<h1>Customer List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Adress</th>
        <th>Img</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td> ${customer.id}</td>
            <td> ${customer.name} </td>
            <td> ${customer.birthday} </td>
            <td> ${customer.address} </td>
            <td><img src="${customer.img}" alt=""></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
