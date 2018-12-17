<%--
lly
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table align="center">
<tr><td>签到名称</td></tr>
<s:iterator value="results" >
<tr>
<td><s:property value="name"/></td>
</tr>
</s:iterator>
</table>
<table align="center" border="1">
<tr><td>学生姓名</td><td>学号</td><td>班级</td><td>签到情况</td></tr>
<s:iterator value="resultDetails" >
<tr>
<s:form action="changeResult" method="post">
<s:hidden name="resultDetails.Id" value="Id"/>
<td><s:property value="stu_name"/></td>
<td><s:property value="stu_id"/></td>
<td><s:property value="stu_class"/></td>
<td><s:radio name="resultDetail.isSigned" list="%{#{'true':'已到','false':'未到'}}" value="isSigned" /></td>
</s:form></tr>
</s:iterator>
</table>
</body>
</html>