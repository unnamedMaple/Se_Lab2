<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyLabrary</title>
</head>
<body>
<s:form action="search" method="post">
	<s:textfield name="Authorname" label="作者"></s:textfield>
	<s:submit value="查找"></s:submit>
</s:form>
	
</body>
</html>