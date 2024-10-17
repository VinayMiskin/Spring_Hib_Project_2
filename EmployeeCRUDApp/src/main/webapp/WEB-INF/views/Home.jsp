<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="st"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		color: yellow;
		background-color: black;
		text-align: center;
	}
	
	table {
		border-collapse: collapse;
		width: 100%;
	}
	tr {
  		border-bottom: 2px solid #ddd;
	}
</style>
</head>
<body>
	<h1>
		<st:message code="home.header1.employee.app" />
	</h1>

	<p align="right">
		<a href="?locale=en">English</a> <a href="?locale=fr">Français</a> <a
			href="?locale=hi">हिंदी</a> <a href="?locale=kn">ಕನ್ನಡ</a>

	</p>

	<a href="toRegisterView"><st:message
			code="home.hyperlink.to.register.employee" /></a>


	<table>
		<tr>
			<th><st:message code="home.id" /></th>
			<th><st:message code="home.name" /></th>
			<th><st:message code="home.dob" /></th>
			<th><st:message code="home.salary" /></th>
			<th><st:message code="home.gender" /></th>
			<th><st:message code="home.email" /></th>
			<th><st:message code="home.phonenumber" /></th>
			<th><st:message code="home.address" /></th>
		</tr>
		<jt:forEach items="${eList}" var="bean">
			<tr>
				<td> ${bean.id} </td>
				<td> ${bean.name} </td>
				<td> ${bean.dob} </td>
				<td> ${bean.salary} </td>
				<td> ${bean.gender} </td>
				<td> ${bean.email} </td>
				<td> ${bean.phoneNumber} </td>
				<td> ${bean.address} </td>
				<td><a href="toUpdateView?id=${bean.id}">Update</a> </td>
				<td><a href="toDeleteSuccess?id=${bean.id}">Delete</a> </td>
			</tr>
		</jt:forEach>
			
		
		
	</table>

</body>
</html>