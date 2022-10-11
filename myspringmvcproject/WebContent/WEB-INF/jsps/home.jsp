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
<c:import url="navbar.jsp" />
<div> 
Date: <c:out value="${dateVal}" /> <br /> <!-- EL: Expression Language -->
<c:out value="Hello JSTL" /> <br />	

<c:set var="x" value="5" />
<c:set var="y" value="6" /> 
<strong>x+y= <c:out value="${x+y}" /> </strong>	
</div>
</body>
</html>