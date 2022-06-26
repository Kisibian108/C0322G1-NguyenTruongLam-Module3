<%--
  Created by IntelliJ IDEA.
  User: truonglam
  Date: 6/26/22
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
String description = request.getParameter("description");
float price = Float.parseFloat(request.getParameter("price"));
int discount_percent = Integer.parseInt(request.getParameter("discount"));
float discount = (float) (price * discount_percent * 0.01);
float total = price - discount;
%>
<h1> Product Description: <%= description %></h1>;
<h1> Product Discount Percent:<%= discount_percent %></h1>;
<h1> Product Discount :<%= discount %></h1>;
<h1> Product Total :<%= total %> </h1>

</body>
</html>
