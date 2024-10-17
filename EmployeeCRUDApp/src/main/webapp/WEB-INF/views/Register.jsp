<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="st" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
	h1{
		color: yellow;
		background-color: black;
		text-align: center;
	}
	.form{
		color: blue;
		align-self: center;
	}
</style>
</head>
<body>
	<h1 ><st:message code="register.header.register.employee"/></h1>
	
	<sf:form action="${action}?id=${beanId}" modelAttribute="bean" method="POST">
		<div align="center" >
			<table class="form">
				<tr>
					<th><st:message code="register.fname"/></th>
					<td><sf:input path="name.fname"/></td>
					<td><sf:errors path="name.fname"/> </td>
				</tr>
				<tr>
					<th><st:message code="register.lname"/></th>
					<td><sf:input path="name.lname"/></td>
					<td><sf:errors path="name.lname"/> </td>
				</tr>
				<tr>
					<th><st:message code="register.dob"/></th>
					<td><sf:input path="dob"/></td>
					<td><sf:errors path="dob"/> </td>
				</tr>
				<tr>
					<th><st:message code="register.salary"/></th>
					<td><sf:input path="salary"/></td>
					<td><sf:errors path="salary"/> </td>
				</tr>
				<tr>
					<th><st:message code="register.gender"/></th>
					<td><sf:select path="gender">
						<sf:option value="MALE">MALE</sf:option>
						<sf:option value="FEMALE">FEMALE</sf:option>
					</sf:select> </td>
					<td><sf:errors path="gender"/> </td>
				</tr>
				<tr>
					<th colspan="2" style="color: black;"><st:message code="register.address"/></th>
				</tr>
				<tr>
					<th><st:message code="register.address.street"/></th>
					<td><sf:input path="address.street"/></td>
					<td><sf:errors path="address.street"/> </td>
				</tr>
				<tr>
					<th><st:message code="register.address.city"/></th>
					<td><sf:input path="address.city"/></td>
					<td><sf:errors path="address.city"/> </td>
				</tr>
				<tr>
					<th><st:message code="register.address.pin"/></th>
					<td><sf:input path="address.pinCode"/></td>
					<td><sf:errors path="address.pinCode"/> </td>
				</tr>
				<tr></tr>
				<tr>
					<th colspan="2" style="color: black;"><st:message code="register.phonenumber"/></th>
				</tr>
				<tr>
					<th><st:message code="register.phonenumber.countrycode"/></th>
					<td><sf:input path="phoneNumber.countryCode"/></td>
					<td><sf:errors path="phoneNumber.countryCode"/> </td>
				</tr>
				<tr>
					<th><st:message code="register.phonenumber.number"/></th>
					<td><sf:input path="phoneNumber.number"/></td>
					<td><sf:errors path="phoneNumber.number"/> </td>
				</tr> 
				<tr>
					<th><st:message code="register.email"/></th>
					<td><sf:input path="email"/></td>
					<td><sf:errors path="email"/> </td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="${submit}"> </td>
				</tr>
			</table>
		</div>
	</sf:form>
	
</body>
</html>