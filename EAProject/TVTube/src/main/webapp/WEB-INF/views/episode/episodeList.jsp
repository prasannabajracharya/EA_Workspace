<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Episode List</title>
</head>
<body>
	<h1>Episodes</h1>
	<table>
	<c:forEach var="episode" items="${episodeList}">
	<tr>
		<td>${episode.rating}</td>
		<td>${episode.description}</td>
		<td>${episode.airedDate}</td>
		<td>${episode.comments}</td>
		<td><a href="detail/${episode.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="create">Add a Episode</a>

</body>
</html>