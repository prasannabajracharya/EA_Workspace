<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tvseries Detail</title>
</head>
<body>
	<h1>Tvseries Details</h1>
	</br>
	<form action="../detail/${tvseries.id}" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${tvseries.name}" /> </td>
		</tr>
		<tr>
			<td>Genre:</td>
			<td><input type="text" name="genre" value="${tvseries.genre}" /> </td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${tvseries.description}" /> </td>
		</tr>
		<tr>
			<td>Studio:</td>
			<td><input type="text" name="studio" value="${tvseries.studio}" /> </td>
		</tr>
		<tr>
			<td>Director:</td>
			<td><input type="text" name="director" value="${tvseries.director}" /> </td>
		</tr>

	</table>
	<input type="submit" value="Update"/>
	</form>
	<form action="../delete/${tvseries.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>