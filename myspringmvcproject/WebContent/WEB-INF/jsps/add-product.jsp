<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="navbar.jsp"/>
<h1>Add Product</h1>
<form action="${pageContext.request.contextPath }/add-product" method="get">
<label>Product Title: </label>
<input type="text" name="title" /> <br /> <br />
<label>Product Price: </label>
<input type="number" name="price" /> <br /> <br />
<label>Product Vendor: </label>
<input type="text" name="vendor" /> <br /> <br />
<input type="submit" value="Add product">
</form>
</body>
</html>