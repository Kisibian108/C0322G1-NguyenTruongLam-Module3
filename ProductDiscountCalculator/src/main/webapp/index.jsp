<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 6/26/22
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Product Discount Calculator </h1>
  <form action="/CalculateDiscount" method="post">
    <label> Mo ta san pham</label> <input type="text" placeholder="Mo ta san pham" name="description" ><br>
    <label> Gia niem yet</label><input type="number" placeholder="Gia niem yet" name="price" ><br>
    <label> Ti le chiet khau <input type="number" placeholder="ty le chiet khau" value="" name="discount"></label><br>
    <input type="submit" value="Calculate discount">
  </form>




  </body>
</html>
