<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/7/22
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danhsach List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<h1>Test List</h1>
<a href="/test?action=create" >Create new Test</a>

<form action="/test">
    <input type="text" name="nameSearch">
    <input type="submit" name="action" value="search">
</form>
<table class="table" id="table" class="table table-striped table-bordered" >
    <thead>
    <tr>
        <th>ID</th>
        <th>ID Benh An</th>
        <th>ID Benh Nhan</th>
        <th>Name</th>
        <th>Enter Date</th>
        <th>Outer Date</th>
        <th>Reason</th>
        <th>Edit</th>
        <th>Delete</th>
<%--        private int id;--%>
<%--        private int idBenhAn;--%>
<%--        private int idBenhNhan;--%>
<%--        private String name;--%>
<%--        private String enterDate;--%>
<%--        private String outDate;--%>
<%--        private String reason;--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSachBenhNhanList}" var="ds">
        <tr>
            <td> ${ds.id}</td>
            <c:forEach items="${benhAnList}" var="ba">
                <c:if test="${ba.id == ds.idBenhAn}">
                    <td>${ba.name}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${benhNhanList}" var="bn">
                <c:if test="${bn.id == ds.idBenhNhan}">
                    <td>${bn.name}</td>
                </c:if>
            </c:forEach>
            <td> ${ds.name} </td>
            <td> ${ds.enterDate} </td>
            <td> ${ds.outDate} </td>
            <td> ${ds.reason} </td>
            <td><a href="/test?action=edit&id=${ds.id}" class="btn btn-primary">Edit</a></td>
            <!-- Button trigger modal -->

            <td>
                <button type="button" class="btn btn-primary" onclick="infoDelete('${ds.id}','${ds.name}')" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/test" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <input type="text" hidden name="idDelete" id="idDelete">
                                <input type="text" hidden name="action" value="delete">
                                <span>Bạn có muốn xóa : </span>
                                <span id="nameDelete"></span>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Yes</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <script>
                function infoDelete(id, name) {
                    document.getElementById("idDelete").value = id;
                    document.getElementById("nameDelete").innerText = name;
                }
            </script>
                <%--            <td><a href="/customer?action=delete&id=${customer.id}" class="btn btn-primary">Delete</a></td>--%>
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
    $(document).ready(function() {
        $('#table').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</html>
