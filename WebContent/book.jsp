<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book</title>
</head>
<body>

<s:form action="addbook" method="post">
	<s:textfield name="ISBN" label="ISBN"></s:textfield>
	<s:textfield name="Title" label="Title"></s:textfield>
	<s:textfield name="Authorname" label="Authorname"></s:textfield>
	<s:textfield name="Publisher" label="Publisher"></s:textfield>
	<s:textfield name="Publishdate" label="Publishdate"></s:textfield>
	<s:textfield name="Price" label="Price"></s:textfield>
	<s:submit value="Add"></s:submit>
</s:form>
</body>
</html>