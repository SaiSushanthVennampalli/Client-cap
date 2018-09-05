<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!-- <button class="mainBanner__link__content__shopNow">
	      SHOP NOW
	    </button> -->
	   
	<a href="/getSortListLowToHigh""${pageContext.request.contextPath}/lowToHigh">Low
		to High </a> &nbsp;|&nbsp;
		
	<br>
	<br>
	<a href="/getSortListHighToLow""${pageContext.request.contextPath}/highToLow">High
		to Low </a>&nbsp;|&nbsp;
	<br>
	<br>
	<form action="/getSortListByRange" method="post">
		<table style="with: 50%">
			<tr>
				<td>Range:</td>
				<td><input type="text" name="min" style="font-size: 15px"></td>
				<td>to</td>
				<td><input type="text" name="max" style="font-size: 15px" /></td>
				<td><button type="submit">search</button></td>
			</tr>
		</table>
	</form>

	
	<a href="/getSortListByMostViewed" >Most Viewed</a>
	

</body>
</html>