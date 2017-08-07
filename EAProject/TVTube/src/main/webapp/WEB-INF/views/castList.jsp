<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cast List</title>
</head>
<body>
	<h1>Casts </h1>
	<table>
	<c:forEach var="cast" items="${castList}">
	<tr>
		<td>${cast.name}</td>
		<td>${cast.characterName}</td>
		<td>${cast.placeOfBirth}</td>
		<td>${cast.biography}</td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="create"> Add a Cast</a>

</body>
</html>