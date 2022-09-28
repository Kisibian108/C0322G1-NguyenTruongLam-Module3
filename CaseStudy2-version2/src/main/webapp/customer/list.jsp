<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/1/22
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<h1>Customer List</h1>

<a href="/customer?action=create" ><button class="button">Create new Customer</button></a>

<form action="/customer">
    <input type="text" name="nameSearch">
    <input type="text" name="phoneSearch">
    <input type="submit" name="action" value="search">
</form>
<p>${mess}</p>
<table class="table table-striped" id="tableCustomer" class="table table-striped table-bordered" >
    <thead>
    <tr>
        <th>ID</th>
        <th>IDType</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>IdCard</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
<%--    <c:forEach items="${classList}" var="cls">--%>
<%--        <c:if test="${cls.id==student.idClass}">--%>
<%--            <td>${cls.name}</td>--%>
<%--        </c:if>--%>
<%--    </c:forEach>--%>
    <tbody>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td> ${customer.id}</td>
                <c:forEach items="${customerTypeList}" var="type">
                <c:if test="${type.id == customer.typeId}">
            <td>${type.name}</td>
            </c:if>
            </c:forEach>
            <td> ${customer.name} </td>
            <td> ${customer.birthday} </td>
            <td>
                <c:if test="${customer.gender == 0}">
                    Male
                </c:if>
                <c:if test="${customer.gender == 1}">
                    Female
                </c:if>
            </td>
            <td> ${customer.idCard} </td>
            <td> ${customer.phoneNumber} </td>
            <td> ${customer.email} </td>
            <td> ${customer.address} </td>
                <%--            <c:if test="${customer.gender == 0}">--%>
                <%--                <td>Male</td>--%>
                <%--            </c:if>--%>
                <%--            <c:if test="${customer.gender == 1}">--%>
                <%--                <td>Female</td>--%>
                <%--            </c:if>--%>
            <td><a href="/customer?action=edit&id=${customer.id}" class="btn btn-primary">Edit</a></td>
            <!-- Button trigger modal -->
            <td>
            <button type="button" class="btn btn-primary" onclick="infoDelete('${customer.id}','${customer.name}')" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Delete
            </button>
            </td>
            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/customer" method="post">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="text" hidden name="idDelete" id="idDelete">
                            <input type="text" hidden name="action" value="delete">
                            <span>Bạn có muốn xóa khách hàng: </span>
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
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</html>
