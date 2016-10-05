<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show</title>
</head>
<body>
	作者信息
	<table border="1" width="50%" cellpadding="0" cellspacing="0" align="center">  
		<tr style="background-color: yellow">
			<td align="center">authorID</td>
			<td align="center">Name</td>
			<td align="center">age</td>
			<td align="center">country</td>
		</tr>  
		<tr>
			<td align="center"><s:property value="#request.author.authorID"/></td>
			<td align="center"><s:property value="#request.author.name"/></td>
			<td align="center"><s:property value="#request.author.age"/></td>
			<td align="center"><s:property value="#request.author.country"/></td>
		</tr>
	</table>
	图书信息
	<table border="1" width="50%" cellpadding="0" cellspacing="0" align="center">  
		<tr style="background-color: yellow">
			<td align="center">authorID</td>
			<td align="center">ISBN</td>
			<td align="center">Title</td>
			<td align="center">Publisher</td>
			<td align="center">Publishdate</td>
			<td align="center">Price</td>
		</tr>
		<tr>
			<td align="center"><s:property value="#request.book.getAuthorID()"/></td>
			<td align="center"><s:property value="#request.book.getISBN()"/></td>
			<td align="center"><s:property value="#request.book.getTitle()"/></td>
			<td align="center"><s:property value="#request.book.getPublisher()"/></td>
			<td align="center"><s:property value="#request.book.getPublishdate()"/></td>
			<td align="center"><s:property value="#request.book.getPrice()"/></td>
		</tr>
	</table>
	<a href = <s:url value="ret.action"></s:url>>返回</a>
	<s:debug></s:debug>
</body>
</html>