<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tvseries List</title>
</head>
<body>
	<h1>Tvseries</h1>
	<table>
	<c:forEach var="tvseries" items="${tvseriesList}">
	<tr>
		<td>${tvseries.name}</td>
		<td>${tvseries.genre}</td>
		<td>${tvseries.director}</td>
		<td>${tvseries.description}</td>
		<td>${tvseries.studio}</td>
		<td>${tvseries.director}</td>
		<td><a href="detail/${tvseries.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="create">Add a Tvseries</a>

</body>
</html>