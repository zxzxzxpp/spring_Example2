<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
		String servletPath = request.getRequestURI();
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�׽�Ʈ �ڵ�</title>
</head>
<body>
	<form:form action="/chap07/jsp/article/${article.id}"
		commandName="article" method="delete">
		<input type="submit" value="����">
	</form:form>

	<form:form action="/chap07/jsp/article/${article.id}"
		commandName="article" method="put">
		<input type="submit" value="����">
	</form:form>

	<form:form action="/chap07/jsp/article" commandName="article"
		method="post">
		<input type="submit" value="����">
	</form:form>
</body>
</html>
