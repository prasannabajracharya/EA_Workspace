<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Season List</title>
</head>
<body>
	<h1>Seasons</h1>
	<table>
	<c:forEach var="season" items="${seasonList}">
	<tr>
		<td>${season.summary}</td>
		<td>${season.year}</td>

		<td><a href="detail/${season.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="create">Add a Season</a>

</body>
</html>