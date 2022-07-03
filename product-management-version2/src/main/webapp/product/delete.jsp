<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 7/3/22
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["productList"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["productList"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${requestScope["productList"].getDescription()}</td>
            </tr>
            <tr>
                <td>Productor: </td>
                <td>${requestScope["productList"].getProductor()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/product">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
