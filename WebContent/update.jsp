<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
		<s:form action="update" method="post">
			<s:textfield name="Title" label="Title" value="%{#request.book.getTitle()}" readonly="true"></s:textfield>
			<s:textfield name="BKISBN" label="ISBN" value ="%{#request.book.getISBN()}" readonly="true"></s:textfield>
			<s:textfield name="Authorname" label="AuthorName" value="%{#request.authorname}"></s:textfield>
			<s:textfield name="Publisher" label="Publisher" value="%{#request.book.getPublisher()}"></s:textfield>
			<s:textfield name="Publishdate" label="Publishdate" value="%{#request.book.getPublishdate()}"></s:textfield>
			<s:textfield name="Price" label="Price" value="%{#request.book.getPrice()}"></s:textfield>
			<s:submit value="更新"></s:submit>
		</s:form>			
</body>
</html>