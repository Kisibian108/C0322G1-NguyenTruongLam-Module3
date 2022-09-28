<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/9/22
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%--private int id;--%>
<%--private String name;--%>
<%--private double price;--%>
<%--private int quantity;--%>
<%--private String color;--%>
<%--private String description;--%>
<%--private int categoryId;--%>
<div class="container">
    <form method="post" action="/product?action=edit">
        <div class="mb-3">
            <label class="form-label">ID</label>
            <input name="id" value="${product.id}" readonly type="text" class="form-control">
        </div>

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input name="name" value="${product.name}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Price</label>
            <input name="price" value="${product.price}" type="number" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label">Quantity</label>
            <input name="quantity" value="${product.quantity}" type="number" class="form-control">
        </div>

        <div class="mb-3">
            <label  class="form-label">Color</label>
            <input name="color" value="${product.color}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Description</label>
            <input name="description" value="${product.description}" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label  class="form-label"> Category</label>
            <select name="category">
                <c:forEach items="${categoryList}" var="cate">
                    <option value="${cate.id}">${cate.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
