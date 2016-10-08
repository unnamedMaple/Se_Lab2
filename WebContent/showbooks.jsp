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
	作者:<s:property value="Authorname"/>
	出版图书：
	<table border="1" width="50%" cellpadding="0" cellspacing="0" align="center">  
		<tr style="background-color: yellow">
			<td align="center">Title</td>
			<td align="center">Delete</td>
			<td align="center">Update</td>
		</tr>  
		<s:iterator value="#request.list"> 
			<tr>
				<td align="center">
					<a href=
						<s:url value="display.action">
							<s:param name="bkISBN" value="ISBN"/>
							<s:param name="arID" value="authorID"/>
						</s:url>>
						<s:property value="title"/>
						</a>
				</td>
				<td align="center">
					<a href=
						<s:url value="delete.action">
							<s:param name="bkISBN" value="ISBN"/>
							<s:param name="arID" value="authorID"/>
						</s:url>>
						删除
					</a>
				</td>
				<td align="center">
					<a href=
						<s:url value="toupdate.action">
							<s:param name="bkISBN" value="ISBN"/>
						</s:url>>
						更新	
					</a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<a href = <s:url value="ret.action"></s:url>>返回</a>
</body>
</html>