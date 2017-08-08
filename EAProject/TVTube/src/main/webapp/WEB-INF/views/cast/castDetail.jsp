<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cast Detail</title>
</head>
<body>
	<h1>Cast Details</h1>
	</br>
	<form action="../detail/${cast.castId}" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${cast.name}" /> </td>
		</tr>
		<tr>
			<td>Character Name:</td>
			<td><input type="text" name="characterName" value="${cast.characterName}" /> </td>
		</tr>
		<tr>
			<td>Place Of Birth:</td>
			<td><input type="text" name="placeOfBirth" value="${cast.placeOfBirth}" /> </td>
		</tr>
		<tr>
			<td>Biography:</td>
			<td><input type="text" name="biography" value="${cast.biography}" /> </td>
		</tr>
	</table>
	<input type="submit" value="Update"/>
	</form>
	<form action="../delete/${cast.castId}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>