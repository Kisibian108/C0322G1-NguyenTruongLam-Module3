<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/10/22
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <form method="post" action="/hokhau?action=edit">
        <div class="mb-3">
            <%--@declare id="exampleinputemail1"--%><label for="exampleInputEmail1" class="form-label">ID </label>
            <input name="id" value="${hoKhau.id}" readonly type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">ID Ho Khau</label>
            <input name="idHk" value="${hoKhau.idHoKhau}" readonly type="text" class="form-control">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Name</label>
                <input name="name" value="${hoKhau.name}" type="text" class="form-control">

            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Number</label>
                <input name="number" value="${hoKhau.number}" required type="number" class="form-control">

            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label"> Date</label>
                <input name="date" value="${hoKhau.date}" type="date" class="form-control">
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Address</label>
                <input name="address" value="${hoKhau.address}" type="text" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
