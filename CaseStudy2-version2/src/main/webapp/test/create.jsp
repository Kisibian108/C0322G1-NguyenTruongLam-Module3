<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/7/22
  Time: 10:53 AM
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
<%--private int id;--%>
<%--private int idBenhAn;--%>
<%--private int idBenhNhan;--%>
<%--private String name;--%>
<%--private String enterDate;--%>
<%--private String outDate;--%>
<%--private String reason;--%>
<div class="container">
    <form method="post" action="/test?action=create">
<%--        <div class="mb-3">--%>
<%--            <label for="exampleInputEmail1" class="form-label">Id</label>--%>
<%--            <input name="id" type="number" class="form-control" id="exampleInputEmail1">--%>
<%--        </div>--%>
        <div class="mb-3">
            <label  class="form-label"> Benh An</label>
            <select name="benhan">
                <c:forEach items="${benhAnList}" var="ba">
                    <option value="${ba.id}">${ba.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label  class="form-label"> Benh Nhan</label>
            <select name="benhnhan">
                <c:forEach items="${benhNhanList}" var="bn">
                    <option value="${bn.id}">${bn.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Name</label>
            <input name="name" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Enter Date</label>
            <input name="enter" type="date" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Outer Date</label>
            <input name="outer" type="date" class="form-control">
        </div>

        <div class="mb-3">
            <label  class="form-label">Reason</label>
            <input name="reason" type="text" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
