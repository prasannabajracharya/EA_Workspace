<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Season Detail</title>
</head>
<body>
	<h1>Season Details</h1>
	</br>
	<form action="../detail/${season.id}" method="post">
	<table>
		<tr>
			<td>Summary:</td>
			<td><input type="text" name="summary" value="${season.summary}" /> </td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><input type="text" name="year" value="${season.year}" /> </td>
		</tr>
		
	</table>
	<input type="submit" value="Update"/>
	</form>
	<form action="../delete/${season.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>