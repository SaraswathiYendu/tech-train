<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <style> 
 	body{
 		background-color: #efefef;
 		line-height: 1.3;
 	}
 	
 	.product-item{
 		display: block;
 		float: left;
 		border: 1px solid #dfdfdf;  
 		background-color: #fff;
 		width: 21%; 
 		padding: 15px;
 		margin: 10px;
 		border-radius: 10px;
 	}
 	.product-item a{
 		text-decoration: none;
 	}
 	.title-content {
 		margin-left: 10px;
 		margin-top: 15px;
 	}
 	.page-header{
 		font-family: sans-serif;
 		font-size: 2em;
 		padding: 15px;
 	}
 	.add-link a{
 	text-decoration: none;
 	}
 	.add-link  a:hover{
 	 color: black;
 	}
 	.msg{
 		border: 1px solid #cccccc; 
 		padding:9px;
 		background-color: #fefefe;
 		margin-left: 10px;
 	}
 </style>
</head>
<body >
<c:import url="navbar.jsp"/>
<section> 
<div class="title-content">
<span class="page-header"> All Products</span>
<span class="add-link">
<a href="${pageContext.request.contextPath }/show-add-product">
	+Add Product
</a>
</span>
</div>
 <c:if test="${param.msg != null}">
 	<div class="msg" >
 		<c:out value="${param.msg }"/>
 	</div>
 </c:if>
 
<c:set var="sr" value="1" />

 <c:forEach items="${productList}" var="p">
 <div class="product-item">
 		<span>Product No: <c:out value="${sr}"/> </span> <br />
 		<span>Title: <c:out value="${p.title}"/> </span> <br />
 		<span>Price: <c:out value="${p.price}"/> </span> <br />
 		<span>Price: <c:out value="${p.vendor}"/> </span>  
 		<br />
 		<a href="${pageContext.request.contextPath }/edit-product?pid=${p.id}">Edit</a> | 
 		<a href="${pageContext.request.contextPath }/delete-product?pid=${p.id}">Delete</a>
  </div>
 		<c:set var="sr" value="${sr=sr+1}"/>
 </c:forEach>
 </section>
</body>
</html>