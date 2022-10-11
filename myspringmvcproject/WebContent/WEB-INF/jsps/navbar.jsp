<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Spring MVC App</title>
<style>
body{
	margin: 0px;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
</head>
<body>
	<div>
		<ul>
			<li><a href="<%=request.getContextPath()%>/">Home</a></li>
			<li><a href="<%=request.getContextPath()%>/products">Products</a></li>
			<li><a href="<%=request.getContextPath()%>/contact">Contact</a></li>
			<li><a href="<%=request.getContextPath()%>/about">About</a></li>
		</ul>
	</div>
</body>
</html>