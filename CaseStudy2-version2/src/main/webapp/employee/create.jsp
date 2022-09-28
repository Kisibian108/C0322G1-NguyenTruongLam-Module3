<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/6/22
  Time: 10:35 PM
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
    <form method="post" action="/employee?action=create">

        <div class="mb-3">
            <label  class="form-label">Name</label>
            <input name="name" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Birthday</label>
            <input name="birthday" type="date" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">IdCard</label>
            <input name="idCard" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Salary</label>
            <input name="salary" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Phone Number</label>
            <input name="phoneNumber" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Email</label>
            <input name="email" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Address</label>
            <input name="address" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Position</label>
            <select name="position">
                <c:forEach items="${positionList}" var="pst">
                    <option value="${pst.id}">${pst.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label  class="form-label">Education Degree</label>
            <select name="education">
                <c:forEach items="${educationDegreeList}" var="degree">
                    <option value="${degree.id}">${degree.educationDegreeName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label  class="form-label">Division</label>
            <select name="division">
                <c:forEach items="${divisionList}" var="divi">
                    <option value="${divi.id}">${divi.divisionName} </option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label  class="form-label">UserName</label>
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
