<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/5/22
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>EmployeeList</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<h1>Employee List</h1>
<a href="/employee?action=create" >Create new Employee</a>
<form action="/employee">
    <input type="text" name="nameSearch">
    <input type="submit" name="action" value="search">
</form>
<table border="1" class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Birthday</td>
        <td>IdCard</td>
        <td>Salary</td>
        <td>Phone Number</td>
        <td>Email</td>
        <td>Address</td>
        <td>Position Id</td>
        <td>EducationDegree ID</td>
        <td>Division ID</td>
        <td>Username</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.id} </td>
            <td>${employee.name} </td>
            <td>${employee.birthday} </td>
            <td>${employee.idCard} </td>
            <td>${employee.salary} </td>
            <td>${employee.phoneNumber} </td>
            <td>${employee.email} </td>
            <td>${employee.address} </td>
            <c:forEach items="${positionList}" var="pst">
                <c:if test="${employee.positionId == pst.id}">
                    <td>${pst.name} </td>
                </c:if>
            </c:forEach>
            <c:forEach items="${educationDegreeList}" var="degree">
                <c:if test="${employee.educationDegreeId == degree.id}">
                    <td>${degree.educationDegreeName} </td>
                </c:if>
            </c:forEach>
            <c:forEach items="${divisionList}" var="divi">
                <c:if test="${employee.divisionId == divi.id}">
                    <td>${divi.divisionName} </td>
                </c:if>
            </c:forEach>
            <c:forEach items="${userList}" var="user">
                <c:if test="${employee.username == user.username}">
                    <td>${user.username} </td>
                </c:if>
            </c:forEach>
            <td>
                <a href="/employee?action=edit&id=${employee.id}" class="btn btn-primary">Edit</a>
            </td>
        <td>
            <button type="button" class="btn btn-primary"  onclick="infoDelete('${employee.id}','${employee.name}')" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Delete
            </button>
        </td>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <form action="/employee" method="post">
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
</html>
