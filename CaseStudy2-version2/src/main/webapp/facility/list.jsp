<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/6/22
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Facility List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Facility List</h1>
<a href="/facility?action=create" >Create new Facility</a>

<form action="/facility">
    <input type="text" name="nameSearch">
    <input type="submit" name="action" value="search">
</form>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Area</th>
        <th>Cost</th>
        <th>MaxPeople</th>
        <th>Rent Type</th>
        <th>Facility Type</th>
        <th>Standard Room</th>
        <th>Convenience</th>
        <th>Pool Area</th>
        <th>Floor</th>
        <th>Facility Free</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
<%--    private int id;--%>
<%--    private String name;--%>
<%--    private int area;--%>
<%--    private double cost;--%>
<%--    private int maxPeople;--%>
<%--    private int rentTypeId;--%>
<%--    private int facilityTypeId;--%>
<%--    private String standardRoom;--%>
<%--    private String convenience;--%>
<%--    private double poolArea;--%>
<%--    private int floor;--%>
<%--    private String facilityFree;--%>
    <c:forEach items="${facilityList}" var="facility">
        <tr>
            <td> ${facility.id}</td>
            <td> ${facility.name}</td>
            <td> ${facility.area}</td>
            <td> ${facility.cost}</td>
            <td> ${facility.maxPeople}</td>
            <c:forEach items="${rentTypeList}" var="rent">
                <c:if test="${facility.rentTypeId == rent.id}">
                    <td>${rent.name}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${facilityTypeList}" var="fcl">
                <c:if test="${facility.facilityTypeId == fcl.id}">
                    <td>${fcl.name}</td>
                </c:if>
            </c:forEach>
            <td> ${facility.standardRoom}</td>
            <td> ${facility.convenience}</td>
            <td> ${facility.poolArea}</td>
            <td> ${facility.floor}</td>
            <td> ${facility.facilityFree}</td>

            <td>
                <a href="/facility?action=edit&id=${facility.id}" class="btn btn-primary">Edit</a>
            </td>
            <!-- Button trigger modal -->

            <td>
                <button type="button" class="btn btn-primary"  onclick="infoDelete('${facility.id}','${facility.name}')" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/facility" method="post">
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

</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
