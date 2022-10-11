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
<h1>Edit Product</h1>
<form action="${pageContext.request.contextPath }/process-edit-product" method="get">
<input type="hidden" name="id" value="${product.id}" />
<label>Product Title: </label>
<input type="text" name="title" value="${product.title}" /> <br /> <br />
<label>Product Price: </label>
<input type="number" name="price" value="${product.price}" /> <br /> <br />
<label>Product Vendor: </label>
<input type="text" name="vendor" value="${product.vendor}" /> <br /> <br />
<input type="submit" value="Edit product">
</form>
</body>
</html>