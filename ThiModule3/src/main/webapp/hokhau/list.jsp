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
    <title>Ho Khau List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<h1> List</h1>
<p>${mess}</p>
<table class="table table-striped" id="tableRent" class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma Ho Khau</th>
        <th>Ten Chu Ho</th>
        <th>So Luong</th>
        <th>Ngay Lap Ho Khau</th>
        <th>Dia chi nha</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hoKhauList}" var="hk">
        <tr>
            <td> ${hk.id}</td>
            <c:forEach items="${giaDinhList}" var="gd">
                <c:if test="${gd.id == hk.id}">
                    <td>${gd.hoKhau}</td>
                </c:if>
            </c:forEach>
            <td> ${hk.name} </td>
            <td> ${hk.number} </td>
            <td> ${hk.date} </td>
            <td> ${hk.address} </td>
            <td><a href="/hokhau?action=edit&id=${hk.id}" class="btn btn-primary">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableRent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</html>
