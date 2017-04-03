<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="login.form.title"></spring:message></title>
 <style type="text/css">
        .errors
        { 
           color: red;
        }
    </style>
</head>
<body>
<form:form commandName="login">
<form:errors cssClass="errors"/>
	<p>
		<label for="loginType"><spring:message code="login.form.type"></spring:message>	</label>
		<form:select path="loginType" items="${loginTypes }"></form:select>
	</p>
	
	<p>
		<label for="id"><spring:message code="login.form.id"/></label>
		<form:input id="id" path="id"/>
		<form:errors path="id" cssClass="errors"/>
	</p>
	<p>
		<label for="password"><spring:message code="login.form.password"/></label>
		<form:password id="password" path="password"/>
		<form:errors path="password" cssClass="errors"/>
	</p>
	<p>
		<input type="submit" value="<spring:message code="login.form.submit" />">
	</p>
</form:form>
</body>
</html>