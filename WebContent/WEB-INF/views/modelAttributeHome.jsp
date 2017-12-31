<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>@ModelAttribute Test</title>
<style type="text/css">
input[type=text] {
	padding: 10px;
	margin: 10px;
	font-size: 20px
}

input[type=submit] {
	border: none;
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	margin: 16px;
	cursor: pointer;
	font-size: 20px
}

h1, h2 {
	color: #08298A;
	text-aling: center
}
</style>
</head>
<body>
	<div align="left">
		<h1 align="center">${testdata1A}</h1>
		<hr />
		${testdata1B}
		<hr />
		${anAddress}
		<hr />
		
		<form:form action="modelAttributeTest5">
			<table>
				<tr>
					<td><form:label path="city">City Name</form:label></td>
					<td><form:input path="city"/></td>
				</tr>
				<tr>
					<td><form:label path="zipCode">Postal Code</form:label></td>
					<td><form:input path="zipCode"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" /></td>
				</tr>
			</table>
		</form:form>
		
</body>
</html>
