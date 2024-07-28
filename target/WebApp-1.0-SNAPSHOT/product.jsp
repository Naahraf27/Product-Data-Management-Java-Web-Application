<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page import="uk.ac.ucl.model.ListItemEntity" %>

<html>
<head>
  <title>Product Information</title>
</head>
<body>
<h1>Product Information</h1>

<%
  String productCode = request.getParameter("productCode");
  Model model = ModelFactory.getModel();
  ListItemEntity product = null;

  if (productCode != null) {
    product = model.getProductByCode(productCode);
  } else {
    product = (ListItemEntity)request.getAttribute("product");
  }
%>

<% if (product != null) { %>
<table>
  <tr>
    <th>Name</th>
    <td><%= product.getName() %></td>
  </tr>
  <tr>
    <th>Type</th>
    <td><%= product.getType() %></td>
  </tr>
  <tr>
    <th>Product-Code</th>
    <td><%= product.getProductCode() %></td>
  </tr>
  <tr>
    <th>Price</th>
    <td><%= product.getPrice() %></td>
  </tr>
</table>
<% } else { %>
<p>No product found.</p>
<% } %>

<a href="productList">Back to Product List</a>

</body>
</html>
