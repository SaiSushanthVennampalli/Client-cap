<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
	Update Status
	<form action="/statusCheck" modelAttribute="order" enctype="multipart/form-data">
		<br> Enter OrderID: <input type="text" name="orderId"><br>
		Update Status <input type="text" name="orderStatus"><br>
		<input type="submit" value="Submit"><br>
	</form>
</body>
</html>