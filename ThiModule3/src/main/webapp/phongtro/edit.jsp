<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/10/22
  Time: 3:41 PM
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
    <form method="post" action="/phongtro?action=edit">

        <div class="mb-3">
            <%--@declare id="exampleinputemail1"--%><label for="exampleInputEmail1"  class="form-label" >ID  </label>
            <input name="id" value="${phongTro.id}" readonly type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">ID Rent </label>
            <input name="idRent" value="${phongTro.idRent}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input name="name" value="${phongTro.name}" type="text" class="form-control">

        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Phone</label>
            <input name="phone" value="${phongTro.phone}"  type="number" class="form-control">

        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Start Date</label>
            <input name="startDate" value="${phongTro.startDate}" type="date" class="form-control">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Payment ID</label>
            <select name="payment" >
                <c:forEach items="${thanhToanList}" var="pay">
                    <option value="${pay.id}">${pay.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Note</label>
            <input name="note" value="${phongTro.note}"  type="text" class="form-control">

        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>


