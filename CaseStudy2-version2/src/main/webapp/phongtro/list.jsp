<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/10/22
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Rent List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
  <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<h1>Rent List</h1>

<a href="/phongtro?action=create" ><button class="button">Create new Rent</button></a>

<form action="/phongtro">
  <input type="text" name="rentSearch">
  <input type="text" name="nameSearch">
  <input type="text" name="phoneSearch">
  <input type="submit" name="action" value="search">
</form>
<p>${mess}</p>
<%--<p>${mess}</p>--%>
<table class="table table-striped" id="tableRent" class="table table-striped table-bordered" >
  <thead>
<%--  private int id;--%>
<%--  private String idRent;--%>
<%--  private String name;--%>
<%--  private String phone;--%>
<%--  private String startDate;--%>
<%--  private String paymentId;--%>
<%--  private String note;--%>
  <tr>
    <th>ID</th>
    <th>ID Rent</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Start Date</th>
    <th>Payment Id</th>
    <th>Note</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${phongTroList}" var="rent">
    <tr>
      <td> ${rent.id}</td>
      <td> ${rent.idRent}</td>
      <td> ${rent.name} </td>
      <td> ${rent.phone} </td>
      <td> ${rent.startDate} </td>
      <c:forEach items="${thanhToanList}" var="pay">
        <c:if test="${pay.id == rent.paymentId}">
          <td>${pay.name}</td>
        </c:if>
      </c:forEach>
      <td> ${rent.note} </td>


      <td><a href="/phongtro?action=edit&id=${rent.id}" class="btn btn-primary">Edit</a></td>
      <!-- Button trigger modal -->

      <td>
        <button type="button" class="btn btn-primary" onclick="infoDelete('${rent.id}','${rent.idRent}')" data-bs-toggle="modal" data-bs-target="#exampleModal">
          Delete
        </button>
      </td>
      <!-- Modal -->
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <form action="/phongtro" method="post">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <input type="text" hidden name="idDelete" id="idDelete">
                <input type="text" hidden name="action" value="delete">
                <span>Bạn có muốn xóa phong tro: </span>
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
        function infoDelete(id, idRent) {
          document.getElementById("idDelete").value = id;
          document.getElementById("nameDelete").innerText = idRent;
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
    $('#tableRent').dataTable( {
      "dom": 'lrtip',
      "lengthChange": false,
      "pageLength": 5
    } );
  } );
</script>
</html>
