<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ListItemEntity" %>

<html>
<head>
  <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>
<%
  String searchQuery = request.getParameter("searchstring");
  List<ListItemEntity> items = (List<ListItemEntity>)request.getAttribute("searchResults");
%>
<p>Showing search results for: <%= searchQuery %></p>
<table>
  <thead>
  <tr>
    <th>List Name</th>
    <th>Name</th>
    <th>Type</th>
    <th>Product Code</th>
    <th>Price</th>
  </tr>
  </thead>
  <tbody>
  <% for (ListItemEntity item : items) { %>
  <tr>
    <td><%= item.getName() %></td>
    <td><%= item.getType() %></td>
    <td><%= item.getProductCode() %></td>
    <td><%= item.getPrice() %></td>
  </tr>
  <% } %>
  </tbody>
</table>
<a href="listsearch.jsp">Back to Search</a>
</body>
</html>
