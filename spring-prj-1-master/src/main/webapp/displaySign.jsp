<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>打卡列表</title>
</head>
<body>
<center>打卡列表</center>
<table border=1>
    <tr>
        <th>打卡ID</th>
        <th>打卡名</th>
        <th>打卡描述</th>
        <th>打卡发布日期</th>
        <th>教师id</th>
    </tr>
    <s:iterator value="signs">
        <tr>
            <td>
                <a href="./getSignInstance?signID=${signID}">${signID}</a></td>
            <td><s:property value="name" /></td>
            <td><s:property value="description" /></td>
            <td><s:date format="YYYY-MM-dd"  name="createTime" /> </td>
            <td><s:property value="teaID" /> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
