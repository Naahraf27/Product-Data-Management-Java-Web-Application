<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ListItemEntity" %>

<html>
<head>
  <title>Search Results</title>
  <style>
    table {
      border-collapse: collapse;
      width: 100%;
      margin-bottom: 20px;
    }

    th, td {
      text-align: left;
      padding: 8px;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    tr:nth-child(even){background-color: #f2f2f2}
  </style>
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
