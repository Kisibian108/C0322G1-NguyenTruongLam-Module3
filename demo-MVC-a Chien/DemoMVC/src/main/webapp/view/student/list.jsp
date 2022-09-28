<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 7/1/2022
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang Student list</h1>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>classId</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <c:forEach items="${classList}" var="cls">
               <c:if test="${cls.id==student.idClass}">
                   <td>${cls.name}</td>
               </c:if>
            </c:forEach>
            <td>
                Delete
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
