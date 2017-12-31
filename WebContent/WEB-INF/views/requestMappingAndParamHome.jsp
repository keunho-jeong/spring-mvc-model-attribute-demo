<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>RequestMapping And Param Demo</title>
	<style type="text/css">
		input[type=text] {
			padding:10px;
			margin:10px;
			font-size:20px
		}
		input[type=submit] {
			border:none;
			background-color:#4CAF50;
			color:white;
			padding:16px;
			margin:16px;
			cursor:pointer;
			font-size:20px
		}
		h2{
			color:#08298A;
			text-aling:center
		}
	</style>
</head>
<body>
	<div align="left">
		<h2 align="center"> Hello, Welcome</h2>
		<hr/>
		
		<form action="test1">
			<h3>test1 : </h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeHolder="Enter Organization Name" />
			<input type="submit" value="submit" />
		</form>
		<br>
		<form action="test2">
			<h3>test2 : GET</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeHolder="Enter Organization Name" />
			<input type="submit" value="submit" />
		</form>
		<br>
		<form action="test3" method=POST>
			<h3>test3 : POST</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeHolder="Enter Organization Name" />
			<input type="submit" value="submit" />
		</form>
		<br>
		<form action="test4">
			<h3>test4 : fall back</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeHolder="Enter Organization Name" />
			<input type="submit" value="submit" />
		</form>
		<br>
		<form action="test5">
			<h3>test5 : defaultValue</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeHolder="Enter Organization Name" />
			<input type="submit" value="submit" />
		</form>
		<br>
		<form action="test6">
			<h3>test6 : without name, value</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeHolder="Enter Organization Name" />
			<input type="submit" value="submit" />
		</form>
		<br>
		<form action="test7">
			<h3>test7 : Testing removal of  @RequestParam ambiguity</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgName" placeHolder="Enter Organization Name" />
			<input type="submit" value="submit" />
		</form>
	</div>
</body>
</html>