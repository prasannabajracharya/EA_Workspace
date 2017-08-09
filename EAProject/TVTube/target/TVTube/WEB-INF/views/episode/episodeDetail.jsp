<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Episode Detail</title>
</head>
<body>
	<h1>Episode Details</h1>
	</br>
	<form action="../detail/${episode.id}" method="post">
	<table>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${episode.description}" /> </td>
		</tr>
		<tr>
			<td>Aired Date:</td>
			<td><input type="text" name="airedDate" value="${episode.airedDate}" /> </td>
		</tr>
		<tr>
			<td>Comments:</td>
			<td><input type="text" name="comments" value="${episode.comments}" /> </td>
		</tr>
		<tr>
			<td>Rating:</td>
			<td><input type="text" name="rating" value="${episode.rating}" /> </td>
		</tr>
	</table>
	<input type="submit" value="Update"/>
	</form>
	<form action="../delete/${episode.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>