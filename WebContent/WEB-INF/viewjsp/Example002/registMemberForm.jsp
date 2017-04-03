	<%@ page contentType="text/html; charset=EUC-KR" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>ȸ�� ��� ��</title>
	</head>
	<body>
	<form:form commandName="memberInfo">
	<p>
		<form:label path="userId">ȸ�� ID</form:label>
		<form:input path="userId" />
		<form:errors path="userId" />
	</p>
	<p>
		<form:label path="name">�̸�</form:label>
		<form:input path="name" />
		<form:errors path="name" />
	</p>
	<p>
		<form:label path="address.address1">�ּ�1</form:label>
		<form:input path="address.address1" />
		<form:errors path="address.address1" />
	</p>
	<p>
		<form:label path="address.address2">�ּ�2</form:label>
		<form:input path="address.address2" />
		<form:errors path="address.address2" />
	</p>
	<p>
		<form:label path="jobCode">����</form:label>
		<form:select path="jobCode" >
			<option value="">--- �����ϼ��� ---</option>
			<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
		</form:select>
		<form:errors path="jobCode" />
	</p>
	<p>
		<form:label path="favorites">��ȣ OS</form:label>
		<form:checkboxes items="${favoritesOsNames}" path="favorites" />
		<%--
		<form:checkbox path="favorites" value="������XP" label="������XP" />
		<form:checkbox path="favorites" value="��Ÿ" label="��Ÿ" />
		<form:checkbox path="favorites" value="������7" label="������7" />
		<form:checkbox path="favorites" value="�����" label="�����" />
		<form:checkbox path="favorites" value="��" label="��" />
		--%>
		<form:errors path="favorites" />
	</p>
	<p>
		<form:label path="tool">�ַ� ����ϴ� ������</form:label>
		<form:radiobuttons items="${tools}" path="tool" />
	</p>
	<p>
		<form:label path="etc">��Ÿ</form:label>
		<form:textarea path="etc" cols="20" rows="3"/>
	</p>
	<p>
		<form:checkbox path="contractAgreement" label="����� �����մϴ�."/>
	</p>
	<p>
		<input type="submit" value="ȸ�� ���">
	</p>
	</form:form>
	</body>
	</html>