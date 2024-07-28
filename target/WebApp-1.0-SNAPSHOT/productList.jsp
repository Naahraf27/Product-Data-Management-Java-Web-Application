<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ListItemEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Product Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Products:</h2>
  <ul>
    <%
      List<ListItemEntity> products = (List<ListItemEntity>) request.getAttribute("products");
      for (ListItemEntity product : products)
      {
        String href = "product.jsp?productCode=" + product.getProductCode();
    %>
    <!-- <li><a href="<%=href%>"><%=product.getProductCode()%></a>
    </li> -->
    <li>
      <a href="<%=href%>"><%=product.getProductCode()%></a>
      <a href="deleteProduct?productCode=<%=product.getProductCode()%>">(Delete)</a>
    </li>
    <% } %>
  </ul>
</div>
<a href="index.html">Back to Main Menu</a>
<jsp:include page="/footer.jsp"/>
</body>
</html>
