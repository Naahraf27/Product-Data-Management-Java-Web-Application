<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Product</title>
</head>
<body>
<h2>Add a New Product</h2>

<form action="addProduct" method="post">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br><br>
  <label for="type">Type:</label>
  <input type="text" id="type" name="type" required><br><br>
  <label for="productCode">Product Code:</label>
  <input type="text" id="productCode" name="productCode" required><br><br>
  <label for="price">Price:</label>
  <input type="number" id="price" name="price" step="0.01" required><br><br>
  <input type="submit" value="Add Product">
</form>

<a href="productList">Back to Product List</a>
</body>
</html>

