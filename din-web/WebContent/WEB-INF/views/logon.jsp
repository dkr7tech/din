<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>New Page 1</title>
</head>
<%@ page import="com.audit.JaversTest"%>
<body>
 <% JaversTest test=new JaversTest();
test.listPrperties();
%> 
<table border="0" width="641" height="339">
<form:form action="home" method="post" modelAttribute="user">
	<tr>
		<td height="40" width="320">&nbsp;</td>
		<td height="40" width="305">
		<p align="center">USER LOGIN</td>
	</tr>
	<tr>
		<td height="78" width="320">&nbsp;</td>
		<td height="78" width="305">&nbsp;</td>
	</tr>
	<tr>
		<td height="40" width="320">
		<p align="right">USER NAME</td>
		<td height="40" width="305">
		<p align="center"><form:input path="login"/></td>
	</tr>
	<tr>
		<td height="48" width="320">
		<p align="right">PASSWORD</td>
		<td height="48" width="305">
		<p align="center"><form:input path="password"/></td>
	</tr>
	<tr>
		<td height="106" width="320" rowspan="2">&nbsp;</td>
		<td height="54" width="305">&nbsp;</td>
	</tr>
	<tr>
		<td height="47" width="305"><input type="submit" value="Save"></td>
	</tr>
	</form:form>
</table>

</body>

</html>