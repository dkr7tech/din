<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="../include/script/script.jsp" %>
<%@ include file="../include/jsplib/springlib.jsp" %>


<title>New or Edit User</title>
</head>


<body>
<%@ include file="../include/header.jsp" %>
	<div align="center">
		<h1>New/Edit User</h1>
		<form:form action="save2.htm" method="post" modelAttribute="userprefModel">
		<table>
			
			 <form:hidden path="userPreferenceId"/> 
			<tr>
			<td align="left">Select Date Format</td>
				<td><form:select id="permList" path="datePattern" items="${datePatternMap}" onchange="select()"/></td>
			</tr>
			<tr>
				<td align="left">Time Format</td>
				<td><form:input path="timePatternt"/></td>
			</tr>
			<tr>
				<td align="left">Currency</td>
				<td><form:input path="currencyISOCode"/></td>
			</tr>
			<tr>
				<td align="left">Percentage Formant</td>
				<td><form:input path="percentageFormat"/></td>
			</tr>
			<tr>
				<td align="left">Country</td>
				<td><form:input path="country"/></td>
			</tr>
			<tr>
				<td align="left">Language</td>
				<td><form:input path="language"/></td>
			</tr>
		    <tr>
				<td align="left">TimeZone</td>
				<td><form:input path="timezoneId"/></td>
			</tr>
			<tr>
				<td align="left">Max Row Per Page</td>
				<td><form:input path="maxRowPerPage"/></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			
		</table>
		</form:form>
	</div>
	<%@ include file="../include/footer.jsp" %>
</body>
</html>