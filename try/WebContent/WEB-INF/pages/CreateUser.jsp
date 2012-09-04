<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> --%>
<%-- <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<center>
<h2 style="color:grey; text-decoration: underline; margin-bottom:30px; margin-top:100px;" > Please fill in the form below: </h2>

<div style="color:red;">
</div>


<font color="red">
<c:if test="${not empty createusererrormsg}">
    <c:out value="${createusererrormsg}"/>
</c:if>
</font>

<form action="createuser" method="post">
<table style="margin-bottom:10px;">
	<tr style="margin-bottom:10px;">
	<td align="left">
	First Name
	</td>
	<td>
	<input type="text" name="firstName" size="20" />
	</td>
	</tr>
	<tr>
	<td align="left">
	Last Name
	</td>
	<td>
	<input type="text" name="lastName" size="20" />
	</td>
	</tr>
	<tr>
	<td align="left">
	Email
	</td>
	<td>
	<input type="text" name="email" size="20" />
	</td>
	</tr>
	<tr>
	<td align="left">
	Password
	</td>
	<td>
	<input type="password" name="password" size="20" />
	</td>
	</tr>
	<tr>
	<td align="left">
	Company Name
	</td>
	<td>
	<input type="text" name="companyName" size="20" />
	</td>
	</tr>
	<tr>
	<td align="left">
	Role
	</td>
	<td>
	<select name="role">
		<option value="techlead">Tech Lead</option>
		<option value="sme">SME</option>
		<option value="recruiter">Recruiter</option>
	</select>
	</td>
	</tr>
</table>

	<input type="submit" value="Submit" style="margin-top:10px;"/>
</form>
</center>

</body>
</html>