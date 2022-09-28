<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/10/22
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%--  private int id;--%>
<%--  private String idRent;--%>
<%--  private String name;--%>
<%--  private String phone;--%>
<%--  private String startDate;--%>
<%--  private String paymentId;--%>
<%--  private String note;--%>
<div class="container">
    <form method="post" action="/phongtro?action=create">
        <div><p>${mess}</p> </div>
        <div class="mb-3">
            <label class="form-label">ID Rent </label>
            <input name="idRent" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input name="name" type="text" class="form-control">
            <p>${mapValidate.get("name")}</p>
        </div>
        <div class="mb-3">
            <label  class="form-label">Phone</label>
            <input name="phone" type="number" class="form-control">
            <p>${mapValidate.get("phone")}</p>
        </div>
        <div class="mb-3">
            <label  class="form-label">Start Date</label>
            <input name="startDate" type="date" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Payment ID</label>
            <select name="payment">
                <c:forEach items="${thanhToanList}" var="pay">
                    <option value="${pay.id}">${pay.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Note</label>
            <input name="note" type="text" class="form-control">
            <p>${mapValidate.get("note")}</p>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

