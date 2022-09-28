<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/9/22
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<h1>Product List</h1>

<a href="/product?action=create" ><button class="button">Create new Product</button></a>

<form action="/product">
    <input type="text" name="nameSearch">
    <input type="text" name="phoneSearch">
    <input type="submit" name="action" value="search">
</form>
<%--<p>${mess}</p>--%>
<table class="table table-striped" id="tableProduct" class="table table-striped table-bordered" >
    <thead>
<%--    private int id;--%>
<%--    private String name;--%>
<%--    private double price;--%>
<%--    private int quantity;--%>
<%--    private String color;--%>
<%--    private String description;--%>
<%--    private int categoryId;--%>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Description</th>
        <th>Category</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="pro">
        <tr>
            <td> ${pro.id}</td>
            <td> ${pro.name} </td>
            <td> ${pro.price} </td>
            <td> ${pro.quantity} </td>
            <td> ${pro.color} </td>
            <td> ${pro.description} </td>
            <c:forEach items="${categoryList}" var="cart">
                <c:if test="${cart.id == pro.categoryId}">
                    <td>${cart.name}</td>
                </c:if>
            </c:forEach>

            <td><a href="/product?action=edit&id=${pro.id}" class="btn btn-primary">Edit</a></td>
            <!-- Button trigger modal -->

            <td>
                <button type="button" class="btn btn-primary" onclick="infoDelete('${pro.id}','${pro.name}')" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/product" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <input type="text" hidden name="idDelete" id="idDelete">
                                <input type="text" hidden name="action" value="delete">
                                <span>Bạn có muốn xóa product: </span>
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
        $('#tableProduct').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</html>