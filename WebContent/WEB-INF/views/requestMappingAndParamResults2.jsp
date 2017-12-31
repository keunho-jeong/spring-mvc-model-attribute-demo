<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>RequestMapping test Results2</title>
</head>
<body>
	<div align="center">
		<h1>${testSerial}@RequestMapping Test Results</h1>
		<c:forEach var="parameter" items="${param}">
			<h3 style="color:#DF0101"><c:out value="${parameter.key}"></c:out>
			= <c:out value="${parameter.value}"></c:out>
			</h3>
		</c:forEach>
	</div>
</body>
</html>