<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Management</title>
<link rel="stylesheet" href="<c:url  value="/ressources.css/admin.css" />" />
<link rel="stylesheet" href="<c:url  value="/resources.css/header.css" />" />
<link rel="stylesheet"  href="<c:url  value="/resources/css/footer.css" />" />
<style>
/*body
{
color:red;
}
*/
</style>
</head>

<body>
<%@ include file="/WEB-INF/html/header.html"%>
<spring:message code="user.logged"/>: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
<br />
<a href="logout"><spring:message code="user.logout"/></a>
<h1><spring:message code="book.title"/></h1>

<sec:authorize access="hasRole('Admin')">
	<form:form action="book.do" method="POST" commandName="book">
		<table>
			<tr>
				<td><spring:message code="book.id"/></td>
				<td><form:input path="bookId" /></td>
			</tr>
			<tr>
				<td><spring:message code="book.title"/></td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="Edit" />
					<input type="submit" name="action" value="Delete" />
					<input type="submit" name="action" value="Search" />
				</td>
			</tr>
		</table>
	</form:form>
</sec:authorize>

<br>
<table border="1">
<tr>
	<th><spring:message code="book.id"/></th>
	<th><spring:message code="book.title"/></th>
</tr>
	<c:forEach items="${bookList}" var="book">
		<tr>
			<td>${book.bookId}</td>
			<td>${book.title}</td>
		</tr>
	</c:forEach>
</table>


<%@ include file="/WEB-INF/html/footer.html"%>
<script src="<c:url  value="/resources/javascript/gestionObjet.js" />"></script>

</body>
</html>