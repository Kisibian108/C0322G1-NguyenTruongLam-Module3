<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 6/26/22
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1 style="text-align: center">Customer Management</h1>
<h2 style="text-align: center">
    <a href="new"> Add New Customer </a>
    <a href="list"> List All Customer </a>
</h2>
<div style="text-align: center">
    <table border="1" cellpadding="5">
        <caption>
            <h2> List Of Customer</h2>
        </caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Phone</td>
            <td>Email</td>
            <td>Action</td>
        </tr>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td><c:out value="${customer.getId()}"></c:out></td>
                <td><c:out value="${customer.getName()}"></c:out></td>
                <td><c:out value="${customer.getPhone()}"></c:out></td>
                <td><c:out value="${customer.getEmail()}"></c:out></td>
<%--                <td><img src="<c:out value="${customer.getUrl()}"></c:out>" alt=""></td>--%>
                <td>
                    <a href="edit?id=<c:out value="${customer.getId()}"/> ">Edit</a>
                    <a href="delete?id=<c:out value="${customer.getId()}"/> ">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
