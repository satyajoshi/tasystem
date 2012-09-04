<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Help</title>
</head>
<body>
<center>

<br/>
<br/>
<br/>

<font color="red">
<c:if test="${not empty emailerror}">
    <c:out value="${emailerror}"/>
</c:if>
</font>


	<h2 style="color: blue; margin-top: 50px;">Enter your registered email address below:</h2>
	<form action="getpassword" method="post">
		<input type="text" name="email" size="30">
		<input type="submit" name="Submit" value="Submit"/>
	</form>
</center>


</body>
</html>