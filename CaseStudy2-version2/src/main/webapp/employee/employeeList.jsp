<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/5/22
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>EmployeeList</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Employee List</h1>
<a href="/employee?action=create" >Create new Employee</a>
<form action="/employee">
    <input type="text" name="nameSearch">
    <input type="submit" name="action" value="search">
</form>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Birthday</td>
        <td>IdCard</td>
        <td>Salary</td>
        <td>Phone Number</td>
        <td>Email</td>
        <td>Address</td>
        <td>Position Id</td>
        <td>EducationDegree ID</td>
        <td>Division ID</td>
        <td>Username</td>
    </tr>

    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.id} </td>
            <td>${employee.name} </td>
            <td>${employee.birthday} </td>
            <td>${employee.idCard} </td>
            <td>${employee.salary} </td>
            <td>${employee.phoneNumber} </td>
            <td>${employee.email} </td>
            <td>${employee.address} </td>
            <c:forEach items="${positionList}" var="pst">
                <c:if test="${employee.positionId == pst.id}">
                    <td>${pst.name} </td>
                </c:if>
            </c:forEach>
            <c:forEach items="${educationDegreeList}" var="degree">
                <c:if test="${employee.educationDegreeId == degree.id}">
                    <td>${degree.educationDegreeName} </td>
                </c:if>
            </c:forEach>
            <c:forEach items="${divisionList}" var="divi">
                <c:if test="${employee.divisionId == divi.id}">
                    <td>${divi.divisionName} </td>
                </c:if>
            </c:forEach>
            <c:forEach items="${userList}" var="user">
                <c:if test="${employee.username == user.username}">
                    <td>${user.username} </td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>

</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
