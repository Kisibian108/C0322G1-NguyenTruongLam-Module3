<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/8/22
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%--private int id;--%>
<%--private String name;--%>
<%--private String birthday;--%>
<%--private String idCard;--%>
<%--private double salary;--%>
<%--private String phoneNumber;--%>
<%--private String email;--%>
<%--private String address;--%>
<%--private int positionId;--%>
<%--private int educationDegreeId;--%>
<%--private int divisionId;--%>
<%--private String username;--%>
<div class="container">
    <form method="post" action="/employee?action=edit">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Id</label>
            <input name="id" value="${employee.id}" readonly type="number" class="form-control" id="exampleInputEmail1">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input name="name" value="${employee.name}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Birthday</label>
            <input name="birthday" value="${employee.birthday}" type="date" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">IdCard</label>
            <input name="idCard" value="${employee.idCard}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Salary</label>
            <input name="salary" value="${employee.salary}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Phone Number</label>
            <input name="phoneNumber"  value="${employee.phoneNumber}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email</label>
            <input name="email" value="${employee.email}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Address</label>
            <input name="address" value="${employee.address}"  type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Position</label>
            <select name="position">
                <c:forEach items="${positionList}" var="pst">
                    <option selected value="${pst.id}">${pst.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Education Degree</label>
            <select name="education">
                <c:forEach items="${educationDegreeList}" var="degree">
                    <option value="${degree.id}">${degree.educationDegreeName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Division</label>
            <select name="division">
                <c:forEach items="${divisionList}" var="divi">
                    <option value="${divi.id}">${divi.divisionName} </option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">UserName</label>
            <select name="username">
                <c:forEach items="${userList}" var="user">
                    <option value="${user.username}">${user.password} </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>